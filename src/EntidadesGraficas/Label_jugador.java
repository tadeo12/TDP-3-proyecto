package EntidadesGraficas;

import javax.swing.ImageIcon;

public class Label_jugador extends Entidad_grafica {

	public Label_jugador() {
		super();
		this.setSize(50, 100);
		ImageIcon imagen = new ImageIcon(getClass().getResource("/RecursosGraficos_Jugador/uy-kieto.png"));
		this.setIcon(imagen);
		reDimensionar(this, imagen);
		this.setLocation(400, 500);
		this.setVisible(true);

	}

}
