package Entidades.Premios;

import Entidades.Entidad;
import Movimientos.Vertical;
import Visitors.Visitor;

public abstract class Premio extends Entidad {

	public Premio() {
		super();
		movimiento = new Vertical(this,Vertical.ABAJO);
	}
	
	public abstract void accept(Visitor visitor);
}
