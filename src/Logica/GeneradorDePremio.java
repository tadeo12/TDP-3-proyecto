package Logica;

import java.awt.Point;
import java.util.Random;
import Entidades.Premios.BajoCero;
import Entidades.Premios.Curacion;
import Entidades.Premios.Inmunidad;
import Entidades.Premios.SuperArma;
import Entidades.Premios.SuperVelocidad;

public class GeneradorDePremio {

	
	private static final int cantidadPremiosTemporales=4;
	private static final int cantidadPremios=5;
	
	public static void generar(Point p) {
		Random r= new Random();
		int indice=r.nextInt(cantidadPremios);
		Juego juego=Juego.getJuego();
		while(indice<cantidadPremiosTemporales && juego.getEstadoPremio(indice)) {
			indice=r.nextInt(cantidadPremios);
		}
		switch(indice) {
			case 0: new BajoCero(p);
				break;
			case 1: new Inmunidad(p);
				break;
			case 2: new SuperArma(p);
				break;
			case 3: new SuperVelocidad(p);
				break;
			case 4: new Curacion(p);
				break;
		}
	}
}
