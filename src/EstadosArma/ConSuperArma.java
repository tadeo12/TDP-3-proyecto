package EstadosArma;

import Entidades.Jugador;
import Entidades.Proyectil;
import Entidades.SuperProyectil;

public class ConSuperArma extends EstadoArma {

	public ConSuperArma(Jugador jugador) {
		super(jugador);
		velocidad_disparo *=2;
	}

	@Override
	public Proyectil disparar() {
		
		return new SuperProyectil(jugador.getGrafico().getLocation());
	}

}
