package Entidades;

import java.awt.Point;

import EntidadesGraficas.Label_proyectil_normal;
import Visitors.Visitor;

public class ProyectilNormal extends ProyectilSanitario {

	public ProyectilNormal(Point posicion) {
		super(new Label_proyectil_normal(posicion));
		velocidad = 6;
		damage = 5;
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
