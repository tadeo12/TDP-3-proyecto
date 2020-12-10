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

		setIconImage(new ImageIcon(getClass().getResource("/RecursosGraficos_Extras/icon.png")).getImage());

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 932, 647);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JButton botonNormal = new JButton("");
		botonNormal.setBorder(new LineBorder(Color.BLACK));
		botonNormal.setBackground(new Color(0, 255, 0));
		botonNormal.setIcon(new ImageIcon(Menu.class.getResource("/RecursosGraficos_Extras/normal.gif")));
		// botonNormal.setOpaque(true);
		botonNormal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Gui frame = new Gui(0);
				frame.setVisible(true);
				// frame.setResizable(false);
				dispose();
			}
		});
		botonNormal.setBounds(45, 301, 397, 93);
		contentPane.add(botonNormal);

		JButton botonHardcore = new JButton("");
		botonHardcore.setBorder(new LineBorder(Color.BLACK));
		botonHardcore.setForeground(new Color(0, 0, 0));
		botonHardcore.setBackground(new Color(0, 255, 0));//
		botonHardcore.setIcon(new ImageIcon(Menu.class.getResource("/RecursosGraficos_Extras/hardcore.gif")));
		botonHardcore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Gui frame = new Gui(1);
				frame.setVisible(true);
				frame.setResizable(false);
				dispose();
			}
		});
		botonHardcore.setBounds(45, 407, 397, 93);
		contentPane.add(botonHardcore);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Menu.class.getResource("/RecursosGraficos_Extras/FONDO MENU.png")));
		lblNewLabel.setBounds(12, 0, 932, 647);
		contentPane.add(lblNewLabel);

	}

}
