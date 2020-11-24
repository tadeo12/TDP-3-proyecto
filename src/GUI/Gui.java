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

	private JPanel contentPane;
	private Juego juego;
	// private JLabel FONDO;

	/**
	 * Create the frame.
	 */
	public Gui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 932, 647);
		contentPane = new FondoPanel();
		contentPane.setBounds(100, 100, 932, 647);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);

		this.setFocusable(true);

		juego = Juego.getJuego();
		juego.setGUI(this);

//		for (int i = 0; i < 3; i++) {
//			new InfectadoAlpha();
//		}
//		for (int i = 0; i < 3; i++) {
//			new InfectadoBeta();
//		}

		this.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
			}

			public void keyPressed(KeyEvent e) {
				//System.out.println("je je");
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

		});

		JButton botonJugar = new JButton("jugar");
		botonJugar.setBounds(390, 11, 57, 23);
		botonJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Thread t = new Thread() {
					public void run() {
						juego.run();
					}
				};
				t.start();
				botonJugar.setVisible(false);
			}
		});

//		FONDO = new JLabel("");
//		FONDO.setBounds(-11, 0, 937, 622);
//		//contentPane.add(FONDO);
//		ImageIcon imagen = new ImageIcon(Gui.class.getResource("/RecursosGraficosNiveles/FONDO-LVL1.png"));
//		
//		this.reDimensionar(FONDO, imagen);

		// this.setContentPane(new FondoPanel());

		contentPane.add(botonJugar);

//		this.reDimensionar(FONDO, new ImageIcon(Gui.class.getResource("/RecursosGraficosNiveles/FONDO-LVL1.png")));

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

	}

	public Container getMapa() {
		return contentPane;
	}

	private Juego getJuego() {
		return juego;
	}

}

/**
 *
 */
class FondoPanel extends JPanel {
	private Image imagen;

	public void paint(Graphics g) {
		imagen = new ImageIcon(getClass().getResource("/RecursosGraficosNiveles/FONDO-LVL1.png")).getImage();
		g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
		setOpaque(false);
		super.paint(g);
	}

}
