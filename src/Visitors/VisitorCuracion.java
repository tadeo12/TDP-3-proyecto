package Visitors;

import Entidades.Jugador;
import Entidades.Premios.ObjetoPrecioso;

public class VisitorCuracion extends VisitorObjetoPrecioso {

	public VisitorCuracion(ObjetoPrecioso entidad) {
		super(entidad);

	}

	public void visit(Jugador jugador) {
		entidad.eliminar();
		jugador.setCargaViral(0);
	}

}
