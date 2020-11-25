package Logica;

import Entidades.Infectado;

public abstract class Factory {
	public abstract Infectado crearInfectado(boolean enEspera);

	protected abstract void reiniciar();
}
