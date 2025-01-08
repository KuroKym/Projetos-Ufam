import java.util.*;

public class ListaInvertida {
	private Hashtable<String, LinkedList<String>> tabela;
	
	public ListaInvertida() {
		this.tabela = new Hashtable<>();
	}
	
	public boolean insere(String palavra, String documento) {
		if(tabela.get(palavra) != null) {
			LinkedList<String> documentList = tabela.get(palavra);
			if(!documentList.contains(documento)) {
				documentList.add(documento);
				return true;
			}
			return false;
		}else {
			LinkedList<String> newList = new LinkedList<>();
            newList.add(documento);
            tabela.put(palavra, newList);
            return true;
		}
		
	}
	
	public LinkedList<String> busca(String palavra){
		return tabela.get(palavra);
	}
	
	public String toString() {
		return tabela.toString();
	}
	
}
