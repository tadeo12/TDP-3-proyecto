package Entidades;

import Logica.Juego;
import Movimientos.Vertical;

public abstract class Premio extends Entidad {

	public Premio(Juego juego) {
		super(juego);
		movimiento = new Vertical(this,Vertical.ABAJO);
	}


}
