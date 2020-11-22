package EntidadesGraficas;

import javax.swing.ImageIcon;

public class Label_proyectil_normal extends Label_proyectil_sanitario{

	public Label_proyectil_normal() {
		super();
		ImageIcon imagen =new ImageIcon(Label_super_proyectil.class.getResource("/RecursosGraficos_Jugador/disparo.gif"));
		this.setIcon(imagen);
		reDimensionar(this,imagen);
		this.setLocation(400, 410);
	}
}
