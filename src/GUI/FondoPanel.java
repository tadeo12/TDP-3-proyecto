package GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;

class FondoPanel extends JPanel {

	private Image imagen;
	private String [] nivelesTransicion = new String[]{ "/RecursosGraficosNiveles/LVL01.png" , "/RecursosGraficosNiveles/LVL02.png", "/RecursosGraficosNiveles/LVL03.png" };
	private String [] fondoNiveles = new String[] {"/RecursosGraficosNiveles/FONDO-LVL01.png ","/RecursosGraficosNiveles/FONDO-LVL02.png","/RecursosGraficosNiveles/FONDO-LVL03.png"};
	private JLabel nivelTransicionLabel;
	
	public FondoPanel() {
		
		setLayout(null);
		nivelTransicionLabel = new JLabel();
		
	}
	
	public void paint(Graphics g) {
		
		imagen = new ImageIcon(getClass().getResource("/RecursosGraficosNiveles/FONDO-LVL01.png")).getImage();
		g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
		setOpaque(false);
		super.paint(g);
	}
	
	public void setFondoNivel(int nivelActual) {
		
		imagen = new ImageIcon( getClass().getResource( this.fondoNiveles[ nivelActual - 1 ] )).getImage();
		this.nivelTransicionLabel.setVisible(false);
		this.repaint();
		
	}
	
	public void pantallaNivel(int nivel) {// 1, 2, ...., n
		
		imagen = null;
		this.setBackground(Color.BLACK);
		this.nivelTransicionLabel.setIcon(new ImageIcon(getClass().getResource( this.nivelesTransicion[ nivel - 1 ] )));
		this.nivelTransicionLabel.setVisible(true);
		this.repaint();
		this.setBounds(100,100,932,165);
		
	}
}