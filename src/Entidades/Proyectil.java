package Entidades;

import EntidadesGraficas.Entidad_grafica;

public abstract class Proyectil extends Entidad {
	protected int damage;

	public Proyectil() {
		super();
	}

	public int getDamage() {
		return this.damage;
	}
}
