package main.negocio;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

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
	
	public void agregar(String clave, Operacion operacion) {
		_items.put(clave, operacion);
	}
	
	public Map<String, Operacion> listar() {
		return _items;
	}
	
	public Operacion obtener(String clave) {
		Optional<Operacion> operacion = _items.entrySet().stream()
			.filter(x -> x.getKey().equals(clave))
			.map(Map.Entry::getValue)
			.findFirst();
		
		if (!operacion.isPresent()) {
			throw new NoSuchElementException("No existe ninguna operacion con la clave dada");
		}
			
		return operacion.get();
	}
	
	public void restaurar(String clave) {
		for(Operacion operacion: _items.values()) {
			if(!operacion.descripcion().equals(clave)) {
//				deberia buscar la manera de identificar a los
//				elementos posteriores de la clave dada
//				_items.remove(operacion);
			}
		}
	}
	
	public void vaciar() {
		_items.clear();
	}
}