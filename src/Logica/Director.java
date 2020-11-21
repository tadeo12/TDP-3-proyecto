package Logica;

import GUI.LectorArchivo;

public class Director {

	private int infectadosPorNivel[][];
	private int nivelActual;
	private BuilderNivel builder;
	
	private final int tandasPorNivel = 2;

	public Director() {
		System.out.println("estoy en dire");
		nivelActual = 0;
		LectorArchivo l = new LectorArchivo();
		infectadosPorNivel = l.obtenerMatrizInfectado();
		builder= new BuilderDefault();
	}

	public Nivel construirSiguienteNivel() {
		int cantInfectados;
		for (int n = 0; n < tandasPorNivel; n++) {
			for (int j = 0; j < infectadosPorNivel[0].length; j++) {
				cantInfectados = infectadosPorNivel[nivelActual * tandasPorNivel][j];
				for (int i = 0; i < cantInfectados; i++)
					builder.construirInfectado(j);
			}
			builder.siguienteTanda();
		}
		nivelActual++;
		return builder.getNivel();
	}
	
	public boolean finJuego() {
		return nivelActual==infectadosPorNivel.length;
	}
}
