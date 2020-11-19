package Entidades;

import Movimientos.Vertical;

public abstract class ProyectilSanitario extends Proyectil {

	public ProyectilSanitario() {
		super();
		movimiento = new Vertical(this, Vertical.ARRIBA);
	}

}
