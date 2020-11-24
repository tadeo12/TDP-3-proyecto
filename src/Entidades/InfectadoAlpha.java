package Entidades;

import java.util.Random;

import EntidadesGraficas.Label_infectado_alpha;
import Movimientos.Horizontal;
import Movimientos.Horizontal_remove;
import Movimientos.Vertical;
import Movimientos.Vertical_loop;
import Visitors.Visitor;

public class InfectadoAlpha extends Infectado {

	public InfectadoAlpha() {
		super(new Label_infectado_alpha());
		visitor.setEntidad(this);
	}

	@Override
	public void disminuirCargaViral(int desinfeccion) {
		if (dispara) {
			if (carga_viral - desinfeccion <= 0) {
				suelta_premio = true;
				carga_viral = 0;
				desinfectado();
			} else {
				carga_viral -= desinfeccion;
			}
		}
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	@Override
	public Proyectil disparar() {
		return new ParticulaV_Alpha(this.getGrafico());
	}

	public void desinfectado() {
		Random ra = new Random();
		dispara = false;
		int direccion = ra.nextInt(2);
		if (direccion == 1) {
			movimiento = new Horizontal_remove(this, Horizontal.DERECHA);
		} else
			movimiento = new Horizontal_remove(this, Horizontal.IZQUIERDA);

	}
}
