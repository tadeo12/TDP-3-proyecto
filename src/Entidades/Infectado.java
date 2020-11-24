package Entidades;

import java.util.Random;

import EntidadesGraficas.Entidad_grafica;
import EntidadesGraficas.Label_infectado_alpha;
import Movimientos.Vertical;
import Movimientos.Vertical_loop;
import Visitors.VisitorInfectado;

public abstract class Infectado extends Entidad {
	protected int carga_viral;
	protected boolean suelta_premio;
	protected Random dispara;

	public Infectado(Entidad_grafica eg) {
		super();
		this.entidad_graf = eg;
		velocidad = 1;
		this.movimiento = new Vertical_loop(this, Vertical.ABAJO);
		this.suelta_premio = false;
		this.carga_viral = 100;
		visitor = new VisitorInfectado();
		dispara = new Random();
	}

	public abstract void disminuirCargaViral(int desinfeccion);

	public abstract Proyectil disparar();

	public int getCargaViral() {
		return this.carga_viral;
	}

	public void accionar() {
		movimiento.mover();
		if (dispara.nextInt(150) == 2) {
			disparar();
		}
	}
}
