package Entidades;

import Movimientos.Vertical;

public abstract class Premio extends Entidad {

	public Premio() {
		super();
		movimiento = new Vertical(this,Vertical.ABAJO);
	}


}
