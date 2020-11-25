package Entidades.Premios;

import java.awt.Point;

import Visitors.Visitor;

public abstract class PremioTemporal extends Premio {
	protected int duracion;

	public PremioTemporal() {
		super();
	}

	public int getDuracion() {
		return duracion;
	}
	
	public abstract void accept(Visitor visitor);
}
