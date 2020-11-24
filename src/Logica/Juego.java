package Logica;

import java.awt.Container;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.List;

import Entidades.Entidad;
import Entidades.Jugador;
import GUI.Gui;

public class Juego implements Runnable {
	private boolean moviendoIzquierda;
	private boolean moviendoDerecha;
	private boolean disparando;
	private static Juego juego;

	private Gui gui;
	private List<Entidad> entidades;
	private List<Entidad> aEliminar;
	private List<Entidad> aAgregar;

	private Director director;
	private Nivel nivelActual;

	private Juego() {
		juego = this;
		moviendoIzquierda = false;
		moviendoDerecha = false;
		disparando = false;
		entidades = new LinkedList<Entidad>();
		aEliminar = new LinkedList<Entidad>();
		aAgregar = new LinkedList<Entidad>();
		director = new Director();
	}

	public static Juego getJuego() {
		if (juego == null) {
			juego = new Juego();			
		}
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

	public void setMoviendoIzquierda(boolean mov) {
		this.moviendoIzquierda = mov;
	}

	public void setMoviendoDerecha(boolean mov) {
		this.moviendoDerecha = mov;
	}

	public void setDisparando(boolean mov) {
		this.disparando = mov;
	}

	public void agregarEntidad(Entidad nueva) {
		aAgregar.add(nueva);
	}

	public void eliminarEntidad(Entidad a_eliminar) {
		aEliminar.add(a_eliminar);
		getMapa().remove(a_eliminar.getGrafico());
	}

	public void nivelCompleto() {
		if (director.finJuego())
			gui.gano();
		else
			nivelActual = director.construirSiguienteNivel();

	}

	public void setGUI(Gui gui) {
		this.gui = gui;
	}

	public void jugar() {
		try {
			aAgregar.add(new Jugador());
			while (true) {
				for (Entidad e : entidades) {
					e.accionar();
					
				}
				Thread.sleep(15);
//				detectarColisiones();
				removerEntidadesEliminadas();
				agregarEntidadesNuevas();
			}
		} catch (IllegalArgumentException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void detectarColisiones() {
		int cantEntidades = entidades.size();
		for (int i = 0; i < cantEntidades; i++) {
			Entidad a = entidades.get(i);
			for (int j = i + 1; j < cantEntidades; j++) {
				Entidad b = entidades.get(j);
				if (colisionan(a, b)) {
					a.accept(b.getVisitor());
					b.accept(a.getVisitor());
				}
			}
		}
	}

	private boolean colisionan(Entidad a, Entidad b) {
		Rectangle A = a.getGrafico().getBounds();
		Rectangle B = b.getGrafico().getBounds();
		return A.intersects(B);
	}

	private void removerEntidadesEliminadas() {
		for (Entidad e : aEliminar) {
			entidades.remove(e);
		}
		aEliminar = new LinkedList<Entidad>();
	}

	private void agregarEntidadesNuevas() {
		for (Entidad e : aAgregar) {
			entidades.add(e);
		}
		aAgregar = new LinkedList<Entidad>();
	}

	public Container getMapa() {
		return gui.getMapa();
	}

	@Override
	public void run() {
		
		jugar();
	}

}
