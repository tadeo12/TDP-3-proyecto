package Entidades;

import EntidadesGraficas.Entidad_grafica;
import Movimientos.Vertical;

public abstract class Premio extends Entidad {

	public Premio(Entidad_grafica entidad) {
		super(entidad);
		movimiento = new Vertical(this,Vertical.ABAJO);
	}


}
