package br.ufam.edu.icomp.Trabalho1;

public class Despesa {
	private String descricaoDespesa;
	private double valor;
	
	public Despesa(String descricaoDespesa, double valor) throws NumeroNegativo{
		if(valor < 0) throw new NumeroNegativo();
		setDescricao(descricaoDespesa);
		setValor(valor);
	}

	public String getDescricaoDespesa() {
		return descricaoDespesa;
	}

	public void setDescricao(String descricaoDespesa) {
		this.descricaoDespesa = descricaoDespesa;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public String toString() {
		return "\tDescricao: " + getDescricaoDespesa() + "\n\tValor: R$ " + getValor() + "\n";
	}
}