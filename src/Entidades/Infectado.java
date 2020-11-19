package Entidades;

import Logica.Juego;
import Movimientos.Vertical;
import Movimientos.Vertical_loop;

public abstract class Infectado extends Entidad {
	protected int carga_viral;
	protected boolean suelta_premio;

	public Infectado(Juego juego) {
		super(juego);
		this.movimiento = new Vertical_loop(this, Vertical.ABAJO);
		this.suelta_premio = false;
		this.carga_viral = 100;
	}

	public abstract void disminuirCargaViral(int desinfeccion);

	public Proyectil disparar() {
		return new ParticulaV(juego);
	}

	public int getCargaViral() {
		return this.carga_viral;
	}

	public void accionar() {

	}
	
}
