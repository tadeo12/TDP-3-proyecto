package Entidades;

import java.awt.Point;

import EntidadesGraficas.Entidad_grafica;
import EntidadesGraficas.Label_particulaV_Beta;
import Movimientos.EstrategiaMovimiento;
import Movimientos.Vertical;
import Movimientos.VerticalRemoveRango;
import Visitors.VisitorParticulaV;

public class ParticulaV_Beta extends ParticulaV {

	public ParticulaV_Beta(Point posicion) {
		super(new Label_particulaV_Beta(posicion));
		velocidad = 5;
		damage = 5;
		rango = 300;
		movimiento = new VerticalRemoveRango(this, Vertical.ABAJO);
	}

}