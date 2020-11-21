package EntidadesGraficas;

import javax.swing.ImageIcon;

public class Label_particulaV_Beta extends Label_particulaV {

	public Label_particulaV_Beta() {
		super();

		ImageIcon imagen = new ImageIcon(
				Label_particulaV_Beta.class.getResource("/RecursosGraficos_Infectados/disparo2.gif"));
		this.setIcon(imagen);
		reDimensionar(this, imagen);
		this.setLocation(800, 200);

	}
}
