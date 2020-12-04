package Visitors;

import java.util.Timer;
import java.util.TimerTask;

import Entidades.Jugador;
import Entidades.Premios.PremioTemporal;
import EstadosJugador.EstadoJugador;
import EstadosJugador.EstadoSuperVeloz;

//TEMPORAL
public class VisitorSuperVelocidad extends VisitorPremioTemporal {

	public VisitorSuperVelocidad(PremioTemporal premioTemp) {
		super(premioTemp);
		duracion = premioTemp.getDuracion();
	}

	@Override
	public void visit(Jugador jug) {
		EstadoJugador estado_actual = jug.getEstadoJugador();
		jug.setEstadoJugador(new EstadoSuperVeloz(jug));
		entidad.eliminar();

		Timer timer = new Timer();
		TimerTask timer_task = new TimerTask() {

			@Override
			public void run() {
				jug.setEstadoJugador(estado_actual);
				this.cancel();
			};
		};
		timer.schedule(timer_task, this.duracion , 1);
	}

}
