package Movimientos;

import Entidades.Entidad;
import EntidadesGraficas.Entidad_grafica;

public class Vertical_loop extends Vertical {

	public Vertical_loop(Entidad entidad, int direccion) {
		super(entidad, direccion);
	}


	public void mover() {
		Entidad_grafica g = entidad.getGrafico();
		g.setLocation(g.getX(), g.getY() + this.direccion * entidad.getVelocidad());
		if (g.getY() > limiteY)
			g.setLocation(g.getX(), 0);
	}
	 
}
