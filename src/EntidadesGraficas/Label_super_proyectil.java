package EntidadesGraficas;

import java.util.Random;

import javax.swing.ImageIcon;

public class Label_super_proyectil extends Label_proyectil{
	
	public Label_super_proyectil() {
		super();
		this.setSize(50,100);;
		ImageIcon imagen =new ImageIcon(Label_super_proyectil.class.getResource("/RecursosGraficos_Jugador/disparo_boost.gif"));
		this.setIcon(imagen);
		reDimensionar(this,imagen);
		this.setLocation(400, 410);
		
	}

}
