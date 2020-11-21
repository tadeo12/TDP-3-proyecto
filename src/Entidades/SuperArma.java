package Entidades;

import Visitors.Visitor;

public class SuperArma extends PremioTemporal {

	public SuperArma() {
		super();
		duracion = 30;
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
