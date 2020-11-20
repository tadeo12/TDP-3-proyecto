package Logica;

import java.util.LinkedList;
import java.util.List;

import Entidades.Infectado;

public class Tanda {
	private List<Infectado> infectados;
	
	public Tanda() {
		infectados=new LinkedList<Infectado>();
	}
	
	public boolean vacia() {
		return infectados.isEmpty();
	}
	
	public void agregarInfectado(Infectado inf) {
		infectados.add(inf);
	}
	
	public void eliminarInfectado(Infectado inf) {
		infectados.remove(inf);
	}
}
