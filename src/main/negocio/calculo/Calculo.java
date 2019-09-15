package main.negocio.calculo;

public class Calculo implements Aritmetica {
	
	private Operacion operacionActual;
	private Aritmetica aritmetica;
	
	public Calculo(Operacion operacionDefecto) {
		if (operacionDefecto == null) {
			throw new IllegalArgumentException("Operacion no puede estar vacío");
		}
		
		cambiarOperador(operacionDefecto);
	}

	public void cambiarOperador(Operacion operacion) {
		this.operacionActual = operacion;
		this.aritmetica = operacionActual.obtenerOperacionAritmetica();
	}
	
	public Operacion obtenerOperadorActual() {
		return this.operacionActual;
	}
	
	@Override
	public double calcular(double primerTermino, double segundoTermino) {
		return this.aritmetica.calcular(primerTermino, segundoTermino);
	}
	
}