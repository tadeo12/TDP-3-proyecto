package Visitors;

import Entidades.Entidad;
import Entidades.InfectadoAlpha;
import Entidades.InfectadoBeta;
import Entidades.Jugador;
import Entidades.ObjetoPrecioso;
import Entidades.ParticulaV;
import Entidades.PremioTemporal;
import Entidades.ProyectilNormal;
import Entidades.SuperProyectil;
import Entidades.Premios.SuperArma;
import Entidades.Premios.SuperVelocidad;

public abstract class Visitor {
	protected Entidad entidad;

	public void visit(InfectadoAlpha infectado) {}


	public void visit(Jugador jugador) {}

	
	public void visit(InfectadoBeta infectado) {}


	public void visit(SuperVelocidad premio) {}
	
	public void visit(SuperArma sa) {}


	public void visit(Curacion objeto) {}

	
	public  void visit(ParticulaV particula) {}

	
	public  void visit(SuperProyectil proyectil) {}

	
	public void visit(ProyectilNormal proyectil) {}

	public void setEntidad(Entidad entidad) {
		this.entidad = entidad;
	}

}
