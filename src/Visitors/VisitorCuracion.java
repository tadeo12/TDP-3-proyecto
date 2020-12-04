package Visitors;

import Entidades.Jugador;
import Entidades.Premios.ObjetoPrecioso;

public class VisitorCuracion extends VisitorObjetoPrecioso {

	public VisitorCuracion(ObjetoPrecioso cur) {
		super(cur);

	}

	public void visit(Jugador jug) {
		entidad.eliminar();
		jug.setCargaViral(0);
	}

}
