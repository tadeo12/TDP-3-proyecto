package Logica;

import GUI.LectorArchivo;

public class Director {

	private int infectadosPorNivel[][];
	private int nivelActual;
	private int ultimoNivel;
	private BuilderNivel builder;
	
	private final int tandasPorNivel = 2;

	public Director() {
		nivelActual = 0;
		LectorArchivo l = new LectorArchivo();
		infectadosPorNivel = l.obtenerMatrizInfectado();
		builder= new BuilderDefault();
		ultimoNivel=(infectadosPorNivel.length/tandasPorNivel); 
	}

	public Nivel construirSiguienteNivel() {
		int cantInfectados;
		boolean primerTanda=true;
		System.out.println("nivel: "+(nivelActual+1));
		for (int n = 0; n < tandasPorNivel; n++) {
			for (int j = 0; j < infectadosPorNivel[0].length; j++) {
				cantInfectados = infectadosPorNivel[nivelActual * tandasPorNivel+n][j];
				for (int i = 0; i < cantInfectados; i++)
					builder.construirInfectado(j,!primerTanda);
			}
			primerTanda=false;
			builder.siguienteTanda(); 
		}
		Nivel retorno=builder.getNivel();
		retorno.setValor(nivelActual++);
		return retorno;
	}
	
	public boolean finJuego() {	
		return nivelActual == ultimoNivel;
	}
}
