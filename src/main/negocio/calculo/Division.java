package main.negocio.calculo;

public class Division implements Aritmetica {
	
	@Override
	public double calcular(double primerTermino, double segundoTermino) {
		if(segundoTermino == 0) {
			throw new IllegalArgumentException("No se puede dividir por cero");
		}
		
		return primerTermino/segundoTermino;
	}
}
