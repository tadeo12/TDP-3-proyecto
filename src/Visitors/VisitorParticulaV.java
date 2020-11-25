package Visitors;

import Entidades.*;

public class VisitorParticulaV extends Visitor {

	public void visit(Jugador j) {
		Proyectil p = (Proyectil) entidad;
		j.incrementarCargaViral(p.getDamage());
		System.out.println("damage: "+p.getDamage());
		p.eliminar();
	}

}
