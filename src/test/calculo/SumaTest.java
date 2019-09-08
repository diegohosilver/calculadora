package test.calculo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.negocio.calculo.Calculo;
import main.negocio.calculo.Operacion;

public class SumaTest {
	private Calculo calculo;
	
	@Before
	public void configurarTest() {
		this.calculo = new Calculo(Operacion.SUMA);
	}
	
	@Test
	public void SumaEnterosTest() {
		double resultado = this.calculo.calcular(2, 2);
		
		assertTrue(resultado == 4);
	}
	
	@Test
	public void SumaDecimalesTest() {
		double resultado = this.calculo.calcular(1.5, 1.5);
		
		assertTrue(resultado == 3);
	}
	
	@Test
	public void SumaNegativosTest() {
		double resultado = this.calculo.calcular(-5, -5);
		
		assertTrue(resultado == -10);
	}
}
