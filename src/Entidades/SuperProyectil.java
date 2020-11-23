package Entidades;

import EntidadesGraficas.Label_super_proyectil;
import Visitors.Visitor;

public class SuperProyectil extends ProyectilSanitario {

	public SuperProyectil() {
		super(new Label_super_proyectil());
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
