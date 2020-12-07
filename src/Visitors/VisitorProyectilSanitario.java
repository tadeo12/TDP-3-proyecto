package Visitors;

import Entidades.*;

public class VisitorProyectilSanitario extends Visitor {

	public VisitorProyectilSanitario(Proyectil entidad) {
		super(entidad);
	}
	
	public void visit(InfectadoAlpha i) {
		ProyectilSanitario e = (ProyectilSanitario) entidad;
		e.eliminar();
		i.disminuirCargaViral(e.getDamage());
		
	}

	public void visit(InfectadoBeta i) {
		ProyectilSanitario e = (ProyectilSanitario) entidad;		
		i.disminuirCargaViral(e.getDamage());
		e.eliminar();
	}

}
