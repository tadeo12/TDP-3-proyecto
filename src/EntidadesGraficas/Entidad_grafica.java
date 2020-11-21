package EntidadesGraficas;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.sun.javafx.iio.gif.GIFImageLoader2;

public abstract class Entidad_grafica extends JLabel {
	
	public Entidad_grafica() {
		super();
	}

	public void reDimensionar(JLabel label, ImageIcon grafico) {
		if (grafico.getImage() != null) {			
			grafico.setImage(grafico.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
//			GIFImageLoader2 newing = image.getScaledInstance(label.getWidth(), label.getHeight(), java.awt.GifImage.SCALE_SMOOTH);
//			grafico.setImage(newing);
//			label.setIcon(grafico);
//			label.repaint();
		}
	}
}
