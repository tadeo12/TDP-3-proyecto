package Entidades;

import EntidadesGraficas.Entidad_grafica;
import Movimientos.EstrategiaMovimiento;
import Visitors.Element;
import Visitors.Visitor;

public abstract class Entidad extends Element {
	protected int velocidad;
	protected Entidad_grafica entidad_graf;
	protected EstrategiaMovimiento movimiento;
	// protected Visitor visitor;

	public Entidad(Entidad_grafica entidad) {
		this.entidad_graf = entidad;
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

	}

	public Entidad_grafica getGrafico() {
		return entidad_graf;
	}
}
