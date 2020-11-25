 package Entidades;

import EntidadesGraficas.Entidad_grafica;
import EntidadesGraficas.Label_super_proyectil;
import Visitors.Visitor;

public class SuperProyectil extends ProyectilSanitario {

	public SuperProyectil(Entidad_grafica entidad_jugador) {
		super(new Label_super_proyectil(entidad_jugador));
		visitor.setEntidad(this);
		damage = 10;
		velocidad = 4;
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
