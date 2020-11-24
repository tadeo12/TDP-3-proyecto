package Logica;

import java.util.LinkedList;
import java.util.List;

import Entidades.Infectado;

public class Nivel {
	
	private int valor; //num de nivel, para el fondo
	private int tandaActual;
	private Juego juego;
	
	private List<Tanda> tandas;
	
	public Nivel(int valor) {
		tandas= new LinkedList<Tanda>();
		tandaActual=0;
		this.valor=valor;
		juego=Juego.getJuego();
	}
	
	public void agregarTanda(Tanda t) {
		tandas.add(t);
	}
	
	public void eliminarInfectado(Infectado i) {
		Tanda tanda=tandas.get(tandaActual);
		tanda.eliminarInfectado(i);
		if(tanda.vacia()) {
			if(tandaActual+1<tandas.size()){
				tandaActual++;
				tandas.get(tandaActual).aparecer();
			}
			else
				juego.nivelCompleto();
		}
	}
}
