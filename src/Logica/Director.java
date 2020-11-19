package Logica;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

import GUI.LectorArchivo;

public class Director {

	private final String rutaArchivo = "Datos/cantInfectados.txt";

	private int infectadosPorNivel[][];
	private int nivelActual;

	public Director() {
		int actual = 0;
		LectorArchivo l = new LectorArchivo();
		infectadosPorNivel = l.obtenerMatrizInfectado();

	}

	public Nivel construirSiguienteNivel() {

		return null;
	}

}
