package Visitors;

import Entidades.InfectadoAlpha;
import Entidades.InfectadoBeta;
import Entidades.Jugador;
import Entidades.ObjetoPrecioso;
import Entidades.PremioTemporal;

public abstract class Visitor {

	public void visit(InfectadoAlpha infectado) {

	}

	public void visit(Jugador jugador) {

	}

	public void visit(InfectadoBeta infectado) {

	}

	public void visit(PremioTemporal premio) {

	}

	public void visit(ObjetoPrecioso objeto) {

	}

	public void visit(ParticulaV particula) {

	}

	public void visit(SuperProyectil proyectil) {

	}

	public void visit(ProyectilNormal proyectil) {

	}

}