package Entidades;


import EntidadesGraficas.Entidad_grafica;
import EntidadesGraficas.Label_proyectil_normal;
import Visitors.Visitor;

public class ProyectilNormal extends ProyectilSanitario {

	public ProyectilNormal(Entidad_grafica entidad_jugador) {
		super(new Label_proyectil_normal(entidad_jugador));		
		velocidad = 6;
		damage = 5;

		
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
