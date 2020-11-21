package EntidadesGraficas;

import java.util.Random;

import javax.swing.ImageIcon;

public class Label_infectado_beta extends Label_infectado{

	public Label_infectado_beta() {
	
		super();
		ImageIcon imagen =new ImageIcon(Label_infectado_alpha.class.getResource("/RecursosGraficos_Infectados/infectado_beta.gif"));
		this.setIcon(imagen);
		reDimensionar(this,imagen);
		Random random = new Random();
		int valorx = random.nextInt(600);
		int valory = random.nextInt(200);
		this.setLocation(valorx, valory);
	}
	
}
