package Entidades;

public abstract class PremioTemporal extends Premio {
	protected int duracion;

	public PremioTemporal() {
		super();
	}

	public int getDuracion() {
		return duracion;
	}
}
