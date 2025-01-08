import matplotlib.pyplot as plt
import psycopg2
import threading
import random
import time
from tabulate import tabulate
import pandas as pd

# Configuração do banco
def load_config():
    config = {
        'host': 'localhost',
        'database': 'aviao',
        'user': 'postgres',
        'password': 'test123'
        }
    return config


def create_database(config):
    """ Criar o banco de dados com o nome especificado na configuração """
    try:
        # Conectar ao PostgreSQL sem especificar um banco de dados
        connection = psycopg2.connect(
            host=config['host'],
            user=config['user'],
            password=config['password']
        )
        connection.autocommit = True  # Para permitir a criação do banco de dados

        with connection.cursor() as cursor:
            cursor.execute(f"CREATE DATABASE {config['database']};")
            print(f"Bando de dados '{config['database']}' criado com sucesso.")

    except psycopg2.errors.DuplicateDatabase:
        print(f"O banco de dados '{config['database']}' já existe.")
    except (psycopg2.DatabaseError, Exception) as error:
        print(f"Erro ao criar o banco de dados: {error}")
    finally:
        if connection:
            connection.close()


def connect(config):
    """ Connect to the PostgreSQL database server """
    try:
        with psycopg2.connect(**config) as conn:
            #print('Connected to the PostgreSQL server.')
            return conn
    except (psycopg2.DatabaseError, Exception) as error:
        print(error)


def create_tables(conn):
    commands = [
        """
        CREATE TABLE IF NOT EXISTS assento (
            num_voo INTEGER,
            disp BOOLEAN
        )
        """
    ]

    try:
        with conn.cursor() as cur:
            for command in commands:
                cur.execute(command)
                print(f"Executed command: {command}")
            conn.commit()
            print('Tables created successfully.')
    except (psycopg2.DatabaseError, Exception) as error:
        print(f'Error creating tables: {error}')



def initialize_assentos(conn):
    """ Initialize the Assento table with num_voo from 1 to 200 and disp as True """
    try:
        with conn.cursor() as cur:
            for num_voo in range(1, 201):
                cur.execute("INSERT INTO Assento (num_voo, disp) VALUES (%s, %s)", (num_voo, True))
            conn.commit()
            print('Assento table initialized successfully.')
    except (psycopg2.DatabaseError, Exception) as error:
        print(f'Error initializing Assento table: {error}')



def reservar_assento_versao_a(conn, tentativas):
    """ Reserva um assento disponível em uma única transação """
    tentativas_locais = 0
    while True:
        try:
            with conn.cursor() as cur:
                tentativas_locais += 1

                # Recuperar todos os assentos
                cur.execute("SELECT num_voo FROM assento")
                assentos = cur.fetchall()

                if not assentos:
                    print("Não há assentos disponíveis.")
                    return tentativas_locais

                # Escolher um assento aleatoriamente
                assento_escolhido = random.choice(assentos)[0]
                time.sleep(1)  # Simular o tempo de escolha de 1 segundo

                # Verificar se o assento já está reservado
                cur.execute("SELECT disp FROM assento WHERE num_voo = %s", (assento_escolhido,))
                status = cur.fetchone()
                if not status or not status[0]:  # Se o assento não está disponível, tentar novamente
                    print(f"Assento {assento_escolhido} já está reservado. Tentando novamente.")
                    continue

                # Registrar a reserva do assento escolhido
                cur.execute("UPDATE assento SET disp = FALSE WHERE num_voo = %s", (assento_escolhido,))
                conn.commit()
                print(f"Assento {assento_escolhido} reservado com sucesso.")
                break
        except psycopg2.DatabaseError as error:
            print(f"Erro ao reservar assento: {error}")
            conn.rollback()
    tentativas.append(tentativas_locais)


def reservar_assento_versao_b(conn, tentativas):
    """ Reserva um assento disponível com duas transações separadas """
    tentativas_locais = 0
    while True:
        try:
            tentativas_locais += 1

            # Recuperar todos os assentos
            with conn.cursor() as cur:
                cur.execute("SELECT num_voo FROM assento")
                assentos = cur.fetchall()

            if not assentos:
                print("Não há assentos disponíveis.")
                return tentativas_locais

            # Escolher um assento aleatoriamente
            assento_escolhido = random.choice(assentos)[0]
            time.sleep(1)  # Simular o tempo de escolha de 1 segundo

            # Verificar se o assento já está reservado
            with conn.cursor() as cur:
                cur.execute("SELECT disp FROM assento WHERE num_voo = %s", (assento_escolhido,))
                status = cur.fetchone()
                if not status or not status[0]:  # Se o assento não está disponível, tentar novamente
                    print(f"Assento {assento_escolhido} já está reservado. Tentando novamente.")
                    continue

                # Registrar a reserva do assento escolhido
                cur.execute("UPDATE assento SET disp = FALSE WHERE num_voo = %s", (assento_escolhido,))
                conn.commit()
                print(f"Assento {assento_escolhido} reservado com sucesso.")
                break
        except psycopg2.DatabaseError as error:
            print(f"Erro ao reservar assento: {error}")
            conn.rollback()
    tentativas.append(tentativas_locais)

