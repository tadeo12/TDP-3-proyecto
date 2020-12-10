package Logica;

import Entidades.Infectado;

/**
 * clase que se encarga de la construccion de un nivel
 */
public class BuilderDefault extends BuilderNivel {

	private Tanda tandaActual;
	private int nivelesCreados;
	private boolean primerTanda;

	public BuilderDefault() {
		super();
		misFabricas.add(new FactoryAlpha());
		misFabricas.add(new FactoryBeta());
		nivelesCreados = 0;
		tandaActual = new Tanda();
		primerTanda = true;
	}

	@Override
	public void reset() {
		nivel = new Nivel(nivelesCreados);
		tandaActual = new Tanda();
		primerTanda = true;
	}

	@Override
	public void construirInfectado(int tipoInfectado) {
		// tipoInfectado debe coincidir con un indice valido de la lista de fabricas.
		// el tipo i es creado por la fabrica i
		Infectado inf = misFabricas.get(tipoInfectado).crearInfectado(!primerTanda);
		tandaActual.agregarInfectado(inf);
	}

	@Override
	public Nivel getNivel() {
		Nivel aRetornar = nivel;
		nivel = new Nivel(nivelesCreados);
		tandaActual = new Tanda();
		return aRetornar;
	}

	@Override
	public void siguienteTanda() {
		for (Factory f : misFabricas) {
			f.reiniciar();
		}
		nivel.agregarTanda(tandaActual);
		tandaActual = new Tanda(); // se crea la proxima tanda
		primerTanda = false;
	}

}
