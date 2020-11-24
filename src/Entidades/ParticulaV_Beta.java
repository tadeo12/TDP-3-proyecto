package Entidades;

import EntidadesGraficas.Entidad_grafica;
import EntidadesGraficas.Label_particulaV_Beta;
import Visitors.VisitorParticulaV;

public class ParticulaV_Beta extends ParticulaV{

	public ParticulaV_Beta(Entidad_grafica entidad_infectado) {
		super(new Label_particulaV_Beta(entidad_infectado));
		velocidad = 5;		
	
	}

}