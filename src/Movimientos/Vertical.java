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
		int siguientePosY = g.getY() + this.direccion * entidad.getVelocidad();

		if (siguientePosY > limiteY) {
			g.setLocation(g.getX(), limiteY);
		}else 
			if (siguientePosY < 0) {
				entidad.eliminar();
				g.setLocation(g.getX(), 0);
			}else
				g.setLocation(g.getX(), siguientePosY);
		
	}

}
