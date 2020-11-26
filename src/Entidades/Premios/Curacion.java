package Entidades.Premios;

import java.awt.Point;

import EntidadesGraficas.Label_curacion;
import Visitors.Visitor;

public class Curacion extends ObjetoPrecioso {

	public Curacion(Point p) {
		super(new Label_curacion(p));
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
