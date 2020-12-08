package EntidadesGraficas;

import java.awt.Point;
import java.util.Random;

import javax.swing.ImageIcon;

<<<<<<< HEAD
public class Label_super_proyectil extends Label_proyectil_sanitario{
	
=======
public class Label_super_proyectil extends Label_proyectil_sanitario {

>>>>>>> f6d678e5614141ef496e3b0681f27469a389b3f9
	public Label_super_proyectil(Point p) {
		super(p);
		this.setSize(50, 100);
		;
		ImageIcon imagen = new ImageIcon(
				Label_super_proyectil.class.getResource("/RecursosGraficos_Jugador/disparo_boost.gif"));
		this.setIcon(imagen);
		reDimensionar(this, imagen);
		this.setLocation((int) p.getX(), (int) p.getY() - 30);
	}

}
