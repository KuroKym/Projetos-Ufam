package br.ufam.edu.icomp.Trabalho1;

public class DespesaComTerceirosPessoaFisica extends Despesa {
	private String responsaveis;
	private int dia;
	private int mes;
	private int ano;
	
	public DespesaComTerceirosPessoaFisica(String descricao, String responsaveis, double valor, int dia, int mes, int ano) throws NumeroNegativo, DataInvalida{
		super(descricao, valor);
		if(dia < 0 || mes < 0 || ano < 0) throw new NumeroNegativo();
		if(dia > 32 || mes > 12 || ano > 2023 || ano < 1900) throw new DataInvalida();
		setResponsaveis(responsaveis);
		setDia(dia);
		setMes(mes);
		setAno(ano);
	}
	
	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public String getResponsaveis() {
		return responsaveis;
	}

	public void setResponsaveis(String responsaveis) {
		this.responsaveis = responsaveis;
	}
	
	public String getDescricao() {
		return toString() + "\tResponsaveis: " + getResponsaveis() + "\n\tData do servico: " + getDia() + "/" + getMes() + "/" + getAno() + "\n";
	}
}
