package test.calculo;

import org.junit.Test;

import main.negocio.Calculo;

public class CalculoTest {

	@Test(expected = IllegalArgumentException.class)
	public void CalculoSinOperacionTest() {
		Calculo calculo = new Calculo(null);
	}
}
