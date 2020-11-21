package Entidades;

import Logica.Juego;
import Visitors.Visitor;

public class ObjetoPrecioso extends Premio {

	public ObjetoPrecioso(Juego juego) {
		super();
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
