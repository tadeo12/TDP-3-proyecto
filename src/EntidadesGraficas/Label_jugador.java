package EntidadesGraficas;

import javax.swing.ImageIcon;

public class Label_jugador extends Entidad_grafica {

	private String[] rutasImagen = { "/RecursosGraficos_Jugador/uy-kieto.png",
			"/RecursosGraficos_Jugador/uy-kieto inmunidad.png", "/RecursosGraficos_Jugador/uy-kieto superArma.png",
			"/RecursosGraficos_Jugador/uy-kieto velocidad.png" };

	public Label_jugador() {
		super();
		this.setSize(55, 80);
		ImageIcon imagen = new ImageIcon(getClass().getResource(rutasImagen[0]));
		this.setIcon(imagen);
		reDimensionar(this, imagen);
		this.setLocation(430, 520);
		this.setVisible(true);
	}

	public void setPowerUp(boolean[] mejoras) {
		boolean encontre = false;
		for (int i = 1; i < mejoras.length && !encontre; i++)
			if (mejoras[i]) {
				super.reDimensionar(this, new ImageIcon(Label_jugador.class.getResource(rutasImagen[i])));
				encontre=true;
			}
		if(!encontre)
			super.reDimensionar(this, new ImageIcon(getClass().getResource(rutasImagen[0])));
	}
}
