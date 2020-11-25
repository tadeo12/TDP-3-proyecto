package Logica;

import Entidades.Infectado;

public class BuilderDefault extends BuilderNivel {
	
	private Tanda tandaActual;
	private int nivelesCreados;
	
	public BuilderDefault() {
		super();
		misFabricas.add(new FactoryAlpha());
		misFabricas.add(new FactoryBeta());
		nivelesCreados=0;
		tandaActual=new Tanda();
	}
	
	@Override
	public void reset() {
		nivel=new Nivel(nivelesCreados);
		tandaActual=new Tanda();
		
	}

	@Override
	public void construirInfectado(int tipoInfectado,boolean enEspera) {
		//System.out.println("tipoinf "+tipoInfectado);
		Infectado inf=misFabricas.get(tipoInfectado).crearInfectado(enEspera);
		tandaActual.agregarInfectado(inf);
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
		for(Factory f: misFabricas) {
			f.reiniciar();
		}
		nivel.agregarTanda(tandaActual);
		tandaActual= new Tanda();
		
	}

}
