package EstadosArma;

import Entidades.Jugador;
import Entidades.Proyectil;
import Entidades.ProyectilNormal;

public class ConArmaNormal extends EstadoArma{

	public ConArmaNormal(Jugador jugador) {
		super(jugador);
		
	}

	@Override
	public Proyectil disparar() {
		return new ProyectilNormal(jugador.getGrafico());
	}

}
