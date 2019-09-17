package main.negocio;

import java.util.ArrayList;
import java.util.List;

public class Memoria {
	
	private static Memoria _instancia = null;
	private static int _limite = 3;
	private List<Double> _items;
	
	private Memoria() {
		_items = new ArrayList<Double>();
	}
	
	// Al superar el limite se remueve el primer elemento ingresado de la lista
	private void reacomodarItems() {
		_items.remove(0);
	}

	// Inicializar singleton
	public static Memoria obtenerInstancia() {
		if (_instancia == null) {
			_instancia = new Memoria();
		}
		
		return _instancia;
	}
	
	public void agregarNumero(double valor) {
		_items.add(valor);
		
		if (_items.size() > _limite) {
			reacomodarItems();
		}
	}
	
	public List<Double> listar() {
		return _items;
	}
	
	public void vaciar() {
		_items.clear();
	}

}
