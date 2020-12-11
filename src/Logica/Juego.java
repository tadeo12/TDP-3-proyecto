package Logica;

import java.awt.Container;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.List;

import Entidades.Entidad;
import Entidades.Infectado;
import Entidades.Jugador;
import EntidadesGraficas.Entidad_grafica;
import EntidadesGraficas.Label_jugador;
import GUI.Gui;

/**
 * clase que modela la logica del juego. se utilizo el patron de diseño
 * singleton para que no se pueda tener dos instancias del juego distintas al
 * mismo tiempo y la instancia actual pueda se accedida desde cualquier parte
 * del programa. En esta clase se implementa la ejecucion principal del juego y
 * funciona como nexo entre la parte loguica y la gui
 */
public class Juego implements Runnable {

	// Atributos booleanos que indican el comportamiento del usuario
	private boolean moviendoIzquierda;
	private boolean moviendoDerecha;
	private boolean disparando;


	// Atributo utilizado para el patron singleton
	private static Juego juego;

	// Listas de entidades

	private List<Entidad> entidades;
	private List<Entidad> aEliminar;
	private List<Entidad> aAgregar;

	// Otros atributos
	private boolean jugando;
	private Gui gui;
	private Jugador jugador;
	private Director director;
	private Nivel nivelActual;
	private int dificultad;

	private boolean[] powerUps;

	/**
	 * El constructor es privado para que funcione el patron singleton
	 */
	private Juego() {
		juego = this;
		moviendoIzquierda = false;
		moviendoDerecha = false;
		disparando = false;
		entidades = new LinkedList<Entidad>();
		aEliminar = new LinkedList<Entidad>();
		aAgregar = new LinkedList<Entidad>();
		dificultad = 0;
		powerUps = new boolean[4];
		for (int i = 0; i < 4; i++) {
			powerUps[i] = false;
		}

	}

	/**
	 * metodo estatico para que se pueda obtener la instancia de Juego desde
	 * cualquier parte del programa
	 * 
	 * @return instancia actual del juego
	 */
	public static Juego getJuego() {
		if (juego == null) {
			juego = new Juego();
		}
		return juego;
	}

	// metodos para actualizar el comportamiento del usuario/jugador

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
		aAgregar.add(nueva);// se agrega en la lista auxiliar por que no se puede modificar la lista de
							// entidades actuales mientras se ejecuta los accionar
	}

	public void eliminarEntidad(Entidad a_eliminar) {
		aEliminar.add(a_eliminar);
		// se agrega en la lista auxiliar de entidades para eliminar por que no se puede
		// modificar la lista de entidades actuales mientras se ejecuta los accionar
		Entidad_grafica ent = a_eliminar.getGrafico();
		if (jugando) {
			getMapa().remove(ent);
			getMapa().repaint();
		}
	}

	public void nivelCompleto() {
		if (director.finJuego()) {// el director se encarga de saber si existe un proximo nivel
			juego = null;
			// se setea nulo para que al empezar otra partida se cree otra instancia deJuego
			gui.gano();
			jugando = false;// corta la ejecucion del juego
		} else {
			siguienteNivel();
		}
	}

	private void siguienteNivel() {
		for (Entidad e : entidades) {// se remueve las entidades del mapa excepto el jugador (proyectiles,
										// premios,etc)
			if (e != jugador) {
				gui.getMapa().remove(e.getGrafico());
			}
		}
		entidades = new LinkedList<Entidad>();// reinicio la lista de entidades
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

	}

	private void actualizarDatosJuego() {
		gui.actualizarBarraViral(jugador.getCargaViral());
		gui.actualizarNivelTanda(nivelActual.getValor() + 1, nivelActual.getNumeroTanda() + 1);
		gui.actualizarPowerUps(powerUps);
		Label_jugador labelJugador=(Label_jugador)jugador.getGrafico();
		labelJugador.setPowerUp(powerUps);
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

	public void eliminarInfectado(Infectado infectado) {
		nivelActual.eliminarInfectado(infectado);
		eliminarEntidad(infectado);

	}

	/**
	 * detiene la ejecucion del juego brevemente, por 3 segundos
	 */
	public void pausa() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	/**
	 * metodo para notificar que el jugador fue infectado
	 */
	public void perdio() {
		this.juego = null;
		jugando = false;
		gui.perdio();
	}

	public List<Infectado> getInfectados() {
		return nivelActual.getTanda().getInfectados();
	}

	/**
	 * método para notificar al juego que se genero un proyectil lanzado por el
	 * jugador
	 */
	public void seDisparo() {
		gui.sonidoDisparar();
	}

	/**
	 * método que setea la dificultad del juego, si se modifica luego de que se
	 * empieze a jugar (con run()) no tendra efecto
	 * 
	 * @param dificultad
	 */
	public void setDificultad(int dificultad) {
		if (dificultad > 0)
			this.dificultad = 1;
	}

	public boolean jugando() {
		return jugando;
	}

	//métodos requeridos para saber cuales son las mejoras que posee el jugador actualmente
	public void setEstadoPremio(int i, boolean estado) {
		powerUps[i] = estado;
	}

	public boolean getEstadoPremio(int valorPremio) {
		return powerUps[valorPremio];
	}

}
