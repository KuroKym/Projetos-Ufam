package br.ufam.edu.icomp.Trabalho1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProjetosDAO extends SistemaBD{
	
	//cria uma lista com todos os projetos junto com um pequeno resumo de todas as despesas
	public boolean criarListaProjetosBD() {
		try {
			Statement st = conexao.createStatement();
			st.executeUpdate("CREATE TABLE listaprojetos" + 
					" (id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, " + 
					"titulo VARCHAR (50), " + 
					"professor VARCHAR(40), " + 
					"valor_previsto DECIMAL(10,2), " + 
					"valor_gasto DECIMAL(10,2), " + 
					"desp_cap DECIMAL(10,2), " + 
					"desp_mat_cons DECIMAL(10,2), " + 
					"serv_pes_fis DECIMAL(10,2), " + 
					"serv_pes_jur DECIMAL(10,2), " + 
					"diarias DECIMAL(10,2), "+
					"passagens DECIMAL(10,2), " + 
					"nome_tabela_despesas VARCHAR(20)"+
					");");
			return true;
		}catch (SQLException e) { 
			return false; }
	}
	
	//cria uma lista de despesas de um projeto de pesquisa no banco de dados
	public boolean criarListaDespesasBD(ProjetoPesquisa p, String nomeTabela) {
		try {
			Statement st = conexao.createStatement();
			st.executeUpdate("CREATE TABLE " + nomeTabela + 
					" (id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, " + 
					"tipo_despesa VARCHAR(30), " + 
					"descricao VARCHAR(50), " + 
					"valor DECIMAL(10,2), " +
					"data VARCHAR(20), " +
					"responsaveis VARCHAR(50), " +
					"local VARCHAR(40), " + 
					"nome_evento VARCHAR(50)"
					+ ");");
			return true;
		}catch (SQLException e) {
			return false; }
	}
	
	//adiciona um projeto no banco de dados com os seguintes dados
	//titulo do projeto de pesquisa, nome do professor responsavel, valor total previsto do projeto e valor gasto
	public boolean adicionarProjeto(ProjetoPesquisa p, String nomeTabela) {
		try {
			Statement st = conexao.createStatement();
			st.executeUpdate("INSERT INTO listaprojetos VALUES (NULL, "
					+ "'" + p.getNomeProjetoPesquisa()+ "'," + 
					" '" + p.getProfessorResponsavel() + "', " + 
					p.totalProjeto() + ", " +
					p.getValorGasto() + ", " +
					p.totalDespCapital() + ", " +
					p.totalDespMatCons() + ", " + 
					p.totalDespTercPesFis() + ", " + 
					p.totalDespTercPesJur() + ", " + 
					p.totalDiarias() + ", " + 
					p.totalPass() + ", '" + 
					nomeTabela + 
					"')");
			return true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false; }
	}
	
	//adiciona uma despesa de capital na lista de despesas de um projetos no banco de dados
	public boolean adicionarDespCapitalBD(String listaDespProjeto, String descricao, double valor) {
		try {
			Statement st = conexao.createStatement();
			st.executeUpdate("INSERT INTO " + listaDespProjeto + 
					" VALUES (NULL, 'Despesa de Capital', '"
					+ descricao  + "', " 
					+ valor + ", "
					+ "'---', '---', '---', '---')");
			return true;
			} catch (SQLException e) { 
				e.printStackTrace();
				return false; }
	}
	
	//remove a tabela de despesas inteira de um projeto de pesquisa do banco de dados
	public boolean removerDespesaBD(String listaDespProjeto) {
		try {
			Statement st = conexao.createStatement();
			st.executeUpdate("DROP TABLE " + listaDespProjeto);
			return true;
			} catch (SQLException e) { 
				return false; }
	}
	
	//adiciona uma despesa de material de consumo na lista de despesas de um projeto de pesquisa no banco de dados
	public boolean adicionarDespMatConsBD(String tabelaProjeto, String descricao, double valor) {
		try {
			Statement st = conexao.createStatement();
			st.executeUpdate("INSERT INTO " + tabelaProjeto + 
					" VALUES (NULL, 'Despesa Material de Consumo', '"
					+ descricao  + "', " 
					+ valor + ", "
					+ "'---', '---', '---', '---')");
			return true;
			} catch (SQLException e) { 
				e.printStackTrace();
				return false; }
	}
	
	//adiciona uma despesa com servicos de terceiros - pessoa fisica na lista de despesas de um projeto de pesquisa no banco de dados
	public boolean adicionarDespServPesFisBD(String tabelaProjeto, String descricao, double valor, int dia, int mes, int ano, String responsaveis) {
		try {
			Statement st = conexao.createStatement();
			st.executeUpdate("INSERT INTO " + tabelaProjeto + 
					" VALUES (NULL, 'Servicos Pessoa Fisica', '"
					+ descricao  + "', " 
					+ valor + ", "
					+ "'" + dia + "/" + mes + "/" + ano + "', "
					+ "'" + responsaveis + "', " + 
					"'---', '---'"
					+ ")");
			return true;
			} catch (SQLException e) { 
				e.printStackTrace();
				return false; }
	}
	
	//adiciona uma despesa com servicos de terceiros - pessoa juridica na lista de despesas de um projeto de pesquisa no banco de dados
	public boolean adicionarDespServPesJurBD(String tabelaProjeto, String descricao, double valor, int dia, int mes, int ano, String nomeEmpresa) {
		try {
			Statement st = conexao.createStatement();
			st.executeUpdate("INSERT INTO " + tabelaProjeto + 
					" VALUES (NULL, 'Servicos Pessoa Juridica', '"
					+ descricao  + "', " 
					+ valor + ", "
					+ "'" + dia + "/" + mes + "/" + ano + "', "
					+ "'" + nomeEmpresa + "', " + 
					"'---', '---'"
					+ ")");
			return true;
			} catch (SQLException e) { 
				e.printStackTrace();
				return false; }
	}
	
	//adiciona uma despesa diaria na lista de despesas de um projeto de pesquisa no banco de dados
	public boolean adicionarDespDiariasBD(String tabelaProjeto, String descricao, double valor, int dia, int mes, int ano, String local, String nomeEvento) {
		try {
			Statement st = conexao.createStatement();
			st.executeUpdate("INSERT INTO " + tabelaProjeto + 
					" VALUES (NULL, 'Diarias', '"
					+ descricao  + "', " 
					+ valor + ", "
					+ "'" + dia + "/" + mes + "/" + ano + "', " +
					"'---', " + 
					"'" + local + "', " + 
					"'" + nomeEvento + "'"
					+ ")");
			return true;
			} catch (SQLException e) { 
				e.printStackTrace();
				return false; }
	}
	
	//adiciona uma despesa com passagens na lista de despesas de um projeto de pesquisa no banco de dados
	public boolean adicionarDespPassBD(String tabelaProjeto, String descricao, double valor, int dia, int mes, int ano, String local, String nomeEvento) {
		try {
			Statement st = conexao.createStatement();
			st.executeUpdate("INSERT INTO " + tabelaProjeto + 
					" VALUES (NULL, 'Passagem', '"
					+ descricao  + "', " 
					+ valor + ", "
					+ "'" + dia + "/" + mes + "/" + ano + "', " +
					"'---', " + 
					"'" + local + "', " + 
					"'" + nomeEvento + "'"
					+ ")");
			return true;
			} catch (SQLException e) { 
				e.printStackTrace();
				return false; }
	}
	
	//remove um projeto inteiro do banco de dados atraves do titulo
	public boolean removerProjeto(String titulo) {
		try {
			Statement st = conexao.createStatement();
			st.executeUpdate("DELETE FROM listaprojetos WHERE titulo = '" + titulo + "'");
			return true;
		}catch(SQLException e) {
			return false;}
	}
	
	//remove uma despesa de um projeto de pesquisa atraves da descricao da despesa
	public boolean removerDespesaDoProjeto(String nomeTabela, String descricao) {
		try {
			Statement st = conexao.createStatement();
			st.executeUpdate("DELETE FROM " + nomeTabela +  " WHERE descricao = '" + descricao + "'");
			return true;
		}catch(SQLException e) {
			return false;}
	}
	
	//atualiza o valor de uma despesa cadastrada na tabela de listaprojetos após alguma remocao/alteracao na referida despesa
	public boolean atualizarTotalDespesaDoProjeto(String nomeTabela, String colunaDespesa, String tipoDespesa) {
		try {
			Statement st = conexao.createStatement();
			st.executeUpdate("UPDATE listaprojetos SET " + colunaDespesa + " = (SELECT SUM(valor) FROM " +  nomeTabela + 
					" WHERE tipo_despesa = '" + tipoDespesa + "') WHERE nome_tabela_despesas = '" + nomeTabela + "'");
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
			return false;}
	}
	
	//atualiza o valor previsto de um projeto no banco de dados
	public boolean atualizarValorPrevistoDoProjeto(String nomeTabela) {
		try {
			Statement st = conexao.createStatement();
			st.executeUpdate("UPDATE listaprojetos SET valor_previsto = (SELECT SUM(valor) FROM " +  nomeTabela +
					") WHERE nome_tabela_despesas = '" + nomeTabela + "'");
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
			return false;}
	}
	
	//altera o valor de uma despesa no banco de dados a partir de uma descricao
		public boolean alterarValorDespesaBD(String listaDespProjeto, String descricao, double novoValor) {
			try {
				Statement st = conexao.createStatement();
				st.executeUpdate("UPDATE " + listaDespProjeto + 
						" SET valor = " + novoValor + " WHERE descricao = '" + descricao + "'");
				return true;
				} catch (SQLException e) { 
					e.printStackTrace();
					return false; }
		}
	
	//altera o titulo de um projeto por um novo nome
	public boolean alterarTituloProjetoBD(String nomeProjetoPesquisa, String novoNome) {
		try {
			Statement st = conexao.createStatement();
			st.executeUpdate("UPDATE listaprojetos SET titulo = '" + novoNome + "' WHERE titulo = '" + nomeProjetoPesquisa + "'");
			return true;
		}catch(SQLException e) {
			return false;}
	}
	
	//altera o nome do professor responsavel pelo projeto
	public boolean alterarProfessorProjetoBD(String nomeProfessor, String novoNome) {
		try {
			Statement st = conexao.createStatement();
			st.executeUpdate("UPDATE listaprojetos SET professor = '" + novoNome + "' WHERE professor = '" + nomeProfessor + "'");
			return true;
		}catch(SQLException e) {
			return false;}
	}
	
	//altera o valor gasto no projeto
	public boolean alterarProjetoValorGastoBD(double gastoAntigo, double novoGasto) {
		try {
			Statement st = conexao.createStatement();
			st.executeUpdate("UPDATE listaprojetos SET valor_gasto = " + novoGasto + " WHERE valor_gasto = " + gastoAntigo);
			return true;
		}catch(SQLException e) {
			return false;}
	}
	
	//mostra todos os projetos com seus respectivos valores de despesas cadastradas no banco de dados
	public String mostrarProjetos() {
		String res = "";
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT titulo, professor, valor_previsto, valor_gasto, "
					+ "valor_previsto-valor_gasto as valor_disponivel, desp_cap, desp_mat_cons,"
					+ "serv_pes_fis, serv_pes_jur, diarias, passagens, nome_tabela_despesas FROM listaprojetos");
			while(rs.next()) {
				res += "Titulo: " + rs.getString(1) + 
						"\n\tProfessor Responsavel: " + rs.getString(2) +
						"\n\tValor Previsto: R$ " + rs.getDouble(3) + 
						"\n\tValor Gasto: R$ " + rs.getDouble(4) + 
						"\n\tValor Disponivel: R$ " + rs.getDouble(5) + 
						"\n\tDespesa de Capital: R$ " + rs.getDouble(6) + 
						"\n\tDespesa com Material de Consumo: R$ " + rs.getDouble(7)+
						"\n\tDespesa Servicos Pessoa Fisica: R$ " + rs.getDouble(8)+
						"\n\tDespesa Servicos Pessoa Juridica: R$ " + rs.getDouble(9)+
						"\n\tDespesa com Diarias: R$ " + rs.getDouble(10)+
						"\n\tDespesa com Passagens: R$ "+ rs.getDouble(11) + 
						"\n\tNome da Tabela de Despesas: " + rs.getString(12) + "\n\n";
			}
			return res;
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("ERRO AO MOSTRAR A LISTA DE PROJETOS CADASTRADOS NO BANCO DE DADOS!");
			return "";
		}
	}
	
	public String mostrarProjeto(String titulo) {
		String res = "";
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT titulo, professor, valor_previsto, valor_gasto, "
					+ "valor_previsto-valor_gasto as valor_disponivel, desp_cap, desp_mat_cons,"
					+ "serv_pes_fis, serv_pes_jur, diarias, passagens, nome_tabela_despesas FROM listaprojetos WHERE titulo = '" + titulo + "'");
			while(rs.next()) {
				res += "Titulo: " + rs.getString(1) + 
						"\n\tProfessor Responsavel: " + rs.getString(2) +
						"\n\tValor Previsto: R$ " + rs.getDouble(3) + 
						"\n\tValor Gasto: R$ " + rs.getDouble(4) + 
						"\n\tValor Disponivel: R$ " + rs.getDouble(5) + 
						"\n\tDespesa de Capital: R$ " + rs.getDouble(6) + 
						"\n\tDespesa com Material de Consumo: R$ " + rs.getDouble(7)+
						"\n\tDespesa Servicos Pessoa Fisica: R$ " + rs.getDouble(8)+
						"\n\tDespesa Servicos Pessoa Juridica: R$ " + rs.getDouble(9)+
						"\n\tDespesa com Diarias: R$ " + rs.getDouble(10)+
						"\n\tDespesa com Passagens: R$ "+ rs.getDouble(11) +
						"\n\tNome da Tabela de Despesas: " + rs.getString(12) + "\n\n";
			}
			return res;
		}catch(SQLException e) {
			System.out.println("ERRO AO MOSTRAR A LISTA DE PROJETOS CADASTRADOS NO BANCO DE DADOS!");
			return "";
		}
	}
	
	public String mostrarDespesasProjeto(String tabelaProjeto) {
		String res = "";
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT tipo_despesa, descricao, valor, data, responsaveis, local, nome_evento FROM " + tabelaProjeto);
			res += "Mostrando despesas cadastradas em " + tabelaProjeto;
			while(rs.next()) {
				res += "\nTipo: " + rs.getString(1) + 
						"\n\tDescricao: " + rs.getString(2) +
						"\n\tValor: R$ " + rs.getDouble(3) +
						"\n\tData: " + rs.getString(4) +
						"\n\tResponsaveis: " + rs.getString(5) + 
						"\n\tLocal: " + rs.getString(6) + 
						"\n\tNome do Evento: " + rs.getString(7) + "\n";
			}
			return res;
		}catch(SQLException e) {
			e.printStackTrace();
			return "";
		}
	}
	
	public static void main(String[] args) {
		ProjetosDAO projetosDAO = new ProjetosDAO();
		ListaProjetosPesquisa lista = new ListaProjetosPesquisa();
		projetosDAO.criarListaProjetosBD();
		
		try {
			ProjetoPesquisa p1 = new ProjetoPesquisa("Contagem das Estrelas do Ceu", "Arlindo dos Santos Lima", 2500);
			projetosDAO.criarListaDespesasBD(p1, "despesas_contagem");
			p1.adicionarNovaDespesaCapital("Comprar 5 monitores Dell 6770-X", 12000);
			projetosDAO.adicionarDespCapitalBD("despesas_contagem", "Comprar 5 monitores Dell 6770-X", 12000);
			p1.adicionarNovaDespesaCapital("Comprar 10 exemplares O Universo eh Infinito?", 570);
			projetosDAO.adicionarDespCapitalBD("despesas_contagem", "Comprar 10 exemplares O Universo eh Infinito?", 570);
			p1.adicionarNovaDespesaMaterialConsumo("Comprar 10 rolos de filme fotografico Kodak 441-M", 350);
			projetosDAO.adicionarDespMatConsBD("despesas_contagem", "Comprar 10 rolos de filme fotografico Kodak 441-M", 350);
			p1.adicionarNovaDespesaMaterialConsumo("Comprar 3 placas de video NVIDIA 4070", 15000);
			projetosDAO.adicionarDespMatConsBD("despesas_contagem", "Comprar 3 placas de video NVIDIA 4070", 15000);
			p1.adicionarNovaDespesaServicosPessoaFisica("Ajeitar o telescopio MSHX-9900", 5500, "Tiago Lima e Armandio Nogueira", 19, 3, 2001);
			projetosDAO.adicionarDespServPesFisBD("despesas_contagem", "Ajeitar o telescopio MSHX-9900", 5500, 19, 3, 2001, "Tiago Lima e Armandio Nogueira");
			p1.adicionarNovaDespesaServicosPessoaJuridica("Comprar 3 seguros de saude", 3000, "Hapvida", 9, 11, 2009);
			projetosDAO.adicionarDespServPesJurBD("despesas_contagem", "Comprar 3 seguros de saude", 3000, 9, 11, 2009, "Hapvida");
			p1.adicionarNovaDespesaDiarias("Hospedagem no Hotel Copacaba", 4750, "Hotel Copacabana", "Metodos formais de contagem infinitas", 26, 2, 2014);
			projetosDAO.adicionarDespDiariasBD("despesas_contagem", "Hospedagem no Hotel Copacaba", 4750, 26, 2, 2014, "Hotel Copacabana", "Metodos formais de contagem infinitas");
			p1.adicionarNovaDespesaPassagens("Viagem para o Rio de Janeiro", "Rio de Janeiro", "Metodos Formais de contagem infinitas", "Varig", 1400, 26, 2, 2014);
			projetosDAO.adicionarDespPassBD("despesas_contagem", "Viagem para o Rio de Janeiro", 1400, 26, 2, 2014, "Rio de Janeiro", "Metodos Formais de contagem infinitas");
			projetosDAO.adicionarProjeto(p1, "despesas_contagem");
			lista.adicionarProjeto(p1);
		}catch(NumeroNegativo e) {
			System.out.println("NUMERO NEGATIVO DETECTADO, REVEJA PARAMETROS DE PROJETO!");
		}catch(DataInvalida e) {
			System.out.println("DATA INVALIDA DETECTADA, REVEJA PARAMETROS DE PROJETO!");
		}
		
		try {
			ProjetoPesquisa p2 = new ProjetoPesquisa("Monitoria da Floresta", "Caio Bruno dos Anjos", 4000);
			projetosDAO.criarListaDespesasBD(p2, "despesas_monitoria");
			p2.adicionarNovaDespesaCapital("Comprar 3 notebooks Dell G15", 17980);
			projetosDAO.adicionarDespCapitalBD("despesas_monitoria", "Comprar 3 notebooks Dell G15", 17980);
			p2.adicionarNovaDespesaCapital("Comprar um servidor IBM-3RTU", 22350);
			projetosDAO.adicionarDespCapitalBD("despesas_monitoria", "Comprar um servidor IBM-3RTU", 22350);
			p2.adicionarNovaDespesaMaterialConsumo("Comprar 3 placas de video NVIDIA GEFORCE RTX-7700", 44500);
			projetosDAO.adicionarDespMatConsBD("despesas_monitoria", "Comprar 3 placas de video NVIDIA GEFORCE RTX-7700", 44500);
			p2.adicionarNovaDespesaServicosPessoaFisica("Calibrar o satelite BRSPACE-UX5540", 8000, "Amanda Roque e Dainara Cardoso", 4, 7, 2016);
			projetosDAO.adicionarDespServPesFisBD("despesas_monitoria", "Calibrar o satelite BRSPACE-UX5540", 8000, 4, 7, 2016, "Amanda Roque e Dainara Cardoso");
			p2.adicionarNovaDespesaServicosPessoaJuridica("Pagar a taxa de utilizacao do sistema de satelite do IBGE", 7000, "IBGE", 2, 9, 2015);
			projetosDAO.adicionarDespServPesJurBD("despesas_monitoria", "Pagar a taxa do sistema de satelite do IBGE", 7000, 2, 9, 2015, "IBGE");
			projetosDAO.adicionarProjeto(p2, "despesas_monitoria");
			lista.adicionarProjeto(p2);
		}catch(NumeroNegativo e) {
			System.out.println("NUMERO NEGATIVO DETECTADO, REVEJA PARAMETROS DE PROJETO!");
		}catch(DataInvalida e) {
			System.out.println("DATA INVALIDA DETECTADA, REVEJA PARAMETROS DE PROJETO!");
		}
		
		System.out.println(projetosDAO.mostrarProjetos());
		System.out.println(projetosDAO.mostrarDespesasProjeto("despesas_contagem"));
		System.out.println(projetosDAO.mostrarDespesasProjeto("despesas_monitoria"));
		/*
		projetosDAO.alterarValorDespesaBD("despesas_contagem", "Comprar 5 monitores Dell 6770-X", 3700);
		projetosDAO.atualizarTotalDespesaDoProjeto("despesas_contagem", "desp_cap", "Despesa de Capital");
		projetosDAO.atualizarValorPrevistoDoProjeto("despesas_contagem");
		*/
	}
}