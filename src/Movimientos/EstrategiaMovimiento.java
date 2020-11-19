package Movimientos;

import Entidades.Entidad;

public abstract class EstrategiaMovimiento {
	protected int direccion;
	protected Entidad entidad;
	protected int limiteX, limiteY;

	public EstrategiaMovimiento(Entidad entidad, int direccion) {
		this.direccion = direccion;
		this.entidad = entidad;
		limiteX = (int) entidad.getGrafico().getParent().getBounds().getMaxX()
				- (int) entidad.getGrafico().getBounds().getMaxX();
		limiteY = (int) entidad.getGrafico().getParent().getBounds().getMaxY()
				- (int) entidad.getGrafico().getBounds().getMaxY();
	}

	public abstract void mover();

	public void setDireccion(int direccion) {
		this.direccion = direccion;
	}
}
