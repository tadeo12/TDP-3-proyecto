package Entidades;

import EntidadesGraficas.Entidad_grafica;
import Visitors.Visitor;

public class PremioTemporal extends Premio {
	protected int duracion;
	
	public PremioTemporal(Entidad_grafica entidad) {
		super(entidad);
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
