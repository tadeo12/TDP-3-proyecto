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
		g.setLocation(g.getX() + this.direccion * entidad.getVelocidad(), g.getY());
		if(direccion==DERECHA) {
			if(g.getX()>limiteX)
				g.setLocation(limiteX, g.getY());
		}
		else {
			if(g.getX()<0)
				g.setLocation(0,g.getY());
		}
	}
}
