package Entidades;

import Logica.Juego;
import Visitors.Visitor;

public class PremioTemporal extends Premio {
	protected int duracion;
	
	public PremioTemporal(Juego juego) {
		super(juego);
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
