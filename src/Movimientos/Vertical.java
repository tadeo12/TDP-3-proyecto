package Movimientos;

import Entidades.Entidad;
import EntidadesGraficas.Entidad_grafica;

public class Vertical extends EstrategiaMovimiento {
	public static final int ABAJO = 1;
	public static final int ARRIBA = -1;

	public Vertical(Entidad entidad, int direccion) {
		super(entidad, direccion);
	}

	@Override
	public void mover() {
		Entidad_grafica g = entidad.getGrafico();
		// falta controlar que no se salga del frame
		g.setLocation(g.getX(), g.getY() + this.direccion * entidad.getVelocidad());
	}

}
