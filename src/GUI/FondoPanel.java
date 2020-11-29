package GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
//import java.awt.BorderLayout;

class FondoPanel extends JPanel {

	private Image imagen;
	private String [] nivelesTransicion = new String[]{ "/RecursosGraficosNiveles/LVL01.png" , "/RecursosGraficosNiveles/LVL02.png", "/RecursosGraficosNiveles/LVL03.png" };
	private String [] fondoNiveles = new String[] {"/RecursosGraficosNiveles/FONDO-LVL01.png ","/RecursosGraficosNiveles/FONDO-LVL02.png","/RecursosGraficosNiveles/FONDO-LVL03.png"};
	private JLabel nivelTransicionLabel;
	private JPanel labelGameOver;
	private int nivelActual;
	
	public FondoPanel() {
		
		nivelActual = 0;
		setLayout(null);
		
		labelGameOver= new JPanel();
		labelGameOver.setBorder(new LineBorder(new Color(0, 0, 0)));
		labelGameOver.setBackground(Color.PINK);
		labelGameOver.setBounds(0, 185, 450, -73);
		this.add(labelGameOver);
		
		nivelTransicionLabel = new JLabel();
		this.add(nivelTransicionLabel);
		
	}
	
	public void paint(Graphics g) {
		imagen = new ImageIcon(getClass().getResource(this.fondoNiveles[nivelActual])).getImage();
		g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
		setOpaque(false);
		super.paint(g);
		
	}
	
	public void setFondoNivel(int nivelActual) {
		imagen = new ImageIcon( getClass().getResource( this.fondoNiveles[ nivelActual ] )).getImage();
		this.nivelActual = nivelActual;
		this.nivelTransicionLabel.setVisible(false);
		this.repaint();
		
	}
	
	public void pantallaNivel(int nivel) {// 1, 2, .... , n
		imagen = null;
		this.nivelTransicionLabel.setIcon(new ImageIcon(getClass().getResource( this.nivelesTransicion[ nivel ] )));
		this.nivelTransicionLabel.setVisible(true);
		this.nivelTransicionLabel.repaint();
		this.nivelTransicionLabel.setBounds( this.getX(), ( this.getY() + ( this.getHeight() - 165 ) / 2  ) , 932 , 165);
	}

	public void gameOver() {
		
		
	}
	
}