package Entidades.Premios;

import java.awt.Point;

import Logica.Juego;
import Visitors.Visitor;

public abstract class ObjetoPrecioso extends Premio {

	public ObjetoPrecioso() {
		super();
	}

	public abstract void accept(Visitor visitor);
}
