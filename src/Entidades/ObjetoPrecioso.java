package Entidades;

import EntidadesGraficas.Entidad_grafica;
import Visitors.Visitor;

public class ObjetoPrecioso extends Premio {

	public ObjetoPrecioso(Entidad_grafica entidad) {
		super(entidad);
		// TODO Auto-generated constructor stub
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
