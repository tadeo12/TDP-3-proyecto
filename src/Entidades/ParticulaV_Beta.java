package Entidades;

import java.awt.Point;

import EntidadesGraficas.Label_particulaV_Beta;
import Movimientos.Vertical;
import Movimientos.VerticalRemoveRango;

/**
 * Clase que modela la particula de un infectado de tipo BETA
 *
 */
public class ParticulaV_Beta extends ParticulaV {

	public ParticulaV_Beta(Point posicion) {
		super(new Label_particulaV_Beta(posicion));
		velocidad = 5;
		damage = 3;
		rango = 300;
		movimiento = new VerticalRemoveRango(this, Vertical.ABAJO);
	}

}