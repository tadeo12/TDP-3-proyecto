package Visitors;

import Entidades.*;

public class VisitorParticulaV extends Visitor {

	public VisitorParticulaV(Entidad entidad) {
		super(entidad);
	}
	
	public void visit(Jugador j) {
		Proyectil p = (Proyectil) entidad;
		p.eliminar();
		j.incrementarCargaViral(p.getDamage()) ;
	}

}
