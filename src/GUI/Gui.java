package GUI;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Entidades.InfectadoAlpha;
import Entidades.InfectadoBeta;
import Logica.Juego;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Gui extends JFrame {

	private FondoPanel contentPane;
	private Juego juego;
	//private JLabel FONDO;

	/**
	 * Create the frame.
	 */
	public Gui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 949, 647);
		contentPane = new FondoPanel();
		contentPane.setBounds(100, 100, 950, 647);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);

		this.setFocusable(true);

		juego = Juego.getJuego();
		juego.setGUI(this);

		this.addKeyListener(new OyenteTeclado(juego)); 
		
		Thread t = new Thread() {
			public void run() {				
				juego.run();
			}
		};	
		
		t.start();
		

		this.repaint();
		contentPane.repaint();
	}

	private void reDimensionar(JLabel label, ImageIcon grafico) {
		Image image = grafico.getImage();
		if (image != null) {
			Image newing = image.getScaledInstance(label.getWidth(), label.getHeight(), java.awt.Image.SCALE_SMOOTH);
			grafico.setImage(newing);
			label.setIcon(grafico);
			label.repaint();
		}
	}

	public void gano() {
		System.out.println("gano");
	}
	
	public void perdio() {
		contentPane.gameOver();
	}

	public Container getMapa() {
		return contentPane;
	}

	private Juego getJuego() {
		return juego;
	}

	public void cambioNivel(int nivel) {
		contentPane.setFondoNivel(nivel);
		contentPane.pantallaNivel(nivel);
		juego.pausa();
		contentPane.setFondoNivel(nivel);
		contentPane.repaint();
	}	
}
