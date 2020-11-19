package Movimientos;

import java.awt.Container;
import java.awt.Rectangle;

import Entidades.Entidad;
import EntidadesGraficas.Entidad_grafica;

public class Horizontal extends EstrategiaMovimiento {
	public static final int DERECHA = 1;
	public static final int IZQUIERDA = -1;

	public Horizontal(Entidad entidad, int direccion) {
		super(entidad, direccion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void mover() {
		Entidad_grafica g = this.entidad.getGrafico();
		int siguientePosX = g.getX() + this.direccion * entidad.getVelocidad();
		if (siguientePosX > limiteX)
			g.setLocation(limiteX, g.getY());
		else {
			if (siguientePosX < 0)
				g.setLocation(0, g.getY());
			else
				g.setLocation(siguientePosX, g.getY());
		}

	}
}
