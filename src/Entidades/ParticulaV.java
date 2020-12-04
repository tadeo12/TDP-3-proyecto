package Entidades;

import EntidadesGraficas.Entidad_grafica;
import Movimientos.Vertical;
import Movimientos.VerticalRemoveRango;
import Movimientos.Vertical_remove;
import Visitors.Visitor;
import Visitors.VisitorParticulaV;

public abstract class ParticulaV extends Proyectil {
	
	protected int rango;
	
	public ParticulaV(Entidad_grafica entidad_graf) {
		super(entidad_graf);
		
		visitor = new VisitorParticulaV(this);
		
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	public int getRango() {
		return rango;
	}
}
