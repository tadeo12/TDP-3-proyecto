package Entidades.Premios;

import java.awt.Point;

import EntidadesGraficas.Label_super_velocidad;
import Movimientos.Vertical;
import Movimientos.Vertical_remove;
import Visitors.Visitor;
import Visitors.VisitorSuperVelocidad;

public class SuperVelocidad extends PremioTemporal {

	public SuperVelocidad(Point p) {
		super(new Label_super_velocidad(p));
		duracion = 9000;
		visitor = new VisitorSuperVelocidad(this);
		velocidad=4;
	}
	
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
