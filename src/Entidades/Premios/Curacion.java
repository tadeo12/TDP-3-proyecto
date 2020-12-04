package Entidades.Premios;

import java.awt.Point;

import EntidadesGraficas.Label_curacion;
import Visitors.Visitor;
import Visitors.VisitorCuracion;
import Visitors.VisitorInmunidad;

public class Curacion extends ObjetoPrecioso {

	public Curacion(Point p) {
		super(new Label_curacion(p));
		visitor = new VisitorCuracion(this);
		velocidad=2;
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
