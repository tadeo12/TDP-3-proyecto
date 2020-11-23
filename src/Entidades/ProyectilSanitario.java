package Entidades;

import EntidadesGraficas.Entidad_grafica;
import Movimientos.Vertical;

public abstract class ProyectilSanitario extends Proyectil {

	public ProyectilSanitario(Entidad_grafica e) {
		super();
		entidad_graf = e;
		movimiento = new Vertical(this, Vertical.ARRIBA);
	}

}
