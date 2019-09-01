package main.negocio;

public class Resta implements Aritmetica {
	
	@Override
	public double calcular(double primerTermino, double segundoTermino) {
		return primerTermino - segundoTermino;
	}

}
