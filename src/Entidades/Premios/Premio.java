package Entidades.Premios;

import Entidades.Entidad;
import EntidadesGraficas.Entidad_grafica;
import Movimientos.Vertical;
import Movimientos.Vertical_remove;
import Visitors.Visitor;

public abstract class Premio extends Entidad {

	public Premio(Entidad_grafica entidad_graf) {
		super(entidad_graf);
		velocidad = 4;
		movimiento = new Vertical_remove(this,Vertical.ABAJO);		
	}
	
	public abstract void accept(Visitor visitor);
}
