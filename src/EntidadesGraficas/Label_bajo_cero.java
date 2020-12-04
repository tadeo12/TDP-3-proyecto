package EntidadesGraficas;

import java.awt.Point;

import javax.swing.ImageIcon;

public class Label_bajo_cero extends Label_premio_temporal {

	public Label_bajo_cero(Point p) {
		super();
		ImageIcon imagen = new ImageIcon(getClass().getResource("/RecursosGraficos_Premios/bajoCero.png"));
		this.setIcon(imagen);
		reDimensionar(this, imagen);
		this.setLocation(p);

	}

}
