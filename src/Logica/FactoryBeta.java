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
		tiempo=1;
		mapa=Juego.getJuego().getMapa();
		r=new Random();
	}
	
	@Override
	public Infectado crearInfectado(boolean enEspera) { 
 		Point p = posicion();
		Infectado inf= new InfectadoBeta(p,tiempo, enEspera);
		tiempo=tiempo+2000 ;
		return inf;
	}

	private Point posicion() {
		return new Point(r.nextInt(mapa.getWidth()-60),-100);
	}

	@Override
	protected void reiniciar() {
		tiempo=1;
		
	}

}
