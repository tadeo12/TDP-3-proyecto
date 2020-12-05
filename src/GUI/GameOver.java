package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GameOver extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public GameOver() {
		
		this.setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 932, 647);
		contentPane = new JPanel();
		setAlwaysOnTop(true);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		

		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Gui gui = new Gui();
				gui.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setBorder(new LineBorder(Color.BLACK));
		btnNewButton.setIcon(new ImageIcon(GameOver.class.getResource("/RecursosGraficos_Extras/tryAgain.png")));
		btnNewButton.setBounds(415, 527, 208, 49);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBorder(new LineBorder(Color.BLACK));
		btnNewButton_1.setIcon(new ImageIcon(GameOver.class.getResource("/RecursosGraficos_Extras/salir.png")));
		btnNewButton_1.setBounds(669, 527, 184, 49);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(GameOver.class.getResource("/RecursosGraficos_Extras/GAME_OVER.gif")));
		lblNewLabel.setOpaque(false);
		lblNewLabel.setBounds(0, 0, 921, 643);
		contentPane.add(lblNewLabel);
		
	}
}
