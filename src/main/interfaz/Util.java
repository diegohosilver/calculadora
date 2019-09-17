package main.interfaz;

import java.util.ArrayList;

public class Util {

	private static Boolean ultimoInputEsOperador(String operacion) {
		ArrayList<String> operadores = new ArrayList<String>() {
			{
				add("+");
				add("-");
				add("/");
				add("*");
			}
		};
		
		if (operacion.trim().length() <= 3) return false;
		
		// Como el operador siempre esta rodeado por espacios, los tenemos en cuenta
		String ultimoDigito = operacion.substring(operacion.length() - 3);
		
		return operadores.contains(ultimoDigito.trim());
	}
	
	private static boolean esEntero(double n)
	{
	    return (n == Math.floor(n)) && !Double.isInfinite(n);
	}
	
	public static String reemplazarOperador(String operacion, String operador) {
		if (operacion == null || operacion.length() == 0) {
			return "";
		}
		
		if (!ultimoInputEsOperador(operacion)) {
			return operacion + operador;
		}
		
		String operacionSinUltimoOperador = operacion.substring(0, operacion.length() - 3);
		
		return operacionSinUltimoOperador + operador;
	}
	
	public static double ParsearADouble(String n) {
		double numero;
		
		try {
			numero = Double.parseDouble(n);
		}
		catch(NumberFormatException e) {
			numero = 0;
		}
		
		return numero;
	}
	
	public static String ParsearNumeroComoTexto(double n) {
		String numeroComoTexto = Double.toString(n);
		
		if (esEntero(n)) {
			return numeroComoTexto.substring(0, numeroComoTexto.length() - 2);
		}
		
		return numeroComoTexto;
	}
}
