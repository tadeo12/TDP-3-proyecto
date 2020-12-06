package GUI;


import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

import Audio.AudioPlayer;

public class Menu extends JFrame {

	private JPanel contentPane;
	private AudioPlayer ap;
	private Thread audio;
	private JButton botonAudio;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		SplashScreen splash = new SplashScreen(2000);
		splash.showSplash();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					Menu frame = new Menu();
					
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
					e.getMessage();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		
		ap = new AudioPlayer("/RercursosMP3/menu_musica.mp3");
		audio = new Thread(ap);
		audio.start();
		
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 932, 647);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		
		botonAudio = new JButton("");
		botonAudio.setBorder(new LineBorder(Color.BLACK));
		botonAudio.setSelected(false);
		botonAudio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				setAudio(evt);
			}
		});
		
		
		botonAudio.setForeground(Color.BLACK);
		botonAudio.setBackground(Color.BLACK);
		botonAudio.setBounds(12, 539, 50, 50);
		this.reDimensionar(botonAudio, new ImageIcon(Menu.class.getResource("/RecursosGraficos_Extras/sonido_on.png")));
		contentPane.add(botonAudio);
		
		JButton botonJugarNormal = new JButton("");
		botonJugarNormal.setBorder(new LineBorder(Color.BLACK));
		botonJugarNormal.setBackground(new Color(0, 255, 0));
		botonJugarNormal.setIcon(new ImageIcon(Menu.class.getResource("/RecursosGraficos_Extras/normal.gif")));
		//botonJugarNormal.setOpaque(true);
		botonJugarNormal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				audioOff();
				Gui frame = new Gui();
				frame.setVisible(true);
				frame.setResizable(false);
				dispose();
			}
		});
		botonJugarNormal.setBounds(45, 301, 397, 93);
		contentPane.add(botonJugarNormal);
		
		JButton botonJugarHardcore = new JButton("");
		botonJugarHardcore.setBorder(new LineBorder(Color.BLACK));
		botonJugarHardcore.setForeground(new Color(0, 0, 0));
		botonJugarHardcore.setBackground(new Color(0, 255, 0));//
		botonJugarHardcore.setIcon(new ImageIcon(Menu.class.getResource("/RecursosGraficos_Extras/hardcore.gif")));
		botonJugarHardcore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				audioOff();
				audio = null;
				ap = null;
				Gui frame = new Gui();
				frame.setVisible(true);
				frame.setResizable(false);
				dispose();
			}
		});
		botonJugarHardcore.setBounds(45, 407, 397, 93);
		contentPane.add(botonJugarHardcore);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Menu.class.getResource("/RecursosGraficos_Extras/FONDO MENU.png")));
		lblNewLabel.setBounds(12, 0, 932, 647);
		contentPane.add(lblNewLabel);
		
		
	}

	private void reDimensionar(JButton jb, ImageIcon grafico) {
		Image image = grafico.getImage();
		if (image != null) {
			Image newing = image.getScaledInstance(jb.getWidth(), jb.getHeight(), java.awt.Image.SCALE_SMOOTH);
			grafico.setImage(newing);
			jb.setIcon(grafico);
			jb.repaint();
		}
	}
	
	public void setAudio(ActionEvent evt) {
		
		ImageIcon im1 = new ImageIcon(Menu.class.getResource("/RecursosGraficos_Extras/sonido_off.png"));
		ImageIcon im2 = new ImageIcon(Menu.class.getResource("/RecursosGraficos_Extras/sonido_on.png"));
		ImageIcon im = null;
		//
		

		if(botonAudio.isSelected()) {
			this.audioOff();
			im = im1;
			botonAudio.setSelected(false);
		}else {
			im = im2;
			botonAudio.setSelected(true);
			audioOn();

		}
		//
		Image image = im.getImage();
		if (image != null) {
			Image newing = image.getScaledInstance(botonAudio.getWidth(), botonAudio.getHeight(), java.awt.Image.SCALE_SMOOTH);
			im.setImage(newing);
			botonAudio.setIcon(im);
			botonAudio.repaint();
		}
		
	}
	
	private void audioOn() {
		audio.start();
	}

	private void audioOff() {
		audio.interrupt();
		
	}
	
}
