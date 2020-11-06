public class Entidad
{
	...
	public EstrategiaMovimiento em;
	
	public void mover()
	{
		this.eMovimiento.mover();
	}
	
	...
}

public class Enemigo extends Entidad
{
	...
	private int velocidad;
	
	public void recibirDagno()
	{
		....
		if (vida < 100)
			this.EstrategiaMovimiento = new MovimientoVerticalReLoco();
		....
	}
	
	public EnemigoAlpha()
	{
			this.EstrategiaMovimiento = new MovimientoVertical(this, MovimientoVertical.ABAJO);
	}
}




////////////////////////////////////////////////////////////////////////////////////////////////////

public abstract class EstrategiaMovimiento
{
	private int d;
	private Entidad e;
	
	public EstrategiaMovimiento(Entidad e, int d)
	{
		this.e  = e
		this.d = d; ;
	}
	
	public int getDireccion()
	{
		return direccion;
	}
	
	public void setDireccion(int d)
	{
		this.direccion = d;
	}
	
	public abstract void mover();
}


public class MovimientoVertical extends EstrategiaMovimiento
{
	public static final int ABAJO = 1;
	public static final int ARRIBA = -1;
	
	public MovimientoVertical(E, int d)
	{
		super(e, d);
	}
	
	public void mover()
	{
		Grafico g = this.e.getGrafico();
		g.setPosition(g.getX(), g.getY() + direccion * e.getVelocidad());
	}
}

public class MovimientoVerticalReLoco extends MovimientoVertical
{
	...
	...
	public void mover()
	{
		Grafico g = this.e.getGrafico();
		g.setPosition(g.getX(), g.getY() + 2 * direccion * e.getVelocidad());
	}
}


////////////////////////////////////////////////////////////////////////////////////

public class MovimientoHorizontal extends EstrategiaMovimiento
{
	public static final int DERECHA = 1;
	public static final int IZQUIERDA = -1;
	
	public MovimientoVertical(E, int d)
	{
		super(e, d);
	}
	
	public void mover()
	{
		Grafico g = this.e.getGrafico();
		g.setPosition(g.getX() direccion * e.getVelocidad(), g.getY());
	}
}


//////////////////////////////////////////////////////////////////////////////////////////////////////

oyenteTeclaIzquierda()
{
	Jugador.getEstrategiaMovimiento.setDireccion(MovimientoHorizontal.IZQUIERDA);
	jugador.mover();
}












