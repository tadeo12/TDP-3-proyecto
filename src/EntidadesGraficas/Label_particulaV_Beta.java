package EntidadesGraficas;

import java.awt.Point;

import javax.swing.ImageIcon;

public class Label_particulaV_Beta extends Label_particulaV {

	public Label_particulaV_Beta(Point p) {
		super(p);
		ImageIcon imagen = new ImageIcon(
				Label_particulaV_Beta.class.getResource("/RecursosGraficos_Infectados/disparo1.gif"));
		this.setIcon(imagen);
		reDimensionar(this, imagen);
		this.setLocation(p);
	}
}
