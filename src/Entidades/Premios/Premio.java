package Entidades.Premios;

import java.awt.Point;

import Entidades.Entidad;
import Movimientos.Vertical;

public abstract class Premio extends Entidad {

	public Premio(Point p) {
		super();
		movimiento = new Vertical(this,Vertical.ABAJO);
	}
	

}
