package EstadosJugador;

import Entidades.Jugador;
import Visitors.VisitorJugadorInmune;

public class Inmune extends ConPowerUp {

	public Inmune(Jugador jugador) {		
		super(jugador);
		jugador.setVisitor(new VisitorJugadorInmune(jugador));
	}

}
