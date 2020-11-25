package GUI;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

class FondoPanel extends JPanel {
	private Image imagen;

	public void paint(Graphics g) {
		imagen = new ImageIcon(getClass().getResource("/RecursosGraficosNiveles/FONDO-LVL1.png")).getImage();
		g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
		setOpaque(false);
		super.paint(g);
	}

}