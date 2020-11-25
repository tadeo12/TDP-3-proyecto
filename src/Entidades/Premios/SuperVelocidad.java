package Entidades.Premios;

import java.awt.Point;

import EntidadesGraficas.Label_super_velocidad;
import Visitors.Visitor;

public class SuperVelocidad extends PremioTemporal {

	public SuperVelocidad(Point p) {
		super();
		entidad_graf = new Label_super_velocidad(p);
		duracion = 60;
	}
	
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
