package Entidades;

import EntidadesGraficas.Entidad_grafica;
import Logica.Juego;
import Movimientos.EstrategiaMovimiento;
import Visitors.Element;
import Visitors.Visitor;

public abstract class Entidad extends Element {
	protected int velocidad;
	protected Entidad_grafica entidad_graf;
	protected EstrategiaMovimiento movimiento;
	protected Juego juego;
	protected Visitor visitor;
	protected boolean colisionando;

	public Entidad() {
		this.juego = Juego.getJuego();
		this.juego.agregarEntidad(this);
		colisionando = false;
	}

	public void accionar() {
		this.movimiento.mover();
	}

	public abstract void accept(Visitor visitor);

	public void setMovimiento(EstrategiaMovimiento movimiento) {
		this.movimiento = movimiento;
	}

	public int getVelocidad() {
		return this.velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public void eliminar() {
		juego.eliminarEntidad(this);
	}

	public Entidad_grafica getGrafico() {
		return entidad_graf;
	}
	
	public Visitor getVisitor() {
		return visitor;
	}
	
	public void setColision(boolean estado) {
		colisionando = estado;
	}
	
	public boolean getColision() {
		return colisionando;
	}

	public Juego getJuego() {
		return juego;
	}
}
