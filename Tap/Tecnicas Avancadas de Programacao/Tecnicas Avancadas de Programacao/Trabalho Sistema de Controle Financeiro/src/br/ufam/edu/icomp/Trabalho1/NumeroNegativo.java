package br.ufam.edu.icomp.Trabalho1;

public class NumeroNegativo extends Exception {
	private static final long serialVersionUID = 1L;
	
	public NumeroNegativo() {
		super();
	}
	
	public NumeroNegativo(String s) {
		super(s);
	}
	
	public String getMessage() {
		return "[ERRO] Numero negativo detectado!";
	}
	
}
