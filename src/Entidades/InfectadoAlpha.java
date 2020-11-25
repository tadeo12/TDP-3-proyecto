package Entidades;


import java.awt.Point;

import EntidadesGraficas.Label_infectado;
import EntidadesGraficas.Label_infectado_alpha;
import EntidadesGraficas.Label_infectado_beta;

import java.util.Random;

import javax.swing.ImageIcon;

import Movimientos.Horizontal;
import Movimientos.Horizontal_remove;

import Visitors.Visitor;

public class InfectadoAlpha extends Infectado {


	public InfectadoAlpha(Point p,int tiempoQuieto, boolean enEspera) {
		super(new Label_infectado_alpha(p),tiempoQuieto,enEspera);
		visitor.setEntidad(this);
	}

	@Override
	public void disminuirCargaViral(int desinfeccion) {
		if (desinfectado) {
			if (carga_viral - desinfeccion <= 0) {
				suelta_premio = true;
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

	@Override
	public Proyectil disparar() {
		return new ParticulaV_Alpha(this.getGrafico());
	}

	
}
