package EntidadesGraficas;

import java.awt.Point;

import javax.swing.ImageIcon;

public class Label_super_velocidad extends Label_premio_temporal {

	public Label_super_velocidad(Point p) {
		super();
		ImageIcon imagen = new ImageIcon(getClass().getResource("/RecursosGraficos_Premios/rayito.png"));
		this.setIcon(imagen);
		reDimensionar(this, imagen);
		this.setLocation(p);
		
	}
}