package br.ufam.edu.icomp.Trabalho1;

public class DespesaComTerceirosPessoaJuridica extends DespesaComTerceirosPessoaFisica {
	public DespesaComTerceirosPessoaJuridica(String descricao, String responsaveis, double valor, int dia, int mes, int ano) throws NumeroNegativo, DataInvalida {
		super(descricao, responsaveis, valor, dia, mes, ano);
	}
}
