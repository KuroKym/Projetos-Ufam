package br.edu.ufam.icomp.lab_excecoes;

public class RoverCoordenadaException extends RoverException {
	private static final long serialVersionUID = 1L;
	public RoverCoordenadaException() {
		super();
	}
	public RoverCoordenadaException(String s) {
		super(s);
	}
	public String getMessage() {
		return "Exceção geral de coordenada do rover";
	}
}
