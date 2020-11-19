package Entidades;

import Logica.Juego;
import Visitors.Visitor;

public class SuperProyectil extends ProyectilSanitario {

	public SuperProyectil(Juego juego) {
		super(juego);
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
