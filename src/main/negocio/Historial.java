package main.negocio;

import java.util.LinkedHashMap;
import java.util.Map;

public class Historial {

	private static Historial _instancia = null;
	private Map<String, Operacion> _items;
	
	private Historial() {
		_items = new LinkedHashMap<String, Operacion>();
	}
	
	public static Historial obtenerInstancia() {
		if (_instancia == null) {
			_instancia = new Historial();
		}
		
		return _instancia;
	}
	
	public void agregar(String descripcion, double valor) {
		_items.put(Util.ObtenerGuid(), new Operacion(descripcion, valor));
	}
	
	public Map<String, Operacion> listar() {
		return _items;
	}
}
