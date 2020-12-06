package GUI;

import java.awt.BorderLayout;
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
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import javazoom.jl.player.Player;
public class Menu extends JFrame {

	private JPanel contentPane;
	private AudioPlayer ap;
	private Thread audio;
	JButton btnNewButton_2;//BOTON AUDIO
	
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

		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 932, 647);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		audioOn();
		
		btnNewButton_2 = new JButton("");
		btnNewButton_2.setBorder(new LineBorder(Color.BLACK));
		btnNewButton_2.setSelected(true);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				setAudio(evt);
			}
		});
		
		
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.setBackground(Color.BLACK);
		btnNewButton_2.setBounds(12, 539, 50, 50);
		this.reDimensionar(btnNewButton_2, new ImageIcon(Menu.class.getResource("/RecursosGraficos_Extras/sonido_on.png")));
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBorder(new LineBorder(Color.BLACK));
		btnNewButton_1.setBackground(new Color(0, 255, 0));
		btnNewButton_1.setIcon(new ImageIcon(Menu.class.getResource("/RecursosGraficos_Extras/normal.gif")));
		//btnNewButton_1.setOpaque(true);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				audioOff();
				Gui frame = new Gui();
				frame.setVisible(true);
				frame.setResizable(false);
				dispose();
			}
		});
		btnNewButton_1.setBounds(45, 301, 397, 93);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBorder(new LineBorder(Color.BLACK));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(0, 255, 0));//
		btnNewButton.setIcon(new ImageIcon(Menu.class.getResource("/RecursosGraficos_Extras/hardcore.gif")));
		btnNewButton.addActionListener(new ActionListener() {
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
		btnNewButton.setBounds(45, 407, 397, 93);
		contentPane.add(btnNewButton);
		
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
		
		if(!btnNewButton_2.isSelected()) {
			this.audioOff();
			im = im1;
			btnNewButton_2.setSelected(true);
		}else {
			im = im2;
			btnNewButton_2.setSelected(false);
			audioOn();
		}
		//
		Image image = im.getImage();
		if (image != null) {
			Image newing = image.getScaledInstance(btnNewButton_2.getWidth(), btnNewButton_2.getHeight(), java.awt.Image.SCALE_SMOOTH);
			im.setImage(newing);
			btnNewButton_2.setIcon(im);
			btnNewButton_2.repaint();
		}
		
	}
	
	private void audioOn() {
		ap = new AudioPlayer("/RercursosMP3/NivelesAudio/Nivel1.mp3");
		audio = new Thread(ap);
		audio.start();
	}

	private void audioOff() {
		audio.interrupt();
		audio = null;
		ap = null;
	}
	
}
