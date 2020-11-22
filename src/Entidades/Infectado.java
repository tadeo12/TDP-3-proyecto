package Entidades;

import Movimientos.Vertical;
import Movimientos.Vertical_loop;
import Visitors.VisitorInfectado;

public abstract class Infectado extends Entidad {
	protected int carga_viral;
	protected boolean suelta_premio;

	public Infectado() {
		super();
		this.movimiento = new Vertical_loop(this, Vertical.ABAJO);
		this.suelta_premio = false;
		this.carga_viral = 100;
		visitor = new VisitorInfectado();
	}

	public abstract void disminuirCargaViral(int desinfeccion);

	public Proyectil disparar() {
		return new ParticulaV();
	}

	public int getCargaViral() {
		return this.carga_viral;
	}

	public void accionar() {
		movimiento.mover();
	}
	
}
