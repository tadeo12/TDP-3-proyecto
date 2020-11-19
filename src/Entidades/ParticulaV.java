package Entidades;

import Movimientos.Vertical;
import Visitors.Visitor;

public class ParticulaV extends Proyectil {

	public ParticulaV() {
		super();
		movimiento = new Vertical(this, Vertical.ABAJO);
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
