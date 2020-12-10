package Movimientos;

import java.awt.Container;

import Entidades.Entidad;
import Logica.Juego;

public abstract class EstrategiaMovimiento {
	protected int direccion;
	protected Entidad entidad;
	protected int limiteX, limiteY;

	public EstrategiaMovimiento(Entidad entidad, int direccion) {
		this.direccion = direccion;
		this.entidad = entidad;
		Container mapa = Juego.getJuego().getMapa();
		limiteX = (int) mapa.getWidth() - (int) entidad.getGrafico().getWidth();
		limiteY = (int) mapa.getHeight() - (int) entidad.getGrafico().getHeight();
	}

	public abstract void mover();

	public void setDireccion(int direccion) {
		this.direccion = direccion;
	}
}
