package EntidadesGraficas;

import java.awt.Point;
import java.util.Random;

import javax.swing.ImageIcon;

public class Label_infectado_alpha extends Label_infectado {

	public Label_infectado_alpha(Point p) {
		super(p);
		ImageIcon imagen = new ImageIcon(
				Label_infectado_alpha.class.getResource("/RecursosGraficos_Infectados/infectado_alfa.gif"));//
		this.setIcon(imagen);
		reDimensionar(this, imagen);
	}

}
