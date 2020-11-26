package Entidades.Premios;

import java.awt.Point;

import EntidadesGraficas.Label_super_proyectil;
import Visitors.Visitor;

public class SuperArma extends PremioTemporal {

	public SuperArma(Point p) {
		super(new Label_super_proyectil(p));

		duracion = 30;
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
