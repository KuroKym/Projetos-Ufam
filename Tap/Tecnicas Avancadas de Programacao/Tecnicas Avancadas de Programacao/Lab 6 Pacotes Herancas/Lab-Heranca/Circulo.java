package br.edu.icomp.ufam.lab_heranca;

public class Circulo extends FormaGeometrica{
    public double raio;
    public double pi = Math.PI;

    public Circulo(){}
    public Circulo(int posX, int posY, double raio){
        this.posX = posX;
        this.posY = posY;
        this.raio = raio;
    }

    public double getArea(){
        return pi*raio*raio;
    }

    public double getPerimetro(){
        return 2*pi*raio;
    }

    public String toString(){
        return "Círculo na " + getPosString() + " com raio de " + raio + "cm" + "(área=" + getArea() + "cm2, " + "perímetro=" + getPerimetro() + "cm)";
    }
}
