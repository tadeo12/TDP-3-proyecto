package EntidadesGraficas;

import javax.swing.ImageIcon;

public class Label_jugador extends Entidad_grafica {

	public Label_jugador() {
		super();
		this.setSize(55, 80);
		ImageIcon imagen = new ImageIcon(getClass().getResource("/RecursosGraficos_Jugador/uy-kieto.png"));
		this.setIcon(imagen);
		reDimensionar(this, imagen);
		this.setLocation(430, 520);
		this.setVisible(true);

	}
	
	public void setPowerUpVelocidad() {
		super.reDimensionar(this, new ImageIcon(getClass().getResource("/RecursosGraficos_Jugador/uy-kieto velocidad.png")));
	}
	
	public void setPowerUpSuperArma() {
		super.reDimensionar(this, new ImageIcon(getClass().getResource("/RecursosGraficos_Jugador/uy-kieto superArma.png")));
	}
	
	public void setSinPowerUp() {
		super.reDimensionar(this, new ImageIcon(getClass().getResource("/RecursosGraficos_Jugador/uy-kieto.png")));
	}

	public void setPowerUpInmunidad() {
		super.reDimensionar(this, new ImageIcon(getClass().getResource("/RecursosGraficos_Jugador/uy-kieto inmunidad.png")));
	}
}
