package main.negocio;

public enum Operacion {
	SUMA {
		@Override
		public Aritmetica obtenerOperacionAritmetica() {
			return new Suma();
		}
	},
	RESTA {
		@Override
		public Aritmetica obtenerOperacionAritmetica() {
			return new Resta();
		}
	},
	PRODUCTO{
		@Override
		public Aritmetica obtenerOperacionAritmetica() {
			return new Producto();
		}
	},
	DIVISION{
		@Override
		public Aritmetica obtenerOperacionAritmetica() {
			return new Division();
		}
	};
	
	public abstract Aritmetica obtenerOperacionAritmetica();
}
