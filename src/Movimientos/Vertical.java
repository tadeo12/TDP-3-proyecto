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
		g.setLocation(g.getX(), g.getY() + this.direccion * entidad.getVelocidad());
		if(direccion==ABAJO) {
			if(g.getY()>limiteY)
				g.setLocation(g.getX(), limiteY);
		}
		else {
			if(g.getY()<0)
				g.setLocation(g.getX(),0);
		}
	}

}
