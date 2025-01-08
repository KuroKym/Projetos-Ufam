package br.edu.ufam.icomp.lab_excecoes;

public class RoverMain {
	public static void main(String[] args) {
			Caminho cmn = new Caminho(5);
			Coordenada cd = null;
			
			try {
				cd = new Coordenada(1,2,3);
			} 
			
			catch (CoordenadaNegativaException | CoordenadaForaDosLimitesException | DigitoInvalidoException e) {
				System.out.println("[ERRO] Verifique as coordenadas!");
				cmn.reset();
			}
			
			try {
				cmn.addCoordenada(cd);
			}
			
			catch (TamanhoMaximoExcedidoException | DistanciaEntrePontosExcedidaException e) {
				System.out.println("[ERRO] Verifique o caminho!");
			}
			
			System.out.println(cmn.toString());
		
		
	}
}
