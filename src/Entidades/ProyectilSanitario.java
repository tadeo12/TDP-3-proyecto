package Entidades;

import EntidadesGraficas.Entidad_grafica;
import Movimientos.Vertical;
import Movimientos.Vertical_remove;
import Visitors.VisitorProyectilSanitario;

public abstract class ProyectilSanitario extends Proyectil {

	public ProyectilSanitario(Entidad_grafica e) {
		super();
		entidad_graf = e;
		movimiento = new Vertical_remove(this, Vertical.ARRIBA);
		visitor = new VisitorProyectilSanitario();
	}

}
