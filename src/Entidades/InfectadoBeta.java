package Entidades;

import Visitors.Visitor;

public class InfectadoBeta extends Infectado {
	

	public InfectadoBeta() {
		super();
		this.carga_viral=carga_viral*2;
	}

	@Override
	public void disminuirCargaViral(int desinfeccion) {
		if (carga_viral - desinfeccion <= 0) {
			suelta_premio = true;
			carga_viral = 0;
		} else {
			carga_viral -= desinfeccion;
		}

	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
