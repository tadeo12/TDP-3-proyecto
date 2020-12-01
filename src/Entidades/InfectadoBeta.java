package Entidades;


import java.awt.Point;

import java.util.Random;

import EntidadesGraficas.Label_infectado;
import EntidadesGraficas.Label_infectado_beta;
import Movimientos.Horizontal;
import Movimientos.Horizontal_remove;
import Visitors.Visitor;

public class InfectadoBeta extends Infectado {

	public InfectadoBeta(Point p,int tiempoQuieto, boolean enEspera) {
		super(new Label_infectado_beta(p),tiempoQuieto,enEspera);
		this.carga_viral=carga_viral*2;

	}

	@Override
	public Proyectil disparar() {
		return new ParticulaV_Beta(this.getGrafico());
	}

	@Override
	public void disminuirCargaViral(int desinfeccion) {
		if (!desinfectado) {
			if (carga_viral - desinfeccion <= 0) {
				carga_viral = 0;
				desinfectar();
			} else {
				carga_viral -= desinfeccion;
			}
		}
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	
	
}
