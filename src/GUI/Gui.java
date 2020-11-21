package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Gui extends JFrame {

	private JPanel contentPane;

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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//JLabel lblNewLabel = new JLabel("");
		//lblNewLabel.setIcon(new ImageIcon("C:\\Users\\laval\\Downloads\\Webp.net-gifmaker (22).gif"));
		//lblNewLabel.setBounds(370, 398, 51, 71);
		//contentPane.add(lblNewLabel);
		//this.reDimensionar(lblNewLabel,new ImageIcon(Gui.class.getResource("/Recursos_Graficos/Webp.net-gifmaker (22).gif")));
		
		JLabel INFECTADO = new JLabel("");
		INFECTADO.setIcon(new ImageIcon(Gui.class.getResource("/Recursos_Graficos/infectado_beta.gif")));
		INFECTADO.setBounds(325, 0, 137, 123);
		contentPane.add(INFECTADO);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Gui.class.getResource("/Recursos_Graficos/infectado_alfa.gif")));
		lblNewLabel_3.setBounds(682, 13, 198, 164);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Gui.class.getResource("/Recursos_Graficos/mov_right.gif")));
		lblNewLabel_2.setBounds(391, 490, 146, 110);
		contentPane.add(lblNewLabel_2);
		
		//contentPane.imageUpdate(, infoflags, x, y, w, h)
		JLabel FONDO = new JLabel("");
		//lblNewLabel.setIcon(new ImageIcon(Gui.class.getResource("/Recursos_Graficos/FONDO-LVL1.png")));
		//lblNewLabel.setIcon(new ImageIcon(getClass().getResource("Recusos_Graficos/FONDO-LVL1.png")));
		FONDO.setBounds(0, 0, 914, 600);
		contentPane.add(FONDO);
		this.reDimensionar(FONDO, new ImageIcon(Gui.class.getResource("/Recursos_Graficos/FONDO-LVL1.png")));
		
		
		
		contentPane.repaint();
		
		
		
		
	}

	/*private void reDim(JPanel jp, ImageIcon grafico) {
		Image im = grafico.getImage();
		if(im != null) {
			Image newing = im.getScaledInstance(jp.getWidth(), jp.getHeight(), java.awt.Image.SCALE_SMOOTH);
			jp.imageUpdate(im, infoflags, x, y, w, h)
		}
	}*/
	
	
	private void reDimensionar(JLabel label, ImageIcon grafico) {
		Image image = grafico.getImage();
		if( image != null) {
			Image newing = image.getScaledInstance(label.getWidth(), label.getHeight(),  java.awt.Image.SCALE_SMOOTH);
			grafico.setImage(newing);
			label.setIcon(grafico);
			label.repaint();
		}
	}
	
}
