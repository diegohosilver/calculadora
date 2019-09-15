package main.negocio;

import java.util.UUID;

public class Util {

	public static String ObtenerGuid() {
		UUID uuid = UUID.randomUUID();
		
		return uuid.toString().replace("-", "");
	}
	
	public static String ParsearGuid(String guid) {		
		if (!guid.contains("-")) {
			guid = guid.replaceFirst("(\\p{XDigit}{8})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}+)", "$1-$2-$3-$4-$5");
		}
		
		return guid;
	}
}
