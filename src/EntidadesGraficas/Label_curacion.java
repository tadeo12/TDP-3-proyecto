package EntidadesGraficas;

import java.awt.Point;

import javax.swing.ImageIcon;

public class Label_curacion extends Label_premio_precioso {

	public Label_curacion(Point p) {
		super();
		ImageIcon imagen = new ImageIcon(getClass().getResource("/RecursosGraficos_Premios/copito.png"));
		this.setIcon(imagen);
		reDimensionar(this, imagen);
		this.setLocation(p);
	}

}
