package Entidades.Premios;

import Visitors.Visitor;

public class SuperVelocidad extends PremioTemporal {

	public SuperVelocidad() {
		super();
		duracion = 60;
	}
	
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
