package GUI;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LectorArchivo {

	private String rutaArchivo = "Datos/generadorInfectados.txt";

	private int cantTiposInfectados = 3;
	private int cantNiveles = 3;

	public int[][] obtenerMatrizInfectado() {

		int[][] toReturn = new int[cantNiveles][cantTiposInfectados];

		try {
			
			InputStream in = LectorArchivo.class.getClassLoader().getResourceAsStream(rutaArchivo);
            InputStreamReader inr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(inr);
			
			String linea = br.readLine();
			int fila = 0; 
			while (linea != null) {
				
				String[] enteros = linea.split(" ");
				for (int i = 0; i < enteros.length; i++)
					toReturn[fila][i] = Integer.parseInt(enteros[i]);

				fila++; 
				linea = br.readLine(); 
			}
			br.close();


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
