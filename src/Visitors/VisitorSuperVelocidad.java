package Visitors;

import java.util.Timer;
import java.util.TimerTask;

import Entidades.Jugador;
import Entidades.Premios.SuperVelocidad;
import EstadosJugador.EstadoJugador;
import EstadosJugador.SuperVeloz;
//TEMPORAL
public class VisitorSuperVelocidad extends Visitor {
	
	public int duracion;

	public VisitorSuperVelocidad(SuperVelocidad premioTemp) {
		duracion = premioTemp.getDuracion();
	}

	@Override
	public void visit(Jugador jug) {
		EstadoJugador estado_actual = jug.getEstadoJugador();
		jug.setEstadoJugador(new SuperVeloz(jug));

		Timer timer = new Timer();

		TimerTask timer_task = new TimerTask() {

			@Override
			public void run() {
				jug.setEstadoJugador(estado_actual);
			};
		};
		timer.schedule(timer_task, 0, this.duracion);
	}

}
