package Visitors;

import java.util.Timer;
import java.util.TimerTask;

import Entidades.Jugador;
import Entidades.Premios.PremioTemporal;
import EstadosArma.ConSuperArma;
import EstadosArma.EstadoArma;
//TEMPORAL
public class VisitorSuperArma extends VisitorPremioTemporal {
	private int duracion;

	public VisitorSuperArma(PremioTemporal premioTemp) {
		super(premioTemp);
		duracion = premioTemp.getDuracion();
	}

	@Override
	public void visit(Jugador jug) {
		EstadoArma estado_actual = jug.getEstadoArma();
		jug.setEstadoArma(new ConSuperArma(jug));
		entidad.eliminar();
		Timer timer = new Timer();

		TimerTask timer_task = new TimerTask() {

			@Override
			public void run() {
				jug.setEstadoArma(estado_actual);
				this.cancel();
			};
		};
		timer.schedule(timer_task, this.duracion*1000, 1);
	}

}
