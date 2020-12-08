package EntidadesGraficas;

import java.awt.Point;

import javax.swing.ImageIcon;

import Entidades.Jugador;

public class Label_proyectil_normal extends Label_proyectil_sanitario {

	public Label_proyectil_normal(Point p) {
		super(p);
		ImageIcon imagen = new ImageIcon(
				Label_proyectil_normal.class.getResource("/RecursosGraficos_Jugador/disparo.gif"));
		this.setIcon(imagen);
		reDimensionar(this, imagen);
	}
}
