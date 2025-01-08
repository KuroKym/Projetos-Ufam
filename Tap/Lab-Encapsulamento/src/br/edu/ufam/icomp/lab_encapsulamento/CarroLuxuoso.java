package br.edu.ufam.icomp.lab_encapsulamento;

import java.util.Random;

public class CarroLuxuoso extends Carro implements Localizavel {

	public CarroLuxuoso(String placa) {
		super(placa);
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
		return 15.0;
	}
	
	
	
}
