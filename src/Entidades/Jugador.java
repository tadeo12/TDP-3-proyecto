package Entidades;

import EntidadesGraficas.Entidad_grafica;
import EstadosArma.ConArmaNormal;
import EstadosArma.EstadoArma;
import EstadosJugador.EstadoInicial;
import EstadosJugador.EstadoJugador;
import Movimientos.Horizontal;
import Visitors.Visitor;

public class Jugador extends Entidad {
	protected EstadoArma estado_arma;
	protected EstadoJugador estado;
	
	public Jugador(Entidad_grafica entidad) {
		super(entidad);
		movimiento = new Horizontal(this, Horizontal.DERECHA);
		estado_arma = new ConArmaNormal(this);
		estado = new EstadoInicial(this);
	}

	/*
	 accionar(){
		if (juego.moviendoDerecha){
			this.movimiento.setDireccion(movimieto.DERECHA);
			this.movimiento.mover();
		}
		if(juego.moviendoIzquierda){
			this.movimiento.setDireccion(movimieto.IZQUIERDA);
			this.movimiento.mover();
		}
		if(juego.disparando){
			disparar();
		}
	}
	 */
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
