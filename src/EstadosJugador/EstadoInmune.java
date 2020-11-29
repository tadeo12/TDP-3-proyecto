package EstadosJugador;

import Entidades.Jugador;
import Visitors.VisitorJugadorInmune;

public class EstadoInmune extends ConPowerUp {

	public EstadoInmune(Jugador jugador) {
		super(jugador);
		velocidad = jugador.getVelocidad();
	}

	@Override
	public void incrementarCargaViral(int carga) {
		// TODO Auto-generated method stub
		//no hacenada por que es inmune 
	}
}
