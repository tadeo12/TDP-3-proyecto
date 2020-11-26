package Visitors;

import Entidades.Jugador;
import Entidades.Premios.PremioTemporal;

public class VisitorBajoCero extends VisitorPremioTemporal{

	public VisitorBajoCero(PremioTemporal entidad) {
		super (entidad);
	}
	
	
	public void visit(Jugador jug) {
		entidad.eliminar();
		//congelar infectados <3
	}
}
