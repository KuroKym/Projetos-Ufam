package br.edu.ufam.icomp.lab_encapsulamento;

public class GISMain {

    public static void main(String[] args) {
        Localizavel[] vetorLocalizaveis = new Localizavel[2];

        vetorLocalizaveis[0] = new Celular(55, 92, 123456789);
        vetorLocalizaveis[1] = new CarroLuxuoso("OAK1 - 9323");

        for (int i = 0; i < vetorLocalizaveis.length; i++) {
            System.out.println(vetorLocalizaveis[i].getPosicao());
        }
    }
}
