package Logica;

import java.util.LinkedList;
import java.util.List;

import Entidades.Entidad;
import GUI.Gui;

public class Juego {
	private boolean moviendoIzquierda;
	private boolean moviendoDerecha;
	private boolean disparando;

	private Gui gui;
	private List<Entidad> entidades;

	private Director director;

	public Juego(Gui gui) {
		moviendoIzquierda = false;
		moviendoDerecha = false;
		disparando = false;
		this.gui = gui;
		entidades = new LinkedList<Entidad>();
		director = new Director();
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

}
