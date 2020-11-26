package Logica;

import java.awt.Container;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.List;

import Entidades.Entidad;
import Entidades.Infectado;
import Entidades.Jugador;
import GUI.Gui;

public class Juego implements Runnable {
	private boolean moviendoIzquierda;
	private boolean moviendoDerecha;
	private boolean disparando;
	private boolean nivelCompletado;
	private static Juego juego;

	private boolean jugando;
	private Gui gui;
	private List<Entidad> entidades;
	private List<Entidad> aEliminar;
	private List<Entidad> aAgregar;

	private Director director;
	private Nivel nivelActual;
	private int valorNivel;

	private Juego() {
		valorNivel = 0;
		juego = this;
		moviendoIzquierda = false;
		moviendoDerecha = false;
		disparando = false;
		nivelCompletado = false;
		entidades = new LinkedList<Entidad>();
		aEliminar = new LinkedList<Entidad>();
		aAgregar = new LinkedList<Entidad>();

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
		getMapa().repaint();
	}

	public void nivelCompleto() {
		System.out.println("nivel completo");
		if (director.finJuego()) {
			gui.gano();
			jugando = false;
		} else {
			nivelActual = director.construirSiguienteNivel();
			this.valorNivel ++;
			this.gui.cambioNivel( this.valorNivel );
		}
	}

	public void setGUI(Gui gui) {
		this.gui = gui;
	}

	public int getNivel() {
		return this.nivelActual.getValor();
	}
	
	public boolean getNivelCompletado() {
		return this.nivelCompletado;
	}
	
	public void setNivelCompletado(boolean nivelCompleto) {
		this.nivelCompletado = nivelCompleto;
	}
	
	public void jugar() {
		try {
			director = new Director();
			this.gui.cambioNivel( this.valorNivel );

			nivelActual = director.construirSiguienteNivel();
			new Jugador();
			jugando = true;
			while (jugando) {
				for (Entidad e : entidades) {
					e.accionar();

				}
				Thread.sleep(15);

				removerEntidadesEliminadas();
				agregarEntidadesNuevas();
				detectarColisiones();
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
				if (colisionan(a, b) ) {
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

	public void eliminarInfectado(Infectado infectado) {
		nivelActual.eliminarInfectado(infectado);
		eliminarEntidad(infectado);

	}
	
	public void pausa() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
