package Entidades;

import Visitors.Visitor;

public class PremioTemporal extends Premio {
	protected int duracion;
	
	public PremioTemporal() {
		super();
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
