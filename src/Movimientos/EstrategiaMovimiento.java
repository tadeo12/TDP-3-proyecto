package Movimientos;

import java.awt.Container;

import Entidades.Entidad;

public abstract class EstrategiaMovimiento {
	protected int direccion;
	protected Entidad entidad;
	protected int limiteX, limiteY;

	/**
	 * Crea la estrategia de movimiento de la entidad
	 * @param entidad 
	 * @param direccion
	 */
	public EstrategiaMovimiento(Entidad entidad, int direccion) {
		this.direccion = direccion;
		this.entidad = entidad;
		Container mapa = entidad.getJuego().getMapa();
		limiteX = (int) mapa.getWidth() - (int) entidad.getGrafico().getWidth();
		limiteY = (int) mapa.getHeight() - (int) entidad.getGrafico().getHeight();
	}

	/**
	 * Mueve la entidad a su posicion siguiente 
	 */
	public abstract void mover();

	/**
	 * Settea la direcci�n de movimiento de la entidad
	 * @param direccion
	 */
	public void setDireccion(int direccion) {
		this.direccion = direccion;
	}
}
