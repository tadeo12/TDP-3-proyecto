package Entidades;

import EntidadesGraficas.Label_jugador;
import EstadosArma.ConArmaNormal;
import EstadosArma.EstadoArma;
import EstadosJugador.EstadoInicial;
import EstadosJugador.EstadoJugador;
import Logica.Juego;
import Movimientos.Horizontal;
import Visitors.Visitor;
import Visitors.VisitorJugador;

public class Jugador extends Entidad {
	protected EstadoArma estado_arma;
	protected EstadoJugador estado_jugador;
	protected int carga_viral;

	public Jugador(Juego juego) {
		super();
		this.entidad_graf=new Label_jugador();
		movimiento = new Horizontal(this, Horizontal.DERECHA);
		estado_arma = new ConArmaNormal(this);
		estado_jugador = new EstadoInicial(this);
		velocidad = 3;
		carga_viral = 0;
	}

	public void setVisitor(Visitor visitor) {
		this.visitor = visitor;
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
			System.out.println("disparo");
			juego.agregarEntidad(estado_arma.disparar());
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
