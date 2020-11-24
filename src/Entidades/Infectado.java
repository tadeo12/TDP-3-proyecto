package Entidades;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import EntidadesGraficas.Entidad_grafica;
import EntidadesGraficas.Label_infectado_alpha;
import Movimientos.Vertical;
import Movimientos.Vertical_loop;
import Visitors.VisitorInfectado;

public abstract class Infectado extends Entidad {
	protected int carga_viral;
	protected boolean suelta_premio;
	protected Random dispara;

	public Infectado(Entidad_grafica eg, int duracion) {
		super();
		this.entidad_graf = eg;
		velocidad = 1;
		this.movimiento = null;
		this.suelta_premio = false;
		this.carga_viral = 100;
		visitor = new VisitorInfectado();
		Infectado inf=this;
		Timer timer = new Timer();
		TimerTask timer_task = new TimerTask() {
			@Override
			public void run() {
				movimiento = new Vertical_loop(inf, Vertical.ABAJO);
			};
		};
		timer.schedule(timer_task, 0, duracion);
		dispara = new Random();
	}

	public abstract void disminuirCargaViral(int desinfeccion);

	public abstract Proyectil disparar();

	public int getCargaViral() {
		return this.carga_viral;
	}

	public void accionar() {
		if(movimiento!=null)
			movimiento.mover();
		if (dispara.nextInt(150) == 2) {
			disparar();
		}
	}
}
