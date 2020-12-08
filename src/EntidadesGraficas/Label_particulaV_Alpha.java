package EntidadesGraficas;

import java.awt.Point;

import javax.swing.ImageIcon;

public class Label_particulaV_Alpha extends Label_particulaV {

	public Label_particulaV_Alpha(Point p) {
		super(p);
		ImageIcon imagen = new ImageIcon(
				Label_particulaV_Beta.class.getResource("/RecursosGraficos_Infectados/disparo2.gif"));
		this.setIcon(imagen);
		reDimensionar(this, imagen);

	}
	
	
}
