package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.negocio.Calculo;
import main.negocio.Operacion;

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
