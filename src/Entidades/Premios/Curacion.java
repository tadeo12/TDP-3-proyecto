package Entidades.Premios;

import java.awt.Point;

import EntidadesGraficas.Label_curacion;
import Visitors.Visitor;
import Visitors.VisitorCuracion;

public class Curacion extends ObjetoPrecioso {

	public Curacion(Point p) {
		super(new Label_curacion(p));
		velocidad = 2;
		visitor = new VisitorCuracion(this);		
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
