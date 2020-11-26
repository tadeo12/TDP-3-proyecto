package Entidades.Premios;

import java.awt.Point;

import EntidadesGraficas.Label_inmunidad;
import Visitors.Visitor;
import Visitors.VisitorInmunidad;
import Visitors.VisitorSuperVelocidad;

public class Inmunidad extends PremioTemporal {

	public Inmunidad(Point p) {
		super(new Label_inmunidad(p));
		duracion = 40;
		visitor = new VisitorInmunidad(this);
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
