package EntidadesGraficas;

import javax.swing.ImageIcon;

public class Label_jugador extends Entidad_grafica {
	
	private final int mejorasSinAfectarJugador=1;//bajoCero
	
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

	/**
	 * metodo utilizado para cambiar la imagen del jugador cuando posee alguna
	 * mejora.
	 * 
	 * @param mejoras Arreglo de booleans que representan las mejoras que recibió el
	 *                jugador. No se tiene en cuenta los primeros elementos del
	 *                arreglo ya que seran los que no afectan directamente al jugador
	 */
	public void setPowerUp(boolean[] mejoras) {
		boolean encontre = false;
		for (int i = this.mejorasSinAfectarJugador; i < mejoras.length && !encontre; i++)
			if (mejoras[i]) {
				super.reDimensionar(this, new ImageIcon(Label_jugador.class.getResource(rutasImagen[i])));
				encontre = true;
			}
		if (!encontre)
			super.reDimensionar(this, new ImageIcon(getClass().getResource(rutasImagen[0])));
	}
}
