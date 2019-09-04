package test.calculo;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import main.negocio.Calculo;
import main.negocio.Operacion;
import main.negocio.Calculo;

public class DivisionTest {
	private Calculo calculo;

	@Before
	public void configurarTest() {
		this.calculo = new Calculo(Operacion.DIVISION);
	}
	
	@Test
	public void DivisionEnteros() {
		double resultado = this.calculo.calcular(4.0, 2.0);
		assertTrue(resultado == 2.0);
	}
	@Test
	public void DivisionNegativo() {
		double resultado = this.calculo.calcular(-4.0, 2.0);
		assertTrue(resultado == -2.0);
	}
	
	@SuppressWarnings("null")
	@Test(expected = NullPointerException.class)
	public void whenExceptionThrown_thenExpectationSatisfied() {
	    String test = null;
	    test.length();
	}
	
}
