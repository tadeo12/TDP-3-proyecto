package Logica;

import java.awt.Point;
import java.util.Random;

import Entidades.*;

public class GeneradorDePremio {
	private String[] premios= {"superArma","superVelocidad" ,"inmunidad","bajoCero","curacion"};
	
	
	public static void generar(Point p) {
		Random r= new Random();
		int indice=r.nextInt(5);
		switch(indice) {
			case 0: new SuperArma(p);
				break;
			case 1: new superVelocidad(p);
				break;
			case 2: new inmunidad(p);
				break;
			case 3: new bajoCero(p);
				break;
			case 4: new curacion(p);
				break;
				
			
		}
	}
}
