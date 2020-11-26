package Entidades.Premios;

import java.awt.Point;

import EntidadesGraficas.Entidad_grafica;
import Visitors.Visitor;

public abstract class PremioTemporal extends Premio {
	protected int duracion;

	public PremioTemporal(Entidad_grafica entidad_graf) {
		super(entidad_graf);
		
	}

	public int getDuracion() {
		return duracion;
	}
	
	public abstract void accept(Visitor visitor);
}