package Entidades;

import EntidadesGraficas.Entidad_grafica;
import EntidadesGraficas.Label_infectado;
import EntidadesGraficas.Label_particulaV;
import EntidadesGraficas.Label_particulaV_Alpha;
import EntidadesGraficas.Label_proyectil_normal;
import Movimientos.Vertical;
import Visitors.Visitor;

public abstract class ParticulaV extends Proyectil {

	public ParticulaV(Entidad_grafica entidad_graf) {
		super();
		this.entidad_graf = entidad_graf;
		movimiento = new Vertical(this, Vertical.ABAJO);
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
