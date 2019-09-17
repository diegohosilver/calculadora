package main.negocio;

public class Registro {
	
	private String _descripcion;
	private double _valor;
	
	private void validarParametros() {
		if (_descripcion == null || _descripcion.length() == 0) {
			throw new IllegalArgumentException("Descripcion no puede estar vacio");
		}
	}
	
	public Registro(String descripcion, double valor) {
		_descripcion = descripcion;
		_valor = valor;
		
		validarParametros();
	}
	
	public String obtenerDescripcion() {
		return _descripcion;
	}
	
	public double obtenerValor() {
		return _valor;
	}
}
