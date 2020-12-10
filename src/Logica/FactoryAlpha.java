package Logica;

import java.awt.Point;
import Entidades.Infectado;
import Entidades.InfectadoAlpha;

/**
 * clase que se encarga de construir los infectados de tipo Alpha
 *
 */
public class FactoryAlpha extends Factory {

	public FactoryAlpha() {
		super();
	}

	@Override
	public Infectado crearInfectado(boolean enEspera) {
		Point p = posicion();
		Infectado inf = new InfectadoAlpha(p, tiempo, enEspera);
		tiempo = tiempo + 5000;// cada infectado aparecera con una diferencia de 5 segundos
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
