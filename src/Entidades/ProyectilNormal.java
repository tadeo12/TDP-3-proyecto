package Entidades;

import Logica.Juego;
import Visitors.Visitor;

public class ProyectilNormal extends ProyectilSanitario {

	public ProyectilNormal(Juego juego) {
		super(juego);
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
