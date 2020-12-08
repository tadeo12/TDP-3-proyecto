package EntidadesGraficas;

import java.awt.Point;

import javax.swing.ImageIcon;

public class Label_super_arma extends Label_premio_temporal
{

	public Label_super_arma(Point p) {
		super(p);
		ImageIcon imagen = new ImageIcon(getClass().getResource("/RecursosGraficos_Premios/superArma.png"));
		this.setIcon(imagen);
		reDimensionar(this, imagen);
	}
}
