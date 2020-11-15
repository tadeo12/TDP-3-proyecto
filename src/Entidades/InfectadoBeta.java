package Entidades;

import EntidadesGraficas.Entidad_grafica;
import Visitors.Visitor;

public class InfectadoBeta extends Infectado {
	private static final int desinfeccion = 10;

	public InfectadoBeta(Entidad_grafica entidad) {
		super(entidad);
	}

	@Override
	public void disminuirCargaViral() {
		if (carga_viral - desinfeccion <= 0) {
			suelta_premio = true;
			carga_viral = 0;
		} else {
			carga_viral -= desinfeccion;
		}

	}

	public void eliminar() {
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
