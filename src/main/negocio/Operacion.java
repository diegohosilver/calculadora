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
	};
	
	public abstract Aritmetica obtenerOperacionAritmetica();
}
