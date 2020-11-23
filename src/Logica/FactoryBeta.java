package Logica;

import Entidades.Infectado;
import Entidades.InfectadoBeta;

public class FactoryBeta extends Factory {

	@Override
	public Infectado crearInfectado() {
		return new InfectadoBeta();
	}

}
