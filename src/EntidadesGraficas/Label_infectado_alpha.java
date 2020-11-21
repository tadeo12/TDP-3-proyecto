package EntidadesGraficas;

import java.util.Random;

import javax.swing.ImageIcon;

public class Label_infectado_alpha extends Label_infectado {

	public Label_infectado_alpha() {
		super();
		ImageIcon imagen = new ImageIcon(
				Label_infectado_alpha.class.getResource("/RecursosGraficos_Infectados/infectado_alfa.gif"));//
		this.setIcon(imagen);
		reDimensionar(this, imagen);
		Random random = new Random();
		int valorx = random.nextInt(700);
		int valory = random.nextInt(200);
		this.setLocation(valorx, valory);
	}

}
