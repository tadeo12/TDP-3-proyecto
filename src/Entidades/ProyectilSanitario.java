package Entidades;

import EntidadesGraficas.Entidad_grafica;
import Movimientos.Vertical;

public abstract class ProyectilSanitario extends Proyectil {

	public ProyectilSanitario(Entidad_grafica entidad) {
		super(entidad);
		movimiento = new Vertical(this,Vertical.ARRIBA);
	}

}
