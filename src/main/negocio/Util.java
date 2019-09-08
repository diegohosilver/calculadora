package main.negocio;

import java.util.UUID;

public class Util {

	public static String ObtenerGuid() {
		UUID uuid = UUID.randomUUID();
		
		return uuid.toString().replace("-", "");
	}
	
}
