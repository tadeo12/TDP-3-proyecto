package Entidades;

import EntidadesGraficas.Entidad_grafica;
import Visitors.Visitor;

public class SuperProyectil extends ProyectilSanitario {

	public SuperProyectil(Entidad_grafica entidad) {
		super(entidad);
		// TODO Auto-generated constructor stub
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
