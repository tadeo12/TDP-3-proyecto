package Entidades;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;

import EntidadesGraficas.Entidad_grafica;
import EntidadesGraficas.Label_infectado;
import EntidadesGraficas.Label_infectado_alpha;
import EntidadesGraficas.Label_infectado_beta;
import Logica.GeneradorDePremio;
import Movimientos.Horizontal;
import Movimientos.Horizontal_remove;
import Movimientos.Vertical;
import Movimientos.Vertical_loop;
import Visitors.VisitorInfectado;

public abstract class Infectado extends Entidad {
	protected int carga_viral;
	protected boolean suelta_premio;
	protected Random random;
	protected boolean desinfectado;
	protected int tiempoEspera;
	protected int damage;
	private boolean quieto;

	public Infectado(Entidad_grafica entidad_graf, int duracion, boolean enEspera) {
		super(entidad_graf);
		velocidad = 1;
		movimiento = null;
		random = new Random();
		suelta_premio = random.nextInt(3) == 1;
		carga_viral = 100;
		damage = 1;
		desinfectado = false;
		quieto = false;
		
		tiempoEspera = duracion;
		if (!enEspera)
			aparecer();
		
		visitor = new VisitorInfectado(this);
	}

	public void aparecer() {
		Infectado inf = this;
		Timer timer = new Timer();
		TimerTask timer_task = new TimerTask() {
			@Override
			public void run() {
				movimiento = new Vertical_loop(inf, Vertical.ABAJO);
				timer.cancel();
			};
		};

		timer.schedule(timer_task, tiempoEspera, 1);

	}

	public abstract void disminuirCargaViral(int desinfeccion);

	public abstract Proyectil disparar();

	public int getCargaViral() {
		return this.carga_viral;
	}

	public void eliminar() {
		juego.eliminarInfectado(this);
	}

	public void accionar() {
		if (!quieto || desinfectado)  {
			if (movimiento != null)
				movimiento.mover();

			if (!desinfectado && random.nextInt(100) == 1) {
				disparar();
				//System.out.println("disparo");
			}
		}
	}

	public void desinfectar() {
		desinfectado = true;
		int direccion = random.nextInt(2);
		Label_infectado li = (Label_infectado) this.getGrafico();
		if (direccion == 1) {
			li.seVa(1);
			movimiento = new Horizontal_remove(this, Horizontal.DERECHA);
		} else {
			li.seVa(0);
			movimiento = new Horizontal_remove(this, Horizontal.IZQUIERDA);
		}

		velocidad = 3;
		if (suelta_premio) {
			GeneradorDePremio.generar(entidad_graf.getLocation());
		}
	}

	public int getDamage() {
		return damage;
	}

	public void setQuieto(boolean estado) {
		quieto = estado;
	}

}
