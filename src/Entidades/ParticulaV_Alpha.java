package Entidades;

import EntidadesGraficas.Entidad_grafica;
import EntidadesGraficas.Label_particulaV_Alpha;
import Movimientos.Vertical;
import Movimientos.VerticalRemoveRango;

public class ParticulaV_Alpha extends ParticulaV{

	public ParticulaV_Alpha(Entidad_grafica entidad_infectado) {
		super(new Label_particulaV_Alpha(entidad_infectado));
		velocidad =  6;
		damage = 3;
		rango=400;
		movimiento = new VerticalRemoveRango(this, Vertical.ABAJO);
	}

}
