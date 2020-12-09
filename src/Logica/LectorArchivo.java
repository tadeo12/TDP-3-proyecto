package Logica;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LectorArchivo {

	private String archivoNormal = "Datos/generacionNormal.txt";
	private String archivoHardcore = "Datos/generacionHardcore.txt";

	private int cantTiposInfectados = 2;
	private int cantTandas = 6;

	public int[][] obtenerMatrizInfectado(int dificultad) {

		int[][] toReturn = new int[cantTandas][cantTiposInfectados];

		try {
			String rutaArchivo = dificultad == 0 ? archivoNormal : archivoHardcore;
			InputStream in = LectorArchivo.class.getClassLoader().getResourceAsStream(rutaArchivo);
			InputStreamReader inr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(inr);

			String linea = br.readLine();
			int fila = 0;
			while (linea != null) {

				String[] enteros = linea.split(" ");
				for (int i = 0; i < cantTiposInfectados; i++)
					toReturn[fila][i] = Integer.parseInt(enteros[i]);

				fila++;
				linea = br.readLine();
			}
			br.close();
//			for (int i = 0; i < cantTandas; i++) {
//				for (int j = 0; j < cantTiposInfectados; j++)
//					System.out.print(toReturn[i][j] + " ");
//				System.out.println();
//			}

		} catch (FileNotFoundException e) {
			System.out.println("No se encuentra archivo");
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.out.println("No se pudo convertir a entero");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error accediendo al archivo.");
			e.printStackTrace();
		}
		return toReturn;
	}
}
