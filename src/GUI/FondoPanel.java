package GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Component;
//import java.awt.BorderLayout;

class FondoPanel extends JLayeredPane  {


	private String[] nivelesTransicion = new String[] { "/RecursosGraficosNiveles/LVL01.png",
			"/RecursosGraficosNiveles/LVL02.png", "/RecursosGraficosNiveles/LVL03.png" };
	private JLabel nivelTransicionLabel;

	public FondoPanel() {

		setLayout(null);
		nivelTransicionLabel = new JLabel();
		this.add(nivelTransicionLabel);
		this.repaint();
		
	}

	@Override
	public Component add(Component p) {
		Component comp = super.add(p);
		this.moveToFront(p);
		return comp;
	}

	/**
	 * Actualiza el panel y sus componentes
	 * @param nivelActual 
	 */
	public void CambioDeLvl() {
		this.nivelTransicionLabel.setVisible(false);
		this.repaint();
	}

	/**
	 * actualiza el mapa al correspondiente nivel actual
	 * @param nivel Nivel actual
	 */
	public void pantallaNivel(int nivel) {// 1, 2, .... , n		
		this.nivelTransicionLabel.setIcon(new ImageIcon(getClass().getResource(this.nivelesTransicion[nivel])));
		this.nivelTransicionLabel.setVisible(true);
		this.nivelTransicionLabel.repaint();
		this.nivelTransicionLabel.setBounds(this.getX(), (this.getY() + this.getHeight() - 165) / 2, this.getWidth(),
				165);
	}

}