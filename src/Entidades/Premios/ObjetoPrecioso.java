package Entidades.Premios;

import Logica.Juego;
import Visitors.Visitor;

public class ObjetoPrecioso extends Premio {

	public ObjetoPrecioso() {
		super();
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
