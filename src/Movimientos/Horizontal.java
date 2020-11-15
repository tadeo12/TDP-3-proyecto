package Movimientos;

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
		// falta controlar que no se salga del frame
		g.setLocation(g.getX() + this.direccion * entidad.getVelocidad(), g.getY()); 
	}
}
