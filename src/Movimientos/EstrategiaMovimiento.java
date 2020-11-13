package Movimientos;

import Entidades.Entidad;

public abstract class EstrategiaMovimiento {
	protected int direccion;
	protected Entidad entidad;
	
	public EstrategiaMovimiento(Entidad entidad, int direccion) {
		this.direccion = direccion;
		this.entidad = entidad;
	}
	
	public abstract void mover();
	
	public void setDireccion(int direccion) {
		this.direccion = direccion;
	}
}
