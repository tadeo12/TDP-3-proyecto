package Entidades;

import EntidadesGraficas.Entidad_grafica;
import Visitors.Visitor;

public class InfectadoAlpha extends Infectado {
	private static final int desinfeccion = 20;

	public InfectadoAlpha(Entidad_grafica entidad) {
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

	@Override
	public void eliminar() {
		// TODO Auto-generated method stub

	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
