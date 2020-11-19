package EstadosJugador;

import Entidades.Jugador;

public abstract class EstadoJugador {
	protected Jugador jugador;
	
	public EstadoJugador(Jugador jugador) {
		this.jugador = jugador;
	}
}
