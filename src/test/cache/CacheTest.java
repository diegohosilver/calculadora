package test.cache;

import static org.junit.Assert.*;

import org.junit.Test;

import main.negocio.Cache;

public class CacheTest {

	@Test
	public void AgregarValorTest() {
		Cache cache = Cache.obtenerInstancia();
		
		cache.items.put("clave-1", 1);
		cache.items.put("clave-2", "valor-string");
		
		assertTrue(cache.items.size() == 2);
	}

}
