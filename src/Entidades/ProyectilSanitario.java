package Entidades;

import Logica.Juego;
import Movimientos.Vertical;

public abstract class ProyectilSanitario extends Proyectil {

	public ProyectilSanitario(Juego juego) {
		super(juego);
		movimiento = new Vertical(this,Vertical.ARRIBA);
	}

}
