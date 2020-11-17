package Visitors;

import Entidades.InfectadoAlpha;
import Entidades.InfectadoBeta;
import Entidades.Jugador;
import Entidades.ObjetoPrecioso;
import Entidades.ParticulaV;
import Entidades.PremioTemporal;
import Entidades.ProyectilNormal;
import Entidades.SuperProyectil;

public abstract class Visitor {

	public abstract void visit(InfectadoAlpha infectado) ;


	public abstract void visit(Jugador jugador) ;

	
	public abstract void visit(InfectadoBeta infectado) ;


	public abstract void visit(PremioTemporal premio) ;


	public abstract void visit(ObjetoPrecioso objeto) ;

	
	public abstract void visit(ParticulaV particula) ;

	
	public abstract void visit(SuperProyectil proyectil) ;

	
	public abstract void visit(ProyectilNormal proyectil) ;


}