def gerar_tabela_tentativas(niveis_isolamento, num_agentes, tentativas_versao_a, tentativas_versao_b):
    rows = []
    for nivel in niveis_isolamento:
        for i, agentes in enumerate(num_agentes):
            tentativas_a = tentativas_versao_a[nivel][i]
            tentativas_b = tentativas_versao_b[nivel][i]
            rows.append({
                "Nível de Isolamento": nivel,
                "Número de Agentes": agentes,
                "Versão A - Min": min(tentativas_a),
                "Versão A - Máx": max(tentativas_a),
                "Versão A - Média": sum(tentativas_a) / len(tentativas_a),
                "Versão B - Min": min(tentativas_b),
                "Versão B - Máx": max(tentativas_b),
                "Versão B - Média": sum(tentativas_b) / len(tentativas_b),
            })
    df = pd.DataFrame(rows)
    print(tabulate(df, headers="keys", tablefmt="grid"))

def main():
    print("Iniciando a parte 5 do trabalho prático...") 
    # Carregar a configuração do banco de dados
    config = load_config()
    create_database(config)
    
    # Criação das tabelas
    conn = connect(config)
    create_tables(conn)

    # Inicialização da tabela Assento
    initialize_assentos(conn)
    # Função para executar as reservas
    def executar_reservas(versao_reserva, nivel_isolamento, k, tentativas_totais):
        print(f"Utilizando a versão {versao_reserva.__name__} da função reservar_assento com isolamento {nivel_isolamento} e {k} agentes")
        threads = []
        tentativas = []
        for i in range(k):
            thread = threading.Thread(target=versao_reserva, args=(conn, tentativas))
            threads.append(thread)
            thread.start()
        
        for thread in threads:
            thread.join()
        
        tentativas_totais.extend(tentativas)
    # Realizar experimentos com diferentes níveis de isolamento e diferentes números de agentes
    niveis_isolamento = ['READ COMMITTED', 'SERIALIZABLE']
    num_agentes = [1, 2, 4, 6, 8, 10]



    tempos_versao_a = {nivel: [] for nivel in niveis_isolamento}
    tempos_versao_b = {nivel: [] for nivel in niveis_isolamento}
    tentativas_versao_a = {nivel: [] for nivel in niveis_isolamento}
    tentativas_versao_b = {nivel: [] for nivel in niveis_isolamento}

    for nivel_isolamento in niveis_isolamento:
        with conn.cursor() as cur:
            cur.execute(f"SET SESSION CHARACTERISTICS AS TRANSACTION ISOLATION LEVEL {nivel_isolamento};")
            conn.commit()
        
        for k in num_agentes:
            # Resetar a tabela Assento
            initialize_assentos(conn)

            tentativas_a = []
            start_time = time.time()
            executar_reservas(reservar_assento_versao_a, nivel_isolamento, k, tentativas_a)
            end_time = time.time()
            tempos_versao_a[nivel_isolamento].append(end_time - start_time)
            tentativas_versao_a[nivel_isolamento].append(tentativas_a)

            # Resetar a tabela Assento
            initialize_assentos(conn)

            tentativas_b = []
            start_time = time.time()
            executar_reservas(reservar_assento_versao_b, nivel_isolamento, k, tentativas_b)
            end_time = time.time()
            tempos_versao_b[nivel_isolamento].append(end_time - start_time)
            tentativas_versao_b[nivel_isolamento].append(tentativas_b)

    # Fechar a conexão
    if conn:
        conn.close()
        print('Database connection closed.')

    # Gerar gráficos
    for nivel_isolamento in niveis_isolamento:
        plt.figure()
        plt.plot(num_agentes, tempos_versao_a[nivel_isolamento], label='Versão A')
        plt.plot(num_agentes, tempos_versao_b[nivel_isolamento], label='Versão B')
        plt.xlabel('Número de Agentes')
        plt.ylabel('Tempo de Execução (s)')
        plt.title(f'Tempo de Execução - Nível de Isolamento: {nivel_isolamento}')
        plt.legend()
        plt.show()

    # Tabela com os resultados
    gerar_tabela_tentativas(niveis_isolamento, num_agentes, tentativas_versao_a, tentativas_versao_b)

if __name__ == '__main__':
    main()