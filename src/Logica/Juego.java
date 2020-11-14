package Logica;

import java.util.LinkedList;
import java.util.List;

import Entidades.Entidad;
import GUI.GUI;

public class Juego {
	
	private boolean moviendoIzquierda;
	private boolean moviendoDerecha;
	private boolean disparando;
	
	private GUI gui;
	
	private List<Entidad> entidades;
	
	private Director director;
	
	public Juego(GUI gui) {
		moviendoIzquierda=false;
		moviendoDerecha=false;
		disparando=false;
		this.gui=gui;
		entidades= new LinkedList<Entidad>();
		director= new Director();
	}
	
	
	
}
