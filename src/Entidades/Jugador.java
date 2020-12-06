package Entidades;

import java.util.LinkedList;

import EntidadesGraficas.Label_jugador;
import EstadosArma.ConArmaNormal;
import EstadosArma.EstadoArma;
import EstadosJugador.EstadoInicial;
import EstadosJugador.EstadoJugador;
import Movimientos.Horizontal;
import Visitors.Visitor;

public class Jugador extends Entidad {
	protected EstadoArma estado_arma;
	protected EstadoJugador estado_jugador;
	protected int carga_viral;
	protected int tiros;
	
	protected LinkedList<Object> listaEstados;

	public Jugador() {
		super(new Label_jugador());
		movimiento = new Horizontal(this, Horizontal.DERECHA);
		estado_arma = new ConArmaNormal(this);
		estado_jugador = new EstadoInicial(this);
		carga_viral = 0;
		
		tiros=0;
	}

	public void setVisitor(Visitor visitor) {
		this.visitor = visitor;
	}

	public void setCargaViral(int carga) {
		if(carga>100)
			carga=100;
		if(carga<0)
			carga=0;
		this.carga_viral = carga;
	}

	public int getCargaViral() {
		return carga_viral;
	}


	public void incrementarCargaViral(int carga) {
		estado_jugador.incrementarCargaViral(carga);

		if (carga_viral >= 100) {
			juego.eliminarEntidad(this);
			juego.perdio();
		}
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
			tiros++;
			if(tiros==8) {
				this.estado_arma.disparar();
				tiros=0;
				juego.seDisparo();
			}
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
		//System.out.println("cambiando estado: " + estado_jugador);
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

	@Override
	public int getVelocidad() {
		// System.out.println(estado_jugador.getVelocidad());
		return estado_jugador.getVelocidad();
	}
}
