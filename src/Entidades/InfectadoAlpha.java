package Entidades;

import java.awt.Point;
import EntidadesGraficas.Label_infectado_alpha;
import Visitors.Visitor;

public class InfectadoAlpha extends Infectado {

	protected boolean loco;

	public InfectadoAlpha(Point p, int tiempoQuieto, boolean enEspera) {
		super(new Label_infectado_alpha(p), tiempoQuieto, enEspera);
		loco = false;
	}

	@Override
	public void disminuirCargaViral(int desinfeccion) {
		if (!desinfectado) {
			if (carga_viral - desinfeccion <= 0) {
				carga_viral = 0;
				desinfectar();
			} else {
				carga_viral -= desinfeccion;
				if (carga_viral < 20 && !loco) {
					loco = true;
					velocidad = velocidad * 2; //al volverse loco la velocidad del infectado se duplica
				}
			}
		}
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	@Override
	public Proyectil disparar() {
		return new ParticulaV_Alpha(new Point(entidad_graf.getX(), entidad_graf.getY() + 40));
	}

}
