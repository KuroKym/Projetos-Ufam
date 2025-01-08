import java.text.Normalizer.Form;
import java.util.ArrayList;
package br.edu.icomp.ufam.lab_heranca;

public class FormasMain {
    FormaGeometrica formas[] = new FormaGeometrica[10];

    Circulo c1 = new Circulo(3, 5, 4);

    Quadrado q1 = new Quadrado(8, 9, 11);

    Retangulo r1 = new Retangulo(3, 4, 4, 6);

    System.out.println(c1);
    System.out.println(q1);
    System.out.println(r1);
}
