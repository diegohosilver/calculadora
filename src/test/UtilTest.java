package test;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Test;

import main.negocio.Util;

public class UtilTest {
	
	@Test
	public void ValidarGUID() {
		// Reagregamos los guiones solamente para que la validación de OK
		String guid = Util.ParsearGuid(Util.ObtenerGuid());

		UUID uuid = UUID.fromString(guid);
		
	    assertEquals(guid, uuid.toString());
	}
}
