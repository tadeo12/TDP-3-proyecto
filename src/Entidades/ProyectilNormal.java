package Entidades;

import Visitors.Visitor;

public class ProyectilNormal extends ProyectilSanitario {

	public ProyectilNormal() {
		super();
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
