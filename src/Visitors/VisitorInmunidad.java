package Visitors;

import java.util.Timer;
import java.util.TimerTask;

import Entidades.Jugador;
import Entidades.Premios.PremioTemporal;
import EstadosJugador.EstadoJugador;
import EstadosJugador.Inmune;

public class VisitorInmunidad extends VisitorPremioTemporal {

	public VisitorInmunidad(PremioTemporal inmu) {
		super(inmu);
		duracion = inmu.getDuracion();
		
	}
	
	public void visit(Jugador jug) {
		entidad.eliminar();
		EstadoJugador estado_actual = jug.getEstadoJugador();
		jug.setEstadoJugador(new Inmune(jug));
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
