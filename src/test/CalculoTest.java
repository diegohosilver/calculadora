package test;

import main.Calculo;
import main.Operacion;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculoTest {
	
	private Calculo calculo;
	
	@Test(expected = IllegalArgumentException.class)
	public void CalculoSinOperacionTest() {
		this.calculo = new Calculo(null);
	}
	
	@Test
	public void SumaTest() {
		this.calculo = new Calculo(Operacion.SUMA);
		
		double resultado = this.calculo.calcular(2, 2);
		
		assertTrue(resultado == 4);
	}

}
