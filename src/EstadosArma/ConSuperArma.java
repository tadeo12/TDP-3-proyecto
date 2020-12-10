package EstadosArma;

import java.awt.Point;

import Entidades.Jugador;
import Entidades.Proyectil;
import Entidades.SuperProyectil;
import EntidadesGraficas.Entidad_grafica;

public class ConSuperArma extends EstadoArma {

	public ConSuperArma(Jugador jugador) {
		super(jugador);
		velocidad_disparo *= 2;
	}

	@Override
	public Proyectil disparar() {
		Entidad_grafica g = this.jugador.getGrafico();
		return new SuperProyectil(new Point(g.getX(), g.getY() - 53));
	}

}
