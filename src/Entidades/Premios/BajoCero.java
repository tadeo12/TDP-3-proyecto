package Entidades.Premios;

import java.awt.Point;

import EntidadesGraficas.Label_bajo_cero;
import Visitors.Visitor;

public class BajoCero extends PremioTemporal {

	public BajoCero(Point p) {
		super(new Label_bajo_cero(p));
		duracion = 40;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
