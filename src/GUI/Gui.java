package GUI;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Entidades.Entidad;
import Entidades.InfectadoAlpha;
import EntidadesGraficas.Entidad_grafica;
import EntidadesGraficas.Label_infectado;
import EntidadesGraficas.Label_infectado_alpha;
import EntidadesGraficas.Label_infectado_beta;
import EntidadesGraficas.Label_jugador;
import EntidadesGraficas.Label_particulaV_Alpha;
import EntidadesGraficas.Label_particulaV_Beta;
import EntidadesGraficas.Label_proyectil;
import EntidadesGraficas.Label_proyectil_normal;
import EntidadesGraficas.Label_super_proyectil;
import Logica.Juego;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Gui extends JFrame {

	private JPanel contentPane;
	private Juego juego;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui frame = new Gui();
					frame.setVisible(true);
					frame.setResizable(false);
					// frame.getJuego().Jugar();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Gui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 932, 647);
		contentPane = new JPanel();
		contentPane.setBounds(100, 100, 932, 647);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		juego = Juego.getJuego(); //<--CLARAMENTE HAY ALGO MAL QUE NO ANDA BIEN
		juego.setGUI(this);

		// JLabel lblNewLabel = new JLabel("");
		// lblNewLabel.setIcon(new
		// ImageIcon("C:\\Users\\laval\\Downloads\\Webp.net-gifmaker (22).gif"));
		// lblNewLabel.setBounds(370, 398, 51, 71);
		// contentPane.add(lblNewLabel);
		// this.reDimensionar(lblNewLabel,new
		// ImageIcon(Gui.class.getResource("/Recursos_Graficos/Webp.net-gifmaker
		// (22).gif")));

//		JLabel INFECTADO = new JLabel("");
//		INFECTADO.setIcon(new ImageIcon(Gui.class.getResource("/RecursosGraficos_Infectados/infectado_beta.gif")));
//		INFECTADO.setBounds(325, 0, 137, 123);
//		contentPane.add(INFECTADO);
//
//		JLabel lblNewLabel_3 = new JLabel("");
//		lblNewLabel_3.setIcon(new ImageIcon(Gui.class.getResource("/RecursosGraficos_Infectados/infectado_alfa.gif")));
//		lblNewLabel_3.setBounds(682, 13, 198, 164);
//		contentPane.add(lblNewLabel_3);
//		
//		JLabel lblNewLabel_2 = new JLabel("");
//		lblNewLabel_2.setIcon(new ImageIcon(Gui.class.getResource("/RecursosGraficos_Jugador/mov_right.gif")));
//		lblNewLabel_2.setBounds(391, 490, 146, 110);
//		contentPane.add(lblNewLabel_2);
//		

		
		for (int i = 0; i < 9; i++) {
			Entidad infectado = new InfectadoAlpha();			
			JLabel probando = infectado.getGrafico();
			contentPane.add(probando);
			infectado.accionar();

		}

		for (int i = 0; i < 9; i++) {
			JLabel probando = new Label_infectado_beta();
			contentPane.add(probando);
		}
		
		JButton botonJugar = new JButton("jugar");
		botonJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread() {
					public void run() {
						juego.Jugar();
					}
				};	
			}
		});
		botonJugar.setBounds(0, 0, 89, 23);
		contentPane.add(botonJugar);

		JLabel jugador_prueba = new Label_jugador();
		contentPane.add(jugador_prueba);

		JLabel disparo2_prueba = new Label_particulaV_Beta();
		contentPane.add(disparo2_prueba);

		JLabel disparo1_prueba = new Label_particulaV_Alpha();
		contentPane.add(disparo1_prueba);

//		JLabel disparo_boost_prueba = new Label_super_proyectil();
//		contentPane.add(disparo_boost_prueba);

		JLabel disparo_prueba = new Label_proyectil_normal();
		contentPane.add(disparo_prueba);
		
		
		
		JLabel FONDO = new JLabel("");
		FONDO.setBounds(0, 0, 914, 600);
		contentPane.add(FONDO);
		this.reDimensionar(FONDO, new ImageIcon(Gui.class.getResource("/RecursosGraficosNiveles/FONDO-LVL1.png")));

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

	}

	public Container getMapa() {
		return contentPane;
	}

	private Juego getJuego() {
		return juego;
	}
}
