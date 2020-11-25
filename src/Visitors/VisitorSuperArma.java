package Visitors;

import java.util.Timer;
import java.util.TimerTask;

import Entidades.Jugador;
import Entidades.Premios.SuperArma;
import EstadosArma.ConSuperArma;
import EstadosArma.EstadoArma;
//TEMPORAL
public class VisitorSuperArma extends Visitor {
	private int duracion;

	public VisitorSuperArma(SuperArma premioTemp) {
		duracion = premioTemp.getDuracion();
	}

	@Override
	public void visit(Jugador jug) {
		EstadoArma estado_actual = jug.getEstadoArma();
		jug.setEstadoArma(new ConSuperArma(jug));

		Timer timer = new Timer();

		TimerTask timer_task = new TimerTask() {

			@Override
			public void run() {
				jug.setEstadoArma(estado_actual);
			};
		};
		timer.schedule(timer_task, 0, this.duracion);
	}

}
