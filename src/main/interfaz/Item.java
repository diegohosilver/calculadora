package main.interfaz;

import main.negocio.Registro;

public class Item {
	private String _clave;
	private Registro _registro;

	public Item(String clave, Registro registro) {
		_clave = clave;
		_registro = registro;
	}

	@Override
	public String toString() {
		return _registro.obtenerDescripcion();
	}
}
