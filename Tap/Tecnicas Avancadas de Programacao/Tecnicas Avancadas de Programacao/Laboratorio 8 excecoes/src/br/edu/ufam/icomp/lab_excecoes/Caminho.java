package br.edu.ufam.icomp.lab_excecoes;

public class Caminho {
	private Coordenada[] caminho;
	private int tamanho;
	
	public Caminho(int maxTam) {
		caminho = new Coordenada[maxTam];
		setTamanho(maxTam);
	}

	public int tamanho() {
		int cont = 0;
		for(int i = 0; i < caminho.length; i++) {
			if(caminho[i] != null) {
				cont++;
			}
		}
		return cont;
	}
	
	public void addCoordenada(Coordenada coordenada) throws TamanhoMaximoExcedidoException, DistanciaEntrePontosExcedidaException {
		if (tamanho() == getTamanho()) {
			throw new TamanhoMaximoExcedidoException();
		} else {
			if (tamanho > 0 && caminho[tamanho - 1].distancia(coordenada) > 15) {
				throw new DistanciaEntrePontosExcedidaException();
			}
			caminho[tamanho] = coordenada;
		}
	}
	
	
	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public Coordenada[] getCaminho() {
		return caminho;
	}

	public void setCaminho(Coordenada[] caminho) {
		this.caminho = caminho;
	}
	
	public void reset() {
		caminho = new Coordenada[0];
	}
	
	public String toString() {
		String res = "Dados do caminho: \n - Quantidade de pontos: " + tamanho() + "\n - Pontos: ";
		for(int j = 0; j < tamanho(); j++) {
			res += "-> " + caminho[j].toString();
		}
		return res;
	}
}