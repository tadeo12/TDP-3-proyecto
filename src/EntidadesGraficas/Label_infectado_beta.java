package EntidadesGraficas;

import java.awt.Point;
import javax.swing.ImageIcon;

public class Label_infectado_beta extends Label_infectado {

	public Label_infectado_beta(Point p) {
		super(p);
		ImageIcon imagen = new ImageIcon(
				Label_infectado_beta.class.getResource("/RecursosGraficos_Infectados/infectado_beta.gif"));
		this.setIcon(imagen);
		reDimensionar(this, imagen);
	}
}
