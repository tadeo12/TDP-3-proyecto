package Visitors;

import Entidades.*;

public class VisitorProyectilSanitario extends Visitor {

	public void visit(InfectadoAlpha i) {
		ProyectilSanitario e = (ProyectilSanitario) entidad;
		e.eliminar();
		i.disminuirCargaViral(e.getDamage());
	}

	public void visit(InfectadoBeta i) {
		ProyectilSanitario e = (ProyectilSanitario) entidad;
		e.eliminar();
		i.disminuirCargaViral(e.getDamage());
	}

	

}
