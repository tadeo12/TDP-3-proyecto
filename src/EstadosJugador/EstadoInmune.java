package EstadosJugador;

import Entidades.Jugador;

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
