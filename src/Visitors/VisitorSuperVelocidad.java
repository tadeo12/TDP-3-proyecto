package Visitors;

import java.util.Timer;
import java.util.TimerTask;

import Entidades.Jugador;
import Entidades.Premios.PremioTemporal;
import Entidades.Premios.SuperVelocidad;
import EstadosJugador.EstadoJugador;
import EstadosJugador.SuperVeloz;

//TEMPORAL
public class VisitorSuperVelocidad extends VisitorPremioTemporal {

	public VisitorSuperVelocidad(PremioTemporal premioTemp) {
		super(premioTemp);
		duracion = premioTemp.getDuracion();
	}

	@Override
	public void visit(Jugador jug) {
		EstadoJugador estado_actual = jug.getEstadoJugador();
		jug.setEstadoJugador(new SuperVeloz(jug));

		Timer timer = new Timer();
		entidad.eliminar();
		TimerTask timer_task = new TimerTask() {

			@Override
			public void run() {
				jug.setEstadoJugador(estado_actual);
			};
		};
		timer.schedule(timer_task, 0, this.duracion);
	}

}
