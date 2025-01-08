package br.edu.ufam.icomp.lab_encapsulamento;

public class GISMain {
    public static void main(String args[]){
    	Celular celular = new Celular(2,70,999787606);
    	CarroLuxuoso carroLuxuoso = new CarroLuxuoso("PHP-D566");
    	Localizavel localizaveis[] = new Localizavel[5];
    	localizaveis[0] = celular;
    	localizaveis[1] = carroLuxuoso;
    	
    	for(int i = 0; i < 2; i++) {
    		System.out.println(localizaveis[i].getPosicao());
    	}
    }
}