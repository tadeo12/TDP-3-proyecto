package Entidades.Premios;

import java.awt.Point;

import EntidadesGraficas.Label_inmunidad;
import Visitors.Visitor;

public class Inmunidad extends PremioTemporal {

	public Inmunidad(Point p) {
		super();
		entidad_graf = new Label_inmunidad(p);
		duracion = 40;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
