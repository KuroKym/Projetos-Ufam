package br.ufam.edu.icomp.Trabalho1;

public class Diarias extends Despesa {
	private String local;
	private String nomeEvento;
	private int dia;
	private int mes;
	private int ano;
	
	public Diarias(String descricao, String local, String nomeEvento, double valor, int dia, int mes, int ano) throws NumeroNegativo, DataInvalida {
		super(descricao, valor);
		if(valor < 0 || dia < 0 || mes < 0 || ano < 0) throw new NumeroNegativo();
		if(dia > 32 || mes > 12 || ano > 2023 || ano < 1900) throw new DataInvalida();
		setLocal(local);
		setNomeEvento(nomeEvento);
		setDia(dia);
		setMes(mes);
		setAno(ano);
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getNomeEvento() {
		return nomeEvento;
	}

	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
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

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}
	
	public String getDescricao() {
		return toString() + "\tLocal: " + getLocal() + "\n\tNome do Evento: " + getNomeEvento() + 
				"\n\tData da viagem: " + getDia() +	"/" + getMes() + "/" + getAno() + "\n";
	}
}
