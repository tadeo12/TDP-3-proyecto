package EstadosJugador;

import Entidades.Jugador;
import Visitors.VisitorJugador;

public class EstadoInicial extends EstadoJugador {

	public EstadoInicial(Jugador jugador) {
		super(jugador);
		velocidad=3; 
		this.jugador.setVisitor(new VisitorJugador(jugador));
	}

	
	
	
	

}
