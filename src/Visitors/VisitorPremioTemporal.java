package Visitors;

import Entidades.Entidad;

public class VisitorPremioTemporal extends Visitor {
	
	public int duracion;

	public VisitorPremioTemporal(Entidad entidad) {
		super(entidad);
	}

}
