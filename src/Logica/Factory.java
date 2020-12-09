package Logica;

import java.awt.Container;
import java.util.Random;

import Entidades.Infectado;

public abstract class Factory {
	protected Container mapa;
	protected Random r;
	protected int tiempo;

	public Factory() {
		tiempo = 1;
		mapa = Juego.getJuego().getMapa();
		r = new Random();
	}

	public abstract Infectado crearInfectado(boolean enEspera);

	protected abstract void reiniciar();
}
