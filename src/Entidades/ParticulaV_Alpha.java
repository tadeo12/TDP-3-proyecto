package Entidades;

import java.awt.Point;

import EntidadesGraficas.Label_particulaV_Alpha;
import Movimientos.Vertical;
import Movimientos.VerticalRemoveRango;

/**
 * Clase que modela la particula de un infectado de tipo ALPHA
 *
 */
public class ParticulaV_Alpha extends ParticulaV {

	public ParticulaV_Alpha(Point posicion) {
		super(new Label_particulaV_Alpha(posicion));
		velocidad = 6;
		damage = 5;
		rango = 400;
		movimiento = new VerticalRemoveRango(this, Vertical.ABAJO);
	}

}
