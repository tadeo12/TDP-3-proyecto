package GUI;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Audio.AudioPlayer;
import Entidades.InfectadoAlpha;
import Entidades.InfectadoBeta;
import Logica.Juego;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;



public class Gui extends JFrame {

	private FondoPanel panelJuego;
	private Juego juego;
	private Thread hiloJuego;
	private JLabel cargaViral, cargaViralMaxima, nivelTanda;
	private JLabel[] estados;
	private JButton btnNewButton;
	private int audioActual;
	private String[] audioNiveles;
	private Thread audio;
	private AudioPlayer ap;
	
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
		
		audioNiveles = new String[] {"/RercursosMP3/NivelesAudio/Nivel1.mp3","/RercursosMP3/NivelesAudio/Nivel2.mp3","/RercursosMP3/NivelesAudio/Nivel3.mp3"};
		
		
		JPanel barraSuperior= new JPanel();
		barraSuperior.setBounds(0, 0, 933, 60);
		contentPane.add(barraSuperior);
		barraSuperior.setLayout(null);
		barraSuperior.setBackground(Color.BLACK);
		
		JPanel panelMejoras= new JPanel();
		
		panelMejoras.setBounds(615, 0, 258, 60);
		panelMejoras.setBackground(Color.BLACK);
		panelMejoras.setLayout(new GridLayout(1,4));
		panelMejoras.setVisible(true);
		estados= new JLabel[4];
		for(int i=0;i< 4 ;i++) {
			estados[i]= new JLabel();
			estados[i].setSize( 50 , 50 ); //308/4,60);
			panelMejoras.add(estados[i]);
			//estados[i].setEnabled(false);
			
		}
		estados[0].setIcon(new ImageIcon(getClass().getResource("/RecursosGraficos_Premios/bajoCero.png")));
		estados[1].setIcon(new ImageIcon(getClass().getResource("/RecursosGraficos_Premios/inmunidad.png")));
		estados[2].setIcon(new ImageIcon(getClass().getResource("/RecursosGraficos_Jugador/disparo_boost.gif")));
		estados[3].setIcon(new ImageIcon(getClass().getResource("/RecursosGraficos_Premios/velocidad.png")));
		for(int i=0;i< 4 ;i++) {
			reDimensionar(estados[i],(ImageIcon) estados[i].getIcon());
		}
		
		barraSuperior.add(panelMejoras);
		
		
		cargaViral = new JLabel();
		cargaViral.setBackground(new Color(51, 91, 17));
		cargaViral.setBounds(10, 11, 0, 38);
		cargaViral.setOpaque(true);
		cargaViral.setBorder(new LineBorder(Color.BLACK,2));
		barraSuperior.add(cargaViral);
		
		cargaViralMaxima = new JLabel();
		cargaViralMaxima.setBackground(new Color(242, 78,133));
		cargaViralMaxima.setBounds(10, 11, 500, 38);
		cargaViralMaxima.setOpaque(true);
		cargaViralMaxima.setBorder(new LineBorder(Color.BLACK,2));
		barraSuperior.add(cargaViralMaxima);
		
		nivelTanda = new JLabel("");
		nivelTanda.setIcon( new ImageIcon(getClass().getResource("/RecursosGraficos_Extras/NivelTanda/nivel1tanda1.png")));	
		
		nivelTanda.setBounds(520, 0, 95, 60) ;
		barraSuperior.add(nivelTanda);
		
		audioOn();
		btnNewButton = new JButton("");
		barraSuperior.add(btnNewButton);
		btnNewButton.setBounds(871, 0, 50, 50);
		btnNewButton.setOpaque(false);
		btnNewButton.setFocusable(false);
		btnNewButton.setIcon(new ImageIcon(Gui.class.getResource("/RecursosGraficos_Extras/sonido_on.png")));
		btnNewButton.setBorder(new LineBorder(Color.BLACK));
		btnNewButton.setSelected(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				setAudio(evt);
			}
		});
		
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
			Image newimg = image.getScaledInstance(label.getWidth(), label.getHeight(),  java.awt.Image.SCALE_SMOOTH);
			grafico.setImage(newimg);
			label.repaint();
		}
	}
	
	public void gano() {
		System.out.println("gano");
		this.juego = null;
	}
	
	public void perdio() {
		
		System.out.println("PERDIO");

		this.juego = null;
		
		hiloJuego = null;
		this.juego = null;
		this.panelJuego = null;
		audioOff();
		audio = null;
		ap = null;
		this.dispose();
		GameOver go = new GameOver();
		
		go.setVisible(true);
		
		if(this.btnNewButton.isSelected())
			audioOff();
		
		
		//panelJuego.gameOver();
	}

	public Container getMapa() {
		return panelJuego;
	}

	private Juego getJuego() {
		return juego;
	}
	

	public void cambioNivel(int nivel) {
		/*System.out.println("ni");
		this.audioActual = nivel - 1 ;
		
		if(this.btnNewButton.isSelected()) {
			if(audioActual > 0 ) {
				audioOff();
				audioOn();
			}else audioOn();
		}*/
		panelJuego.setFondoNivel(nivel-1);
		panelJuego.pantallaNivel(nivel-1);
		juego.pausa();
		panelJuego.setFondoNivel(nivel-1);
		panelJuego.repaint();
		
	}

	public void actualizarBarraViral(int infeccion) {
		cargaViral.setSize((cargaViralMaxima.getWidth()/100)*infeccion,cargaViral.getHeight());
		
	}

	public void actualizarNivelTanda(int nivel, int tanda) {
		ImageIcon im = new ImageIcon(getClass().getResource("/RecursosGraficos_Extras/NivelTanda/nivel"+nivel+"tanda"+tanda+".png"));
		this.nivelTanda.setIcon(im);
	}
	public void actualizarBarraEstados(int estadoActualJugador, int estadoArma) {
		
	}
	
	public void setAudio(ActionEvent evt) {
		
		ImageIcon im1 = new ImageIcon(Menu.class.getResource("/RecursosGraficos_Extras/sonido_off.png"));
		ImageIcon im2 = new ImageIcon(Menu.class.getResource("/RecursosGraficos_Extras/sonido_on.png"));
		ImageIcon im = null;
		//
		
		if(!btnNewButton.isSelected()) {
			this.audioOff();
			im = im1;
			btnNewButton.setSelected(true);
		}else {
			im = im2;
			btnNewButton.setSelected(false);
			audioOn();
		}
		//
		Image image = im.getImage();
		if (image != null) {
			Image newing = image.getScaledInstance(btnNewButton.getWidth(), btnNewButton.getHeight(), java.awt.Image.SCALE_SMOOTH);
			im.setImage(newing);
			btnNewButton.setIcon(im);
			btnNewButton.repaint();
		}
		
	}
	
	private void audioOn() {
		ap = new AudioPlayer("/RercursosMP3/NivelesAudio/Nivel1.mp3");
		audio = new Thread(ap);
		audio.start();
	}

	private void audioOff() {
		audio.stop();
		audio = null;
		ap = null;
	}
}
