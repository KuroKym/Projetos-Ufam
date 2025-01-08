import java.util.Hashtable;
import java.util.LinkedList;

public class testehashtable{
    private Hashtable<String, LinkedList<String>> index;

    public testehashtable() {
        this.index = new Hashtable<>();
    }

    public boolean addDocument(String word, String document) {
        // Verifique se a palavra já existe na tabela hash
        if (index.containsKey(word)) {
            LinkedList<String> documentList = index.get(word);
            
            // Verifique se o documento já existe na lista
            if (!documentList.contains(document)) {
                documentList.add(document);
                return true; // Documento adicionado com sucesso
            } else {
                return false; // O documento já existe na lista
            }
        } else {
            // A palavra não existe na tabela hash, então crie uma nova lista e insira-a
            LinkedList<String> newList = new LinkedList<>();
            newList.add(document);
            index.put(word, newList);
            return true; // A palavra e o documento foram adicionados com sucesso
        }
    }

    public LinkedList<String> search(String word) {
        // Verifique se a palavra existe na tabela hash
        if (index.containsKey(word)) {
            return index.get(word);
        } else {
            return new LinkedList<>(); // Retorna uma lista vazia se a palavra não for encontrada
        }
    }

    public static void main(String[] args) {
        testehashtable searchEngine = new testehashtable();

        // Adicione alguns documentos à tabela hash
        searchEngine.addDocument("java", "documento1.txt");
        searchEngine.addDocument("java", "documento2.txt");
        searchEngine.addDocument("python", "documento3.txt");

        // Faça uma pesquisa por "java"
        LinkedList<String> results = searchEngine.search("java");

        // Exiba os resultados da pesquisa
        System.out.println("Documentos encontrados para a palavra 'java':");
        for (String document : results) {
            System.out.println(document);
        }
    }
}
