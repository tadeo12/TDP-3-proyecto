package Logica;

import Entidades.Infectado;

public class BuilderDefault extends BuilderNivel {
	
	private Tanda tandaActual;
	private int nivelesCreados;
	
	public BuilderDefault() {
		super();
		misFabricas.add(new FactoryAlpha());
		misFabricas.add(new FactoryBeta());
		misFabricas.add(new FactoryBoss());
		nivelesCreados=0;
	}
	
	@Override
	public void reset() {
		nivel=new Nivel(nivelesCreados);
		tandaActual=new Tanda();
		
	}

	@Override
	public void construirInfectado(int tipoInfectado) {
		Infectado inf= misFabricas.get(tipoInfectado).crearInfectado();

	}

	@Override
	public Nivel getNivel() {
		Nivel aRetornar=nivel;
		nivel=new Nivel(nivelesCreados);
		tandaActual=new Tanda();
		return aRetornar;
	}

	@Override
	public void siguienteTanda() {
		nivel.agregarTanda(tandaActual);
		tandaActual= new Tanda();
		
	}

}
