package Movimientos;

import Entidades.Entidad;

public abstract class EstrategiaMovimiento {
	protected int direccion;
	protected Entidad entidad;
	protected int limiteX, limiteY;
	
	public EstrategiaMovimiento(Entidad entidad, int direccion) {
		this.direccion = direccion;
		this.entidad = entidad;
		limiteX=(int) entidad.getGrafico().getParent().bounds().getMaxX();
		limiteY=(int) entidad.getGrafico().getParent().bounds().getMaxY();
	}
	
	public abstract void mover();
	
	public void setDireccion(int direccion) {
		this.direccion = direccion;
	}
}
