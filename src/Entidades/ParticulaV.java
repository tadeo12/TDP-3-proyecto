package Entidades;

import EntidadesGraficas.Entidad_grafica;
import Movimientos.Vertical;
import Visitors.Visitor;

public class ParticulaV extends Proyectil {

	public ParticulaV(Entidad_grafica entidad) {
		super(entidad);
		movimiento = new Vertical(this, Vertical.ABAJO);
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
