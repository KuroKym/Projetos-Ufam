package br.edu.icomp.ufam.lab_heranca;

import br.edu.icomp.ufam.lab_heranca.Retangulo;

public class Quadrado extends Retangulo {
    public Quadrado(){}
    public Quadrado(int posX, int posY, double lado){
        this.posX = posX;
        this.posY = posY;
        this.largura = lado;
        this.altura = lado;
    }

    public String toString(){
        return "Quadrado na " + getPosString() + " com lado de " + largura + "cm (área=" + getArea() + "cm2, perímetro=" + getPerimetro() + "cm)";
    }
}
