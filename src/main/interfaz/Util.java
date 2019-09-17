package main.interfaz;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Util {

	// Valida si dentro de la operacion quedo una operacion sin cerrar (por ejemplo '4 +')
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
	
	// Valida si los numeros luego de la , son 0
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
	
	// Validar si la tecla presionada es alguna del NUMPAD
	public static boolean esTeclaValida(KeyEvent e) {
		return e.getKeyLocation() == KeyEvent.KEY_LOCATION_NUMPAD;
	}
	
	// Devolver el valor en formato string de la tecla presionada
	public static String obtenerTextoAPartirDeCodigo(int codigo) {
		switch(codigo) {
			case KeyEvent.VK_NUMPAD0:
				return "0";
			case KeyEvent.VK_NUMPAD1:
				return "1";
			case KeyEvent.VK_NUMPAD2:
				return "2";
			case KeyEvent.VK_NUMPAD3:
				return "3";
			case KeyEvent.VK_NUMPAD4:
				return "4";
			case KeyEvent.VK_NUMPAD5:
				return "5";
			case KeyEvent.VK_NUMPAD6:
				return "6";
			case KeyEvent.VK_NUMPAD7:
				return "7";
			case KeyEvent.VK_NUMPAD8:
				return "8";
			case KeyEvent.VK_NUMPAD9:
				return "9";
			case KeyEvent.VK_DECIMAL:
				return ".";
			default:
				return "";
		}
	}
}
