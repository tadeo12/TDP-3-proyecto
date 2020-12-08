package Entidades;

import EntidadesGraficas.Entidad_grafica;
import EntidadesGraficas.Label_particulaV_Beta;
import Movimientos.EstrategiaMovimiento;
import Movimientos.Vertical;
import Movimientos.VerticalRemoveRango;
import Visitors.VisitorParticulaV;

public class ParticulaV_Beta extends ParticulaV {

	public ParticulaV_Beta(Entidad_grafica entidad_infectado) {
		super(new Label_particulaV_Beta(entidad_infectado.getLocation()));
		velocidad = 5;
		damage = 5;
		rango = 300;
		movimiento = new VerticalRemoveRango(this, Vertical.ABAJO);
	}

}