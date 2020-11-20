package Logica;

import java.util.LinkedList;
import java.util.List;

import Entidades.Entidad;
import GUI.Gui;

public class Juego {
	private boolean moviendoIzquierda;
	private boolean moviendoDerecha;
	private boolean disparando;
	private static  Juego juego;

	private Gui gui;
	private List<Entidad> entidades;

	private Director director;
	private Nivel nivelActual;

	private Juego() {
		moviendoIzquierda = false;
		moviendoDerecha = false;
		disparando = false;
		entidades = new LinkedList<Entidad>();
		director = new Director();
		nivelActual=director.construirSiguienteNivel();
		juego = this;
	}
	
	public static Juego getJuego() {
		if(juego==null)
			juego= new Juego();
		return juego;
	}

	public boolean moviendoIzquierda() {
		return moviendoIzquierda;
	}

	public boolean moviendoDerecha() {
		return moviendoDerecha;
	}

	public boolean disparando() {
		return disparando;
	}

	public void agregarEntidad(Entidad nueva) {
		entidades.add(nueva);
	}

	public void eliminarEntidad(Entidad a_eliminar) {
		entidades.remove(a_eliminar);
	}
	
	
	public void nivelCompleto() {
		if(director.finJuego())
			gui.gano();
		else
			nivelActual=director.construirSiguienteNivel();
		
	}
	
	public void setGUI(Gui gui) {
		this.gui=gui;
	}

}
