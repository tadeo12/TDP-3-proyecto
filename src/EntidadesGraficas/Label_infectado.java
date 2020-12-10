package EntidadesGraficas;

import java.awt.Point;
import java.util.Random;

import javax.swing.ImageIcon;

public abstract class Label_infectado extends Entidad_grafica {

	private String movLeft[] = new String[] { "/RecursosGraficos_Infectados/seVaLeft 1.gif",
			"/RecursosGraficos_Infectados/seVaLeft 2.gif", "/RecursosGraficos_Infectados/seVaLeft 3.gif",
			"/RecursosGraficos_Infectados/seVaLeft 4.gif", "/RecursosGraficos_Infectados/seVaLeft 5.gif",
			"/RecursosGraficos_Infectados/seVaLeft 6.gif", "/RecursosGraficos_Infectados/seVaLeft 7.gif" };
	private String movRight[] = new String[] { "/RecursosGraficos_Infectados/seVaRight 1.gif",
			"/RecursosGraficos_Infectados/seVaRight 2.gif", "/RecursosGraficos_Infectados/seVaRight 3.gif",
			"/RecursosGraficos_Infectados/seVaRight 4.gif", "/RecursosGraficos_Infectados/seVaRight 5.gif",
			"/RecursosGraficos_Infectados/seVaRight 6.gif", "/RecursosGraficos_Infectados/seVaRight 7.gif" };

	public Label_infectado(Point p) {
		super();
		this.setSize(60, 100);
		this.setLocation(p);
	}

	public void seVa(int lado) {
		ImageIcon imagen = null;
		Random rand = new Random();
		int i = rand.nextInt(7);

		if (lado == 1) {// se va para la der
			imagen = new ImageIcon(this.getClass().getResource(this.movRight[i]));
		} else {// se va para la izq
			imagen = new ImageIcon(this.getClass().getResource(this.movLeft[i]));
		}

		this.setIcon(imagen);
		this.setBounds(getX(), getY(), 100, 75);
		this.repaint();

	}

}
