package Entidades;

import EntidadesGraficas.Entidad_grafica;
import Movimientos.Vertical;
import Movimientos.Vertical_loop;

public abstract class Infectado extends Entidad {
	protected int carga_viral;
	protected boolean suelta_premio;

	public Infectado(Entidad_grafica entidad) {
		super(entidad);
		movimiento = new Vertical_loop(this, Vertical.ABAJO);
		suelta_premio = false;
		carga_viral = 100;
	}

	public abstract void disminuirCargaViral(int desinfeccion);

	public Proyectil disparar() {
		return null;
		// new ParticulaV(?????);
	}

	public int getCargaViral() {
		return this.carga_viral;
	}

	public void accionar() {

	}
	
}
