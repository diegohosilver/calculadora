package main.negocio;

import java.util.HashMap;
import java.util.Map;

public class Cache<T> {

	private static Cache _instancia = null;
	
	public Map<String, T> items;
	
	private Cache() {
		items = new HashMap<String, T>();
	}
	
	public static Cache obtenerInstancia() {
		if (_instancia == null) {
			_instancia = new Cache();
		}
		
		return _instancia;
	}
}
