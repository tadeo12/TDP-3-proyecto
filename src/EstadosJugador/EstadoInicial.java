package EstadosJugador;

import Entidades.Jugador;
import Visitors.VisitorJugador;

public class EstadoInicial extends EstadoJugador {

	public EstadoInicial(Jugador jugador) {
		super(jugador);
		jugador.setVisitor(new VisitorJugador());
	}

}
