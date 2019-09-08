package test;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Test;

import main.negocio.Util;

public class UtilTest {
	
	@Test
	public void ValidarGUID() {
		// Reagregamos los guiones solamente para que la validación de OK
		String guid = parsearGUID(Util.ObtenerGuid());

		UUID uuid = UUID.fromString(guid);
		
	    assertEquals(guid, uuid.toString());
	}
	
	private String parsearGUID(String guid) {
		return guid.replaceFirst( 
		        "(\\p{XDigit}{8})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}+)", "$1-$2-$3-$4-$5" 
			    );
	}

}
