package Entidades;

import java.awt.Point;
import java.util.Timer;
import java.util.TimerTask;

import EntidadesGraficas.Label_infectado_alpha;
import EstadosJugador.EstadoJugador;
import EstadosJugador.SuperVeloz;
import Movimientos.Vertical;
import Movimientos.Vertical_loop;
import Visitors.Visitor;

public class InfectadoAlpha extends Infectado {

	public InfectadoAlpha(Point p,int tiempoQuieto) {
		super(new Label_infectado_alpha(p),tiempoQuieto);
		

		
	}

	@Override
	public void disminuirCargaViral(int desinfeccion) {
		if (carga_viral - desinfeccion <= 0) {
			suelta_premio = true;
			carga_viral = 0;
		} else {
			carga_viral -= desinfeccion;
		}
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	@Override
	public Proyectil disparar() {
		return new ParticulaV_Alpha(this.getGrafico());
	}
}
