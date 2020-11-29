package Entidades;

import EntidadesGraficas.Label_jugador;
import EstadosArma.ConArmaNormal;
import EstadosArma.ConSuperArma;
import EstadosArma.EstadoArma;
import EstadosJugador.EstadoInicial;
import EstadosJugador.EstadoJugador;
import Movimientos.Horizontal;
import Visitors.Visitor;
import Visitors.VisitorJugador;

public class Jugador extends Entidad {
	protected EstadoArma estado_arma;
	protected EstadoJugador estado_jugador;
	protected int carga_viral;

	public Jugador() {
		super(new Label_jugador());
		movimiento = new Horizontal(this, Horizontal.DERECHA);
		estado_arma = new ConArmaNormal(this);
		estado_jugador = new EstadoInicial(this);
		carga_viral = 0;
	}

	public void setVisitor(Visitor visitor) {
		this.visitor = visitor;
	}

	public int getCargaViral() {
		return carga_viral;
	}

	public int recuperarVida() {
		return carga_viral = 0;
	}

	public void incrementarCargaViral(int carga) {
		if (carga + carga_viral >= 100) {
			juego.eliminarEntidad(this);
			juego.perdio();
			
		} else
			carga_viral += carga;
//		System.out.println("Carga viral: "+carga_viral);
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

			this.estado_arma.disparar();
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
		System.out.println("cambiando estado: " + estado_jugador);
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
