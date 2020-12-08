package GUI;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Entidades.InfectadoAlpha;
import Entidades.InfectadoBeta;
import Logica.Juego;

import javax.swing.JLabel;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class Gui extends JFrame {

	private FondoPanel panelJuego;
	private Juego juego;
	private Thread hiloJuego;
	private JLabel cargaViral, cargaViralMaxima, nivelTanda;
	private JLabel[] estados;
	private JLabel fondoJuego;
	
	public Gui(int dificultad) {
		
		this.setResizable(false);
		
		setIconImage(new ImageIcon(getClass().getResource("/RecursosGraficos_Extras/icon.png")).getImage());

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 949, 700);
		JPanel contentPane = new JPanel();
		contentPane.setLayout(null);
		
		panelJuego = new FondoPanel();
		panelJuego.setBounds(0, 60, 933, 601);
		panelJuego.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelJuego.setLayout(null);
		contentPane.add(panelJuego);
		
		fondoJuego = new JLabel("New label");
		fondoJuego.setIcon(new ImageIcon(Gui.class.getResource("/RecursosGraficosNiveles/FONDO-LVL01.png")));
		fondoJuego.setBounds(0, 0, 933,601);
		reDimensionar(fondoJuego, (ImageIcon) fondoJuego.getIcon());
		panelJuego.add(fondoJuego);
		panelJuego.moveToBack(fondoJuego);
		
		panelJuego.repaint();
		JPanel barraSuperior = new JPanel();
		barraSuperior.setBounds(0, 0, 933, 60);
		contentPane.add(barraSuperior);
		barraSuperior.setLayout(null);
		barraSuperior.setBackground(Color.BLACK);

		JPanel panelMejoras = new JPanel();

		panelMejoras.setBounds(615, 0, 258, 60);
		panelMejoras.setBackground(Color.BLACK);
		panelMejoras.setLayout(new GridLayout(1, 4));
		panelMejoras.setVisible(true);
		estados = new JLabel[4];
		for (int i = 0; i < 4; i++) {
			estados[i] = new JLabel();
			estados[i].setSize(50, 50); 
			panelMejoras.add(estados[i]);
			estados[i].setEnabled(false);

		}
		estados[0].setIcon(new ImageIcon(getClass().getResource("/RecursosGraficos_Premios/bajoCero.png")));
		estados[1].setIcon(new ImageIcon(getClass().getResource("/RecursosGraficos_Premios/inmunidad.png")));
		estados[2].setIcon(new ImageIcon(getClass().getResource("/RecursosGraficos_Premios/superArma.png")));
		estados[3].setIcon(new ImageIcon(getClass().getResource("/RecursosGraficos_Premios/velocidad.png")));
		for (int i = 0; i < 4; i++) {
			reDimensionar(estados[i], (ImageIcon) estados[i].getIcon());
		}

		barraSuperior.add(panelMejoras);

		cargaViral = new JLabel();
		cargaViral.setBackground(new Color(51, 91, 17));
		cargaViral.setBounds(10, 11, 0, 38);
		cargaViral.setOpaque(true);
		cargaViral.setBorder(new LineBorder(Color.BLACK, 2));
		barraSuperior.add(cargaViral);

		cargaViralMaxima = new JLabel();
		cargaViralMaxima.setBackground(new Color(242, 78, 133));
		cargaViralMaxima.setBounds(10, 11, 500, 38);
		cargaViralMaxima.setOpaque(true);
		cargaViralMaxima.setBorder(new LineBorder(Color.BLACK, 2));
		barraSuperior.add(cargaViralMaxima);

		nivelTanda = new JLabel("");
		nivelTanda.setIcon(new ImageIcon(getClass().getResource("/RecursosGraficos_Extras/NivelTanda/nivel1tanda1.png")));

		nivelTanda.setBounds(520, 0, 95, 60);
		barraSuperior.add(nivelTanda);

		this.setFocusable(true);

		setContentPane(contentPane);
		setLocationRelativeTo(null);

		juego = Juego.getJuego();
		juego.setGUI(this);
		juego.setDificultad(dificultad);

		this.addKeyListener(new OyenteTeclado(juego));

		hiloJuego = new Thread() {
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
			Image newimg = image.getScaledInstance(label.getWidth(), label.getHeight(), java.awt.Image.SCALE_SMOOTH);
			grafico.setImage(newimg);
			label.setIcon(grafico);
			label.repaint();
		}
	}

	public void gano() {
		
		GameOver_Win win = new GameOver_Win(1);
		hiloJuego = null;
		this.panelJuego = null;
		this.dispose();
		this.juego = null;
		win.setVisible(true);
		
	}

	public void perdio() {
		this.juego = null;
		hiloJuego = null;
		this.panelJuego = null;
		this.dispose();
		GameOver_Win go = new GameOver_Win(0);
		go.setVisible(true);
		
	}

	public Container getMapa() {
		return panelJuego;
	}

	public void cambioNivel(int nivel) {
		
		this.reDimensionar(fondoJuego, new ImageIcon(Gui.class.getResource("/RecursosGraficosNiveles/FONDO-LVL0"+nivel+".png")));
		panelJuego.moveToBack(fondoJuego);
		panelJuego.setFondoNivel(nivel - 1);
		panelJuego.pantallaNivel(nivel - 1);
		juego.pausa();
		panelJuego.setFondoNivel(nivel - 1);
		panelJuego.repaint();

	}

	public void actualizarBarraViral(int infeccion) {
		cargaViral.setSize((cargaViralMaxima.getWidth() / 100) * infeccion, cargaViral.getHeight());
		this.repaint();

	}

	public void actualizarNivelTanda(int nivel, int tanda) {
		ImageIcon im = new ImageIcon(
				getClass().getResource("/RecursosGraficos_Extras/NivelTanda/nivel" + nivel + "tanda" + tanda + ".png"));
		this.nivelTanda.setIcon(im);
	}

	public void actualizarPowerUps(List<Boolean> mejoras) {
		for (int i = 0; i < estados.length; i++) {
			estados[i].setEnabled(mejoras.get(i));
		}
	}

	public void sonidoDisparar() {
		try {
			
			Clip disparo = AudioSystem.getClip();
			disparo.open(AudioSystem
					.getAudioInputStream(getClass().getResource("/RercursosWAV/disparo_normal.wav")));
			disparo.start();

		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
			e.printStackTrace();
			e.getMessage();
			System.out.println("error audio");
		}
	}
}
