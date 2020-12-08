package EntidadesGraficas;

import java.awt.Point;

import javax.swing.ImageIcon;

public class Label_inmunidad extends Label_premio_temporal {

	public Label_inmunidad(Point p) {
		super(p);
		ImageIcon imagen = new ImageIcon(getClass().getResource("/RecursosGraficos_Premios/inmunidad.png"));
		this.setIcon(imagen);
		reDimensionar(this, imagen);
	}

}
