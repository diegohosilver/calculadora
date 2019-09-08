package test.cache;

import org.junit.Test;

import main.negocio.Operacion;

public class OperacionTest {

	@Test(expected = IllegalArgumentException.class)
	public void DescripcionVacioTest() {
		Operacion operacion = new Operacion("", 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void DescripcionNullTest() {
		Operacion operacion = new Operacion(null, 1);
	}
}
