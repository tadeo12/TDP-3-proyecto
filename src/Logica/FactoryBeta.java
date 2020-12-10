package Logica;


import java.awt.Point;
import Entidades.Infectado;
import Entidades.InfectadoBeta;

/**
 * clase que se encarga de construir los infectados de tipo Beta
 */
public class FactoryBeta extends Factory {

	public FactoryBeta() {
		super();
	}

	@Override
	public Infectado crearInfectado(boolean enEspera) {
		Point p = posicion();
		Infectado inf = new InfectadoBeta(p, tiempo, enEspera);
		tiempo = tiempo + 2000;//cada infectado aparece con una diferencia de 2 segundos
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
