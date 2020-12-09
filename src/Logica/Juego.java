package Logica;

import java.awt.Container;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.List;

import Entidades.Entidad;
import Entidades.Infectado;
import Entidades.Jugador;
import EntidadesGraficas.Entidad_grafica;
import GUI.Gui;

public class Juego implements Runnable {
	private boolean moviendoIzquierda;
	private boolean moviendoDerecha;
	private boolean disparando;

	private static Juego juego;//

	private boolean jugando;
	private Gui gui;//
	private List<Entidad> entidades;
	private List<Entidad> aEliminar;
	private List<Entidad> aAgregar;
	private Jugador jugador;

	private Director director;
	private Nivel nivelActual;
	private int dificultad;

	private boolean[] powerUps;

	private Juego() {
		juego = this;
		moviendoIzquierda = false;
		moviendoDerecha = false;
		disparando = false;
		entidades = new LinkedList<Entidad>();
		aEliminar = new LinkedList<Entidad>();
		aAgregar = new LinkedList<Entidad>();
		dificultad = 0;
		powerUps = new boolean [4];
		for (int i = 0; i < 4; i++) {
			powerUps[i]=false;
		}

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
		Entidad_grafica ent = a_eliminar.getGrafico();
		if (jugando) {
			getMapa().remove(ent);
			getMapa().repaint();
		}
	}

	public void nivelCompleto() {
		if (director.finJuego()) {
			this.juego = null;
			gui.gano();
			jugando = false;
		} else {
			siguienteNivel();
		}
	}

	private void siguienteNivel() {
		for (Entidad e : entidades) {
			if (e != jugador) {
				gui.getMapa().remove(e.getGrafico());
			}
		}
		entidades = new LinkedList<Entidad>();
		entidades.add(jugador);
		nivelActual = director.construirSiguienteNivel();
		this.gui.cambioNivel(nivelActual.getValor() + 1);

	}

	public void setGUI(Gui gui) {
		this.gui = gui;
	}

	public int getNivel() {
		return this.nivelActual.getValor();
	}

	public void jugar() {
		try {
			jugando = true;
			director = new Director(dificultad);
			this.gui.cambioNivel(1);
			nivelActual = director.construirSiguienteNivel();
			jugador = new Jugador();
			while (jugando) {
				for (Entidad e : entidades) {
					e.accionar();
				}
				Thread.sleep(10);
				removerEntidadesEliminadas();
				agregarEntidadesNuevas();
				detectarColisiones();
				actualizarDatosJuego();
			}
		} catch (IllegalArgumentException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void actualizarDatosJuego() {
		gui.actualizarBarraViral(jugador.getCargaViral());
		gui.actualizarNivelTanda(nivelActual.getValor() + 1, nivelActual.getNumeroTanda() + 1);
		gui.actualizarPowerUps(powerUps);
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

			e.printStackTrace();
		}
	}

	public void perdio() {
		this.juego = null;
		jugando = false;
		gui.perdio();
	}

	public List<Infectado> getInfectados() {
		return nivelActual.getTanda().getInfectados();
	}

	public void seDisparo() {
		gui.sonidoDisparar();
	}

	public void setDificultad(int dificultad) {
		if (dificultad > 0)
			this.dificultad = 1;
	}

	public boolean jugando() {
		return jugando;
	}

	public void setEstadoPremio(int i, boolean estado) {
		powerUps[i]=estado;
	}
	
	public boolean getEstadoPremio(int valorPremio) {
		return powerUps[valorPremio];
	}

}
