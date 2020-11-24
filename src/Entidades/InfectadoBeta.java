package Entidades;

import java.awt.Point;

import EntidadesGraficas.Label_infectado_beta;
import Visitors.Visitor;

public class InfectadoBeta extends Infectado {
	

	public InfectadoBeta(Point p,int tiempoQuieto) {
		super(new Label_infectado_beta(p),tiempoQuieto);
		this.carga_viral=carga_viral*2;
		
	}

	@Override
	public Proyectil disparar() {
		return new ParticulaV_Beta(this.getGrafico());
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
