package GUI;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Entidades.InfectadoAlpha;
import Entidades.InfectadoBeta;
import Logica.Juego;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Gui extends JFrame {

	private FondoPanel panelJuego;
	private Juego juego;
	private Thread hiloJuego;
	private JLabel cargaViral;
	//private JLabel FONDO;

	/**
	 * Create the frame.
	 */
	public Gui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 949, 700);
		JPanel contentPane=new JPanel();
		contentPane.setLayout(null);
		
		panelJuego = new FondoPanel();
		panelJuego.setBounds(0, 60, 933, 601);
		panelJuego.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelJuego.setLayout(null);
		contentPane.add(panelJuego);

		
		
		JPanel barraSuperior= new JPanel();
		barraSuperior.setBounds(0, 0, 933, 60);
		contentPane.add(barraSuperior);
		barraSuperior.setLayout(null);
		
		cargaViral = new JLabel();
		cargaViral.setBackground(new Color(51, 91, 17));
		cargaViral.setBounds(10, 11, 0, 38);
		cargaViral.setOpaque(true);
		cargaViral.setBorder(new LineBorder(Color.BLACK,2));
		barraSuperior.add(cargaViral);
		
		JLabel cargaViralMaxima = new JLabel();
		cargaViralMaxima.setBackground(new Color(242, 78,133));
		cargaViralMaxima.setBounds(10, 11, 500, 38);
		cargaViralMaxima.setOpaque(true);
		cargaViralMaxima.setBorder(new LineBorder(Color.BLACK,2));
		barraSuperior.add(cargaViralMaxima);
		
		
		
		this.setFocusable(true);
		
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		juego = Juego.getJuego();
		juego.setGUI(this);

		this.addKeyListener(new OyenteTeclado(juego)); 
		
		hiloJuego= new Thread() {
			public void run() {				
				juego.run();
			}
		};	
		
		hiloJuego.start();
		

		this.repaint();
		panelJuego.repaint();
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
		panelJuego.gameOver();
		//hiloJuego.interrupt();
	}

	public Container getMapa() {
		return panelJuego;
	}

	private Juego getJuego() {
		return juego;
	}
	

	public void cambioNivel(int nivel) {
		panelJuego.setFondoNivel(nivel);
		panelJuego.pantallaNivel(nivel);
		juego.pausa();
		panelJuego.setFondoNivel(nivel);
		panelJuego.repaint();
	}

	public void actualizarBarraViral(int infeccion) {
		cargaViral.setSize(infeccion*5,cargaViral.getHeight());
		
	}	
}
