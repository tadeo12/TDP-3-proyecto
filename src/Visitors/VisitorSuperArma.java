package Visitors;

import java.util.Timer;
import java.util.TimerTask;

import Entidades.Jugador;
import Entidades.Premios.PremioTemporal;
import EstadosArma.ConSuperArma;
import EstadosArma.EstadoArma;
import Logica.Juego;

//TEMPORAL
public class VisitorSuperArma extends VisitorPremioTemporal {

	public VisitorSuperArma(PremioTemporal premioTemp) {
		super(premioTemp);
		duracion = premioTemp.getDuracion();
	}

	@Override
	public void visit(Jugador jug) {
		EstadoArma estado_actual = jug.getEstadoArma();
		jug.setEstadoArma(new ConSuperArma(jug));
		jug.setConSuperArma();
		PremioTemporal p=(PremioTemporal) entidad;
		int valor=p.getValor();
		entidad.eliminar();
		Juego.getJuego().setEstadoPremio(valor, true);

		Timer timer = new Timer();
		TimerTask timer_task = new TimerTask() {

			@Override
			public void run() {
				jug.setEstadoArma(estado_actual);
				jug.setSinPowerUp();
				Juego.getJuego().setEstadoPremio(valor, false);
				this.cancel();
			};
		};
		timer.schedule(timer_task, this.duracion , 1);
	}

}
