package Entidades;

import Visitors.Visitor;

public class SuperProyectil extends ProyectilSanitario {

	public SuperProyectil() {
		super();
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
