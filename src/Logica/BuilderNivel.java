package Logica;

import java.util.List;

public abstract class BuilderNivel {
	
	protected List<Factory> misFabricas;
	protected Nivel nivel;
	
	public abstract void reset();
	public abstract void construirInfectado(int tipoInfectado);
	public abstract Nivel getNivel();
	
}
