package Entidades;

import EstadosArma.ConArmaNormal;
import EstadosArma.EstadoArma;
import EstadosJugador.EstadoInicial;
import EstadosJugador.EstadoJugador;
import Logica.Juego;
import Movimientos.Horizontal;
import Visitors.Visitor;

public class Jugador extends Entidad {
	protected EstadoArma estado_arma;
	protected EstadoJugador estado_jugador;
	protected int carga_viral;

	public Jugador(Juego juego) {
		super();
		movimiento = new Horizontal(this, Horizontal.DERECHA);
		estado_arma = new ConArmaNormal(this);
		estado_jugador = new EstadoInicial(this);
		carga_viral = 0;
	}

	public int getCargaViral() {
		return carga_viral;
	}

	public void setCargaViral(int carga) {
		if (carga >= 100) {
			juego.eliminarEntidad(this);
		} else
			carga_viral = carga;
	}

	public void accionar() {
		if (juego.moviendoDerecha()) {
			this.movimiento.setDireccion(Horizontal.DERECHA);
			this.movimiento.mover();
		}
		if (juego.moviendoIzquierda()) {
			this.movimiento.setDireccion(Horizontal.IZQUIERDA);
			this.movimiento.mover();
		}
		if (juego.disparando()) {
			juego.agregarEntidad(disparar());
		}
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	public Proyectil disparar() {
		return estado_arma.disparar();
	}

	public void setEstadoJugador(EstadoJugador estado_jugador) {
		this.estado_jugador = estado_jugador;
	}

	public void setEstadoArma(EstadoArma estado_arma) {
		this.estado_arma = estado_arma;
	}

	public EstadoArma getEstadoArma() {
		return estado_arma;
	}
	
	public EstadoJugador getEstadoJugador() {
		return estado_jugador;		
	}
}
