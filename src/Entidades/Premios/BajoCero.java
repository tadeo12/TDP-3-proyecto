package Entidades.Premios;

import java.awt.Point;

import EntidadesGraficas.Label_bajo_cero;
import Visitors.Visitor;
import Visitors.VisitorBajoCero;

public class BajoCero extends PremioTemporal {

	public BajoCero(Point p) {
		super(new Label_bajo_cero(p));
		duracion = 10000;
		velocidad = 6;
		valor = 0;
		visitor = new VisitorBajoCero(this);
		
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
