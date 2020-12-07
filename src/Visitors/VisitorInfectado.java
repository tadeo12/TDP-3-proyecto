package Visitors;

import Entidades.*;

public class VisitorInfectado extends Visitor {

	public VisitorInfectado(Infectado entidad) {
		super(entidad);
	}
	public void visit(Jugador j) {
		Infectado infectado=(Infectado) this.entidad;
		j.incrementarCargaViral(infectado.getDamage());
	}



}
