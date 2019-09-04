package main.negocio;

import javax.management.RuntimeErrorException;

public class Division implements Aritmetica{
	@Override
	public double calcular(double primerTermino, double segundoTermino) {
		if(segundoTermino<1) {
			throw new RuntimeErrorException(null, "No se puede dividir por cero");
		}
		return primerTermino/segundoTermino;
	}
}
