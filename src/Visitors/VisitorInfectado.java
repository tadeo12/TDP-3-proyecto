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

	public void visit(InfectadoAlpha inf) {

	}

	public void visit(InfectadoBeta inf) {

	}

	public void visit(ParticulaV p) {

	}

	public void visit(SuperProyectil p) {

	}

	public void visit(ProyectilNormal p) {

	}

}
