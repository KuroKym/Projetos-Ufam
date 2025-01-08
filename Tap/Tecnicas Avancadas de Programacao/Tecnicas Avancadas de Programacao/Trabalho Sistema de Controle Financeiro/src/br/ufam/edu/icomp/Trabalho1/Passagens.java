package br.ufam.edu.icomp.Trabalho1;

public class Passagens extends Diarias {
	private String empresa;
	
	public Passagens(String descricao, String local, String nomeEvento, String empresa, double valor, int dia, int mes, int ano) throws NumeroNegativo, DataInvalida {
		super(descricao, local, nomeEvento, valor, dia, mes, ano);
		if(dia < 0 || mes < 0 || ano < 0) throw new NumeroNegativo();
		if(dia > 32 || mes > 12 || ano > 2023 || ano < 1900) throw new DataInvalida();
		setEmpresa(empresa);
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	
	public String pegarDescricao() {
		return getDescricao() + "\tEmpresa: " + getEmpresa() + "\n";
	}
}
