package Visitors;

import java.util.Timer;
import java.util.TimerTask;

import Entidades.Jugador;
import Entidades.Premios.PremioTemporal;
import EstadosJugador.EstadoJugador;
import EstadosJugador.EstadoInmune;

public class VisitorInmunidad extends VisitorPremioTemporal {

	public VisitorInmunidad(PremioTemporal inmu) {
		super(inmu);
		duracion = inmu.getDuracion();
		
	}
	
	public void visit(Jugador jug) {
		EstadoJugador estado_actual = jug.getEstadoJugador();
		jug.setEstadoJugador(new EstadoInmune(jug));
		entidad.eliminar();
		
		Timer timer = new Timer();
		TimerTask timer_task = new TimerTask() {

			@Override
			public void run() {
				jug.setEstadoJugador(estado_actual);
				this.cancel();
			};
		};
		timer.schedule(timer_task, this.duracion*1000, 1);
	}

}
