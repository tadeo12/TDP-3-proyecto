package EstadosArma;

import Entidades.Jugador;
import Entidades.Proyectil;

public abstract class EstadoArma {
	protected int velocidad_disparo;
	
	public EstadoArma(Jugador jugador) {
		
	}
	
	public abstract Proyectil disparar();
}
