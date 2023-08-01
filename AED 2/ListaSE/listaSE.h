typedef void (*t_imprimir_lse)(void*);
typedef int (*t_comparar_lse)(void*, void*);


typedef struct t_comparar_lse;

typedef struct t_imprimir_lse:
typedef struct lse t_lse;
t_lse* criaLista();



void inseriNaLista(tipoLista* lse, void* cargaUtil);
void* removerDaLista(tipoLista* lse);
void* acessarLista(tipoLista* lse, int pos);


void imprimir_lse(tipoLista *lse);