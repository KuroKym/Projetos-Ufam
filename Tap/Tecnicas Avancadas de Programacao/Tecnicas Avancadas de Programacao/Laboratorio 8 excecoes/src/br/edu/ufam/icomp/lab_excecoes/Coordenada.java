package br.edu.ufam.icomp.lab_excecoes;
import java.lang.Math;

public class Coordenada {
	private int posX;
	private int posY;
	private int digito;
	
	public Coordenada(int posX, int posY, int digito) throws CoordenadaNegativaException, CoordenadaForaDosLimitesException, DigitoInvalidoException{
		if(posX < 0 || posY < 0) throw new CoordenadaNegativaException();
		if(posX > 30000 || posY > 30000) throw new CoordenadaForaDosLimitesException();
		if((posX + posY)%10 != digito) throw new DigitoInvalidoException();
		setPosX(posX);
		setPosY(posY);
		setDigito(digito);
	}
	
	public int getPosX() {
		return posX;
	}
	
	public int getPosY() {
		return posY;
	}

	public int getDigito() {
		return digito;
	}
	
	public void setPosX(int posX) {
		this.posX = posX;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	public void setDigito(int digito) {
		this.digito = digito;
	}
	
	public double distancia(Coordenada coordenada) {
		return Math.sqrt(Math.pow(coordenada.getPosX()-getPosX(), 2) + Math.pow(coordenada.getPosY()-getPosY(),  2));
	}
	
	public String toString() {
		return getPosX() + ", " + getPosY();
	}

	
	
	
}
