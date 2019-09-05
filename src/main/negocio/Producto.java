package main.negocio;

public class Producto implements Aritmetica {

	@Override
	public double calcular(double primerTermino, double segundoTermino) {
		return primerTermino * segundoTermino;
	}

}
