package Entidades;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import EntidadesGraficas.Entidad_grafica;
import EntidadesGraficas.Label_infectado;
import Logica.GeneradorDePremio;
import Movimientos.Horizontal;
import Movimientos.Horizontal_remove;
import Movimientos.Vertical;
import Movimientos.Vertical_loop;
import Visitors.VisitorInfectado;

/**
 * Clase que modela un infectado del juego
 *
 */
public abstract class Infectado extends Entidad {
	protected int carga_viral;
	protected boolean suelta_premio;
	protected boolean desinfectado;
	protected int tiempoEspera;
	protected int damage;
	protected boolean quieto;

	protected Random random;

	/**
	 * Constructor de un infectado
	 * 
	 * @param entidad_graf entidad grafica de la entidad
	 * @param duracion     tiempo que permanecerá quieto el infectado, en
	 *                     milisegundos desde que empieza su tanda
	 * @param enEspera     parametro necesario para saber si el infectado que se
	 *                     crea pertene a la primer tanda(en ese caso no estara en
	 *                     espera) o y si deberia quedarse quieto hasta que se
	 *                     notifique(cuando se llegue a su tanda)
	 */
	public Infectado(Entidad_grafica entidad_graf, int duracion, boolean enEspera) {
		super(entidad_graf);
		velocidad = 1;
		movimiento = null;// en principio no se moveran hasta que se indique que aparezca por pantalla
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

	/**
	 * cuando se llama a este método empieza a contar el tiempo de espera del
	 * infectado para luego aparecer en pantalla
	 */
	public void aparecer() {
		Infectado inf = this;
		Timer timer = new Timer();
		TimerTask timer_task = new TimerTask() {
			@Override
			public void run() {
				if (juego.jugando())
					movimiento = new Vertical_loop(inf, Vertical.ABAJO);
				timer.cancel();// se ejecuta una vez el run y se cancela el timer
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
		if (!quieto || desinfectado) {
			if (movimiento != null)
				movimiento.mover();

			if (!desinfectado && random.nextInt(100) == 1) {// para que no dispare demasiado se considera solo una de
															// cada 100 veces que se llame al accionar (en promedio)
				disparar();
			}
		}
	}

	/**
	 * Es invocado cuando el Infectado alcanza una carga viral igual a cero
	 */
	public void desinfectar() {
		// el Infectado desaparece del mapa desplazandose hacia la derecha o hacia la
		// izquierda segun el valor random obtenido
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
