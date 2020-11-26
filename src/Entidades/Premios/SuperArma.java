package Entidades.Premios;

import java.awt.Point;

import EntidadesGraficas.Label_super_arma;
import Visitors.Visitor;
import Visitors.VisitorSuperArma;

public class SuperArma extends PremioTemporal {

	public SuperArma(Point p) {
		super(new Label_super_arma(p));
		visitor = new VisitorSuperArma(this);
		duracion = 30;
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
