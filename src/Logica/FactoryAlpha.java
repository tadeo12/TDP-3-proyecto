package Logica;

import java.awt.Point;
import Entidades.Infectado;
import Entidades.InfectadoAlpha;

public class FactoryAlpha extends Factory {

	public FactoryAlpha() {
		super();
	}

	@Override
	public Infectado crearInfectado(boolean enEspera) {
		Point p = posicion();
		Infectado inf = new InfectadoAlpha(p, tiempo, enEspera);
		tiempo = tiempo + 5000;
		return inf;
	}

	private Point posicion() {
		return new Point(r.nextInt(mapa.getWidth() - 60), -100);
	}

	@Override
	protected void reiniciar() {
		tiempo = 1;
	}

}
