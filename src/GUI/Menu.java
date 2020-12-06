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


import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Menu extends JFrame {

	private JPanel contentPane;

	
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
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBorder(new LineBorder(Color.BLACK));
		btnNewButton_1.setBackground(new Color(0, 255, 0));
		btnNewButton_1.setIcon(new ImageIcon(Menu.class.getResource("/RecursosGraficos_Extras/normal.gif")));
		//btnNewButton_1.setOpaque(true);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
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
	
}
