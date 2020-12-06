package GUI;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import Logica.Juego;
public class OyenteTeclado implements KeyListener {
	private Juego juego;
	private Clip disparo;
	
	public OyenteTeclado(Juego j){
		juego=j;
	}
	
	public void keyTyped(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
		int codigoTecla = e.getKeyCode();
		if (codigoTecla == KeyEvent.VK_LEFT || codigoTecla == KeyEvent.VK_A) {
			juego.setMoviendoIzquierda(true);
		}
		if (codigoTecla == KeyEvent.VK_RIGHT || codigoTecla == KeyEvent.VK_D) {
			juego.setMoviendoDerecha(true);
		}
		if (codigoTecla == KeyEvent.VK_SPACE) {
			juego.setDisparando(true);
			
		}
	}

	public void keyReleased(KeyEvent e) {
		int codigoTecla = e.getKeyCode();
		if (codigoTecla == KeyEvent.VK_LEFT || codigoTecla == KeyEvent.VK_A) {
			juego.setMoviendoIzquierda(false);
			
		}
		if (codigoTecla == KeyEvent.VK_RIGHT || codigoTecla == KeyEvent.VK_D) {
			juego.setMoviendoDerecha(false);
		}
		if (codigoTecla == KeyEvent.VK_SPACE) {
			juego.setDisparando(false);
		}

	}


}
