package Logica;

import java.awt.Container;
import java.awt.Point;
import java.util.Random;

import Entidades.Infectado;
import Entidades.InfectadoBeta;

public class FactoryBeta extends Factory {
	private Container mapa;
	private Random r;
	private int tiempo;

	public FactoryBeta() {
		tiempo=0;
		mapa=Juego.getJuego().getMapa();
		r=new Random();
	}
	
	@Override
	public Infectado crearInfectado() {
		mapa=Juego.getJuego().getMapa();
		r=new Random();
		Point p = posicion();
		Infectado inf= new InfectadoBeta(p,tiempo);
		tiempo=tiempo+10000;
		return inf;
	}

	private Point posicion() {
		return new Point(r.nextInt(mapa.getWidth()+mapa.getX()),-100);
	}

}
