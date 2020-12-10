package EstadosJugador;

import Entidades.Jugador;

public class EstadoInmune extends ConPowerUp {

	public EstadoInmune(Jugador jugador) {
		super(jugador);
		velocidad = jugador.getVelocidad();
	}

	@Override
	public void incrementarCargaViral(int carga) {
		//no hace nada porque es inmune 
	}
}
