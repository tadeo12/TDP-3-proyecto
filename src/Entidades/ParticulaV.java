package Entidades;

import EntidadesGraficas.Entidad_grafica;
import Movimientos.Vertical;
import Movimientos.Vertical_remove;
import Visitors.Visitor;
import Visitors.VisitorParticulaV;

public abstract class ParticulaV extends Proyectil {

	public ParticulaV(Entidad_grafica entidad_graf) {
		super();
		this.entidad_graf = entidad_graf;
		movimiento = new Vertical_remove(this, Vertical.ABAJO);
		visitor = new VisitorParticulaV();
		
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
