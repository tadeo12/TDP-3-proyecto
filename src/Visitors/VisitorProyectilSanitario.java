package Visitors;

import Entidades.*;

public class VisitorProyectilSanitario extends Visitor {

	public void visit(InfectadoAlpha i) {
		ProyectilSanitario e = (ProyectilSanitario) entidad;
		i.disminuirCargaViral(e.getDamage());
		e.eliminar();
	}

	public void visit(InfectadoBeta i) {
		ProyectilSanitario e = (ProyectilSanitario) entidad;		
		i.disminuirCargaViral(e.getDamage());
		e.eliminar();
	}

}
