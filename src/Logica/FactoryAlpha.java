package Logica;

import Entidades.Infectado;
import Entidades.InfectadoAlpha;

public class FactoryAlpha extends Factory {

	@Override
	public Infectado crearInfectado() {
		return new InfectadoAlpha();
	}

}
