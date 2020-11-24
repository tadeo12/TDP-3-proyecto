package EntidadesGraficas;

import javax.swing.ImageIcon;

public class Label_particulaV_Alpha extends Label_particulaV {

	public Label_particulaV_Alpha(Entidad_grafica entidad_infectado) {
		super();
		ImageIcon imagen = new ImageIcon(
				Label_particulaV_Beta.class.getResource("/RecursosGraficos_Infectados/disparo2.gif"));
		this.setIcon(imagen);
		reDimensionar(this, imagen);
		this.setLocation(entidad_infectado.getLocation());

	}
	
	
}
