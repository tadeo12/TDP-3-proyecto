package Entidades;

import java.awt.Point;

import EntidadesGraficas.Entidad_grafica;
import EntidadesGraficas.Label_super_proyectil;
import Visitors.Visitor;

public class SuperProyectil extends ProyectilSanitario {

	public SuperProyectil(Point p) {
		super(new Label_super_proyectil(p));
		visitor.setEntidad(this);
		damage = 10;
		velocidad = 4;
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
