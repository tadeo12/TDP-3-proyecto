package EntidadesGraficas;

import javax.swing.ImageIcon;

public class Label_particulaV_Beta extends Label_particulaV {

	public Label_particulaV_Beta(Entidad_grafica entidad_infectado) {
		super();

		ImageIcon imagen = new ImageIcon(
				Label_particulaV_Beta.class.getResource("/RecursosGraficos_Infectados/disparo1.gif"));
		this.setIcon(imagen);
		reDimensionar(this, imagen);
		this.setLocation(entidad_infectado.getLocation());

	}
}
