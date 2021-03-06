package GUI;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import Logica.Juego;

import javax.swing.JLabel;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Gui extends JFrame {

	private FondoPanel panelJuego;
	private Juego juego;
	private Thread hiloJuego;
	private JLabel cargaViral, cargaViralMaxima, nivelTanda;
	private JLabel[] estados;
	private JLabel fondoJuego;
	
	/**
	 * Crea el mapa de juego
	 * @param dificultad de juego 
	 * -> 0 si es normal
	 * -> 1 si es dificil
	 */
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
	
	/**
	 * Redimensiona el ImageIcon grafico en base al JLabel label
	 * @param label
	 * @param grafico
	 */
	private void reDimensionar(JLabel label, ImageIcon grafico) {
		Image image = grafico.getImage();
		if (image != null) {
			Image newimg = image.getScaledInstance(label.getWidth(), label.getHeight(), java.awt.Image.SCALE_SMOOTH);
			grafico.setImage(newimg);
			label.setIcon(grafico);
			label.repaint();
		}
	}

	/**
	 * Se crea abre un nuevo frame donde se muestra que se gano el juego
	 */
	public void gano() {
		
		GameOver_Win win = new GameOver_Win(1);
		hiloJuego = null;
		this.panelJuego = null;
		this.dispose();
		this.juego = null;
		win.setVisible(true);
		
	}

	/**
	 * Se crea abre un nuevo frame donde se muestra que se perdio el juego
	 */
	public void perdio() {
		this.juego = null;
		hiloJuego = null;
		this.panelJuego = null;
		this.dispose();
		GameOver_Win go = new GameOver_Win(0);
		go.setVisible(true);
		
	}

	/**
	 * retorna el mapa donde se muestra el juego 
	 * @return mapa de tipo Container
	 */
	public Container getMapa() {
		return panelJuego;
	}

	/**
	 * Muestra en el panel de juego la transicion del nivel. Esta transicion muestra el nivel actual
	 * A su vez que cambia el mapa al correspondiente del nivel actual
	 * @param nivel Nivel actual
	 */
	public void cambioNivel(int nivel) {
		this.reDimensionar(fondoJuego, new ImageIcon(Gui.class.getResource("/RecursosGraficosNiveles/FONDO-LVL0"+nivel+".png")));
		panelJuego.moveToBack(fondoJuego);
		panelJuego.pantallaNivel(nivel - 1);
		juego.pausa();
		panelJuego.CambioDeLvl();
		panelJuego.repaint();
	}

	/**
	 * Actualiza la barra de estados de los premios 
	 * @param infeccion
	 */
	public void actualizarBarraViral(int infeccion) {
		cargaViral.setSize((cargaViralMaxima.getWidth() / 100) * infeccion, cargaViral.getHeight());
		this.repaint();
	}

	/**
	 * actualiza el label que muestra la tanda y nivel actuales
	 * @param nivel
	 * @param tanda
	 */
	public void actualizarNivelTanda(int nivel, int tanda) {
		ImageIcon im = new ImageIcon(
				getClass().getResource("/RecursosGraficos_Extras/NivelTanda/nivel" + nivel + "tanda" + tanda + ".png"));
		this.nivelTanda.setIcon(im);
	}

	/**
	 * actualiza la barra que muestra los estados de los premios.
	 * Si un premio esta activo entonces se mostrar� con su label activo
	 * en caso contrario se mostrara con su label desactivado
	 * @param mejoras estado de cada premios
	 */
	public void actualizarPowerUps(boolean[] mejoras) {
		for (int i = 0; i < estados.length; i++) {
			estados[i].setEnabled(mejoras[i]);
		}
	}

	/**
	 * Activa el sonido de disparo
	 */
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
