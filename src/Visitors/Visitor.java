package Visitors;

import Entidades.Entidad;
import Entidades.InfectadoAlpha;
import Entidades.InfectadoBeta;
import Entidades.Jugador;
import Entidades.ParticulaV;
import Entidades.ProyectilNormal;
import Entidades.SuperProyectil;

import Entidades.Premios.BajoCero;
import Entidades.Premios.Curacion;
import Entidades.Premios.Inmunidad;
import Entidades.Premios.SuperArma;
import Entidades.Premios.SuperVelocidad;

public abstract class Visitor {
	protected Entidad entidad;

	public Visitor(Entidad entidad) {
		this.entidad = entidad;
	}

	public void visit(InfectadoAlpha infectado) {
	}

	public void visit(Jugador jugador) {
	}

	public void visit(InfectadoBeta infectado) {
	}

	public void visit(SuperArma premio) {
	}

	public void visit(Curacion premio) {
	}

	public void visit(BajoCero premio) {
	}

	public void visit(SuperVelocidad premio) {
	}

	public void visit(Inmunidad premio) {
	}

	public void visit(ParticulaV particula) {
	}

	public void visit(SuperProyectil proyectil) {
	}

	public void visit(ProyectilNormal proyectil) {
	}

}
