package br.edu.ufam.icomp.lab_excecoes;

public class excecaoMain {
	public static void main(String args[]) throws CoordenadaNegativaException, CoordenadaForaDosLimitesException, DigitoInvalidoException, TamanhoMaximoExcedidoException, DistanciaEntrePontosExcedidaException {
		Caminho c = new Caminho(6);
		
		Coordenada r1 = new Coordenada(23, 55, 8);
		c.addCoordenada(r1);
		
		Coordenada r2 = new Coordenada(27, 65, 2); 
		c.addCoordenada(r2); 
		
		System.out.println(c.tamanho());
	}
}