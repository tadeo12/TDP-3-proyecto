package Entidades;

import EntidadesGraficas.Label_infectado_alpha;
import Movimientos.Vertical;
import Movimientos.Vertical_loop;
import Visitors.Visitor;

public class InfectadoAlpha extends Infectado {

	public InfectadoAlpha() {
		super(new Label_infectado_alpha());
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

	@Override
	public Proyectil disparar() {
		return new ParticulaV_Alpha(this.getGrafico());
	}
}
