package Logica;

import java.awt.Point;
import java.util.Random;

import Entidades.*;
import Entidades.Premios.BajoCero;
import Entidades.Premios.Curacion;
import Entidades.Premios.Inmunidad;
import Entidades.Premios.SuperArma;
import Entidades.Premios.SuperVelocidad;

public class GeneradorDePremio {
	
	public static void generar(Point p) {
		Random r= new Random();
		int indice=r.nextInt(5);	
		indice=3;
		switch(indice) {
			case 0: new SuperArma(p);
				break;
			case 1: new SuperVelocidad(p);
				break;
			case 2: new Inmunidad(p);
				break;
			case 3: new BajoCero(p);
				break;
			case 4: new Curacion(p);
				break;
				
			
		}
	}
}
