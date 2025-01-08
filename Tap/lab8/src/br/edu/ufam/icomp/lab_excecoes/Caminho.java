package br.edu.ufam.icomp.lab_excecoes;

public class Caminho {
	private Coordenada caminho[];
	private int tamanho;
	
	public Caminho(int maxTam) {
		this.caminho = new Coordenada[maxTam];
		this.tamanho = 0;
	}
	
	public int tamanho() {
		return this.tamanho;
	}
	
	public void addCoordenada(Coordenada coordenada) throws TamanhoMaximoExcedidoException, DistanciaEntrePontosExcedidaException  {
		if(tamanho() >= caminho.length) throw new TamanhoMaximoExcedidoException();
		if(tamanho == 0) {
			caminho[0] = coordenada;
			tamanho++;
		}
		else {
			if(caminho[tamanho()-1].distancia(coordenada) > 15) throw new DistanciaEntrePontosExcedidaException();
			caminho[tamanho()] = coordenada;
			tamanho++;
		}
	}
	
	public int getTamanho() {
		return tamanho;
	}
	
	public void reset() {
		caminho = new Coordenada[0];
	}
	
	public String toString() {
		String retorno =  "Dados do caminho:\n - Quantidade de pontos: " + tamanho() + "\n - Pontos: ";
		for(int i = 0; i < tamanho(); i++) {
			retorno += "-> " + caminho[i].toString();
		}
		
		return retorno;
	}
	
	
}
