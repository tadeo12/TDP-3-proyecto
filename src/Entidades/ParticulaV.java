package Entidades;

import Logica.Juego;
import Movimientos.Vertical;
import Visitors.Visitor;

public class ParticulaV extends Proyectil {

	public ParticulaV(Juego juego) {
		super(juego);
		movimiento = new Vertical(this, Vertical.ABAJO);
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
