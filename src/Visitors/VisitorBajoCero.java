package Visitors;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import Entidades.Infectado;
import Entidades.Jugador;
import Entidades.Premios.PremioTemporal;
import EstadosJugador.EstadoInmune;
import EstadosJugador.EstadoJugador;
import Logica.Juego;

public class VisitorBajoCero extends VisitorPremioTemporal {

	public VisitorBajoCero(PremioTemporal entidad) {
		super(entidad);
		this.duracion = entidad.getDuracion();
	}

	public void visit(Jugador jug) {

		List<Infectado> infectados = Juego.getJuego().getInfectados();
		for (Infectado i : infectados) {
			i.setQuieto(true);
		}
		PremioTemporal p = (PremioTemporal) entidad;
		int valor = p.getValor();
		entidad.eliminar();
		Juego.getJuego().setEstadoPremio(valor, true);

		Timer timer = new Timer();
		TimerTask timer_task = new TimerTask() {

			@Override
			public void run() {
				List<Infectado> infectados = Juego.getJuego().getInfectados();
				Juego.getJuego().setEstadoPremio(valor, false);
				for (Infectado i : infectados) {
					i.setQuieto(false);
				}
				this.cancel();
			};
		};
		timer.schedule(timer_task, this.duracion, 1);
	}
}
