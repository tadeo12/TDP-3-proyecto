package EntidadesGraficas;

import java.awt.Point;

import javax.swing.ImageIcon;

public class Label_super_arma extends Label_premio_temporal{

	public Label_super_arma(Point p) {
		super();
		ImageIcon imagen = new ImageIcon(getClass().getResource("/RecursosGraficos_Premios/premio.gif"));
		this.setIcon(imagen);
		reDimensionar(this, imagen);
		this.setLocation(p);
		
	}
}
