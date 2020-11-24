package Entidades;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;

import EntidadesGraficas.Entidad_grafica;
import EntidadesGraficas.Label_infectado_alpha;
import EntidadesGraficas.Label_infectado_beta;
import Movimientos.Vertical;
import Movimientos.Vertical_loop;
import Visitors.VisitorInfectado;

public abstract class Infectado extends Entidad {
	protected int carga_viral;
	protected boolean suelta_premio;
	protected Random random;
	protected boolean dispara;
	private String movLeft [], movRight [];

	public Infectado(Entidad_grafica eg, int duracion) {
		super();
		this.entidad_graf = eg;
		velocidad = 1;
		this.movimiento = null;
		this.suelta_premio = false;
		this.carga_viral = 100;
		visitor = new VisitorInfectado();

		Infectado inf = this;
		Timer timer = new Timer();
		TimerTask timer_task = new TimerTask() {
			@Override
			public void run() {
				movimiento = new Vertical_loop(inf, Vertical.ABAJO);
			};
		};
		timer.schedule(timer_task, 0, duracion);

		random = new Random();
		dispara = true;
		
		this.movLeft = new String[]{ "/RecursosGraficos_Infectados/seVaLeft 1.gif","/RecursosGraficos_Infectados/seVaLeft 2.gif","/RecursosGraficos_Infectados/seVaLeft 3.gif",
				"/RecursosGraficos_Infectados/seVaLeft 4.gif","/RecursosGraficos_Infectados/seVaLeft 5.gif","/RecursosGraficos_Infectados/seVaLeft 6.gif","/RecursosGraficos_Infectados/seVaLeft 7.gif"};
		
		this.movRight = new String[]{ "/RecursosGraficos_Infectados/seVaRight 1.gif","/RecursosGraficos_Infectados/seVaRight 2.gif","/RecursosGraficos_Infectados/seVaRight 3.gif",
				"/RecursosGraficos_Infectados/seVaRight 4.gif","/RecursosGraficos_Infectados/seVaRight 5.gif","/RecursosGraficos_Infectados/seVaRight 6.gif","/RecursosGraficos_Infectados/seVaRight 7.gif"};
	
	}

	public abstract void disminuirCargaViral(int desinfeccion);

	public abstract Proyectil disparar();

	public int getCargaViral() {
		return this.carga_viral;
	}

	public void accionar() {
		if (movimiento != null)
			movimiento.mover();
		if (dispara && random.nextInt(150) == 7) {
			disparar();
		}
	}
	
	public void seVa(int lado) {
			
			ImageIcon imagen = null;
			Random rand = new Random();
			int i = rand.nextInt(7);
			
				if(lado == 1 ) {//se va para la der
					imagen = new ImageIcon(this.getClass().getResource(this.movRight[i]));
				}
				else {//se va para la izq
					imagen = new ImageIcon(this.getClass().getResource(this.movLeft[i]));
				}
				
				this.getGrafico().setIcon(imagen);
				this.getGrafico().setBounds(this.getGrafico().getX(), this.getGrafico().getY(), 100, 75);
				this.getGrafico().repaint();
			
		}
}
