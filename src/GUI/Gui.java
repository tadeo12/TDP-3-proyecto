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
		barraSuperior.setBackground(new Color(139, 208, 169));
		
		JPanel panelMejoras= new JPanel();
		
		panelMejoras.setBounds(615, 0, 308, 60);
		panelMejoras.setBackground(new Color(139, 208, 169));
		panelMejoras.setLayout(new GridLayout(1,4));
		panelMejoras.setVisible(true);
		estados= new JLabel[4];
		for(int i=0;i< 4 ;i++) {
			estados[i]= new JLabel();
			estados[i].setSize(308/4,60);
			panelMejoras.add(estados[i]);
			//estados[i].setEnabled(false);
			
		}
		estados[0].setIcon(new ImageIcon(getClass().getResource("/RecursosGraficos_Premios/bajoCero.png")));
		estados[1].setIcon(new ImageIcon(getClass().getResource("/RecursosGraficos_Premios/inmunidad.gif")));
		estados[2].setIcon(new ImageIcon(getClass().getResource("/RecursosGraficos_Jugador/disparo_boost.gif")));
		estados[3].setIcon(new ImageIcon(getClass().getResource("/RecursosGraficos_Premios/velocidad.png")));
		for(int i=0;i< 4 ;i++) {
			redimensionar(estados[i],(ImageIcon) estados[i].getIcon());
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
		
		nivelTanda = new JLabel("<html><body> Nivel: 0 <br> Tanda: 0 </body></html>");
		nivelTanda.setFont(new Font("Source Serif Pro ExtraLight", Font.PLAIN, 20));
		nivelTanda.setBounds(520, 0, 139, 60);
		barraSuperior.add(nivelTanda);
		
		
		
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

	public void redimensionar(JLabel label, ImageIcon grafico) {
		if (grafico.getImage() != null) {
			grafico.setImage(
					grafico.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));

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
		this.nivelTanda.setText("<html><body> Nivel: "+nivel+"<br> Tanda: "+tanda+"</body></html>");
	}
	
	public void actualizarBarraEstados(int estadoActualJugador, int estadoArma) {
		
	}
}
