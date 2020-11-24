package EntidadesGraficas;

import java.awt.Point;

public abstract class Label_infectado extends Entidad_grafica {

	public Label_infectado(Point p) {
		super();
		this.setSize(60, 100);
		this.setLocation(p);
	}
}
