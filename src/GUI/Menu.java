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


public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SplashScreen splash = new SplashScreen(3000);
					splash.showSplash();
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 932, 647);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setBorder(new LineBorder(new Color(102, 255, 102)));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//
				ImageIcon im1 = new ImageIcon(Menu.class.getResource("/RecursosGraficos_Extras/sonido_off.png"));
				ImageIcon im2 = new ImageIcon(Menu.class.getResource("/RecursosGraficos_Extras/sonido_on.png"));
				ImageIcon im = null;
				//

				if(btnNewButton_2.isSelected()) {
					im = im2;
					btnNewButton_2.setSelected(false);
				}else {
					im = im1;
					btnNewButton_2.setSelected(true);
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
		});
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.setBackground(Color.BLACK);
		btnNewButton_2.setBounds(38, 483, 82, 69);
		this.reDimensionar(btnNewButton_2, new ImageIcon(Menu.class.getResource("/RecursosGraficos_Extras/sonido_on.png")));
		contentPane.add(btnNewButton_2);
		 */
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBorder(new LineBorder(new Color(102, 255, 102)));
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.setIcon(new ImageIcon(Menu.class.getResource("/RecursosGraficos_Extras/BOTON JUGAR normal.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Gui frame = new Gui();
				frame.setVisible(true);
				frame.setResizable(false);
				dispose();
			}
		});
		btnNewButton_1.setBounds(45, 207, 397, 124);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBorder(new LineBorder(new Color(102, 255, 102)));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(Color.BLACK);//
		btnNewButton.setIcon(new ImageIcon(Menu.class.getResource("/RecursosGraficos_Extras/BOTON JUGAR JARCOR.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Gui frame = new Gui();
				frame.setVisible(true);
				frame.setResizable(false);
				dispose();
			}
		});
		btnNewButton.setBounds(45, 347, 397, 124);
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
