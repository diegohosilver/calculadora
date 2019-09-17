package test.cache;

import org.junit.Test;

import main.negocio.Registro;

public class RegistroTest {

	@Test(expected = IllegalArgumentException.class)
	public void DescripcionVacioTest() {
		Registro registro = new Registro("", 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void DescripcionNullTest() {
		Registro registro = new Registro(null, 1);
	}
}
