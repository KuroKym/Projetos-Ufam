package br.edu.ufam.icomp.lab_encapsulamento;
import java.util.Random;

public class Celular implements Localizavel {
	private int codPais, codArea, numero;
	
	
	public Celular(int codPais, int codArea, int numero) {
		setCodPais(codPais);
		setCodArea(codArea);
		setNumero(numero);
	}
	
	public final void setCodPais(int codPais) {
		if (codPais <1 || codPais > 1999) {
			this.codPais = -1;
		}
		else {
			this.codPais = codPais;
		}
	}
	
	public int getCodPais() {
		return this.codPais;
	}
	
	public final void setCodArea(int codArea) {
		if (codArea <10 || codArea > 99) {
			this.codArea = -1;
		}
		else {
			this.codArea = codArea;
		}
	}
	
	public int getCodArea() {
		return codArea;
	}
	
	public final void setNumero(int numero) {
		if (numero <10000000  || numero > 999999999 ) {
			this.numero = -1;
		}
		else {
			this.numero = numero;
		}
	}
	
	public int getNumero() {
		return numero;
	}
	
	public Posicao getPosicao() {
		Random r = new Random();
		double valorMinimo = -3.160000;
		double valorMaximo = -2.960000;
		double latitude = valorMinimo + (valorMaximo - valorMinimo) * r.nextDouble();
		valorMinimo = -60.120000;
		valorMaximo = -59.820000;
		double longitude = valorMinimo + (valorMaximo - valorMinimo) * r.nextDouble();
		valorMinimo = 15.0;
		valorMaximo = 100.0;
		double altitude = valorMinimo + (valorMaximo - valorMinimo) * r.nextDouble();
		return new Posicao(latitude, longitude, altitude);
		
	}
	
	public double getErroLocalizacao() {
		return 50.0;
	}
}
