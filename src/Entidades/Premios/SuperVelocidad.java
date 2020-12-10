package Entidades.Premios;

import java.awt.Point;

import EntidadesGraficas.Label_super_velocidad;
import Visitors.Visitor;
import Visitors.VisitorSuperVelocidad;

public class SuperVelocidad extends PremioTemporal {

	public SuperVelocidad(Point p) {
		super(new Label_super_velocidad(p));
		duracion = 9000;
		velocidad=4;
		valor=3;
		visitor = new VisitorSuperVelocidad(this);		
	}
	
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
