package Entidades.Premios;

import java.awt.Point;

import EntidadesGraficas.Label_inmunidad;
import Visitors.Visitor;
import Visitors.VisitorInmunidad;
import Visitors.VisitorSuperVelocidad;

public class Inmunidad extends PremioTemporal {

	public Inmunidad(Point p) {
		super(new Label_inmunidad(p));
		duracion = 20000;
		visitor = new VisitorInmunidad(this);
		velocidad=5;
		valor=1;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
