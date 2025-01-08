package br.ufam.edu.icomp.Trabalho1;

public class DataInvalida extends Exception {
	private static final long serialVersionUID = 1L;
	
	public DataInvalida() {
		super();
	}
	
	public DataInvalida(String s) {
		super(s);
	}
	
	public String getMessage() {
		return "[ERRO] A data informada contem valores invalidos!";
	}
}
