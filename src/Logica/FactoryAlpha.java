package Logica;

import java.awt.Container;
import java.awt.Point;
import java.util.Random;

import Entidades.Infectado;
import Entidades.InfectadoAlpha;
import Entidades.InfectadoBeta;

public class FactoryAlpha extends Factory {
	private Container mapa;
	private Random r;
	private int tiempo;
	
	public FactoryAlpha() {
		tiempo=1;
		mapa=Juego.getJuego().getMapa();
		r=new Random();
	}
	
	@Override
	public Infectado crearInfectado(boolean enEspera) {
		Point p=posicion();
		Infectado inf= new InfectadoAlpha(p,tiempo,enEspera);
		tiempo=tiempo+5000;
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
