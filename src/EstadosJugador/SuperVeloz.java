package EstadosJugador;

import Entidades.Jugador;

public class SuperVeloz extends ConPowerUp {

	public SuperVeloz(Jugador jugador) {
		super(jugador);
		jugador.setVelocidad(jugador.getVelocidad() * 2);
	}

}
