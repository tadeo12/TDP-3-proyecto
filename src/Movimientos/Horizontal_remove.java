package Movimientos;

import Entidades.Entidad;
import EntidadesGraficas.Entidad_grafica;

public class Horizontal_remove extends Horizontal {

	public Horizontal_remove(Entidad entidad, int direccion) {
		super(entidad, direccion);
	}

	@Override
	public void mover() {
		Entidad_grafica g = this.entidad.getGrafico();
		int siguientePosX = g.getX() + this.direccion * entidad.getVelocidad();
		if (siguientePosX > limiteX)
			entidad.eliminar();
		else {
			if (siguientePosX < 0)
				entidad.eliminar();
			else
				g.setLocation(siguientePosX, g.getY());
		}

	}
	
}
