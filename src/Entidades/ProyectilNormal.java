package Entidades;


import EntidadesGraficas.Entidad_grafica;
import EntidadesGraficas.Label_proyectil_normal;
import Visitors.Visitor;

public class ProyectilNormal extends ProyectilSanitario {

	public ProyectilNormal(Entidad_grafica entidad_jugador) {
		super(new Label_proyectil_normal(entidad_jugador));		
		velocidad = 10;
		visitor.setEntidad(this);
		damage = 2;
		
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
