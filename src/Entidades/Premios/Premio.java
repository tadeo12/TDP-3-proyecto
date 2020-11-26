package Entidades.Premios;

import Entidades.Entidad;
import EntidadesGraficas.Entidad_grafica;
import Movimientos.Vertical;
import Visitors.Visitor;

public abstract class Premio extends Entidad {

	public Premio(Entidad_grafica entidad_graf) {
		super(entidad_graf);
		movimiento = new Vertical(this,Vertical.ABAJO);
		velocidad = 4;
	}
	
	public abstract void accept(Visitor visitor);
}
