package test.calculo;

import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

import main.negocio.Calculo;
import main.negocio.Operacion;

public class RestaTest {
	private Calculo calculo;
	
	@Before
	public void configurarTest() {
		this.calculo = new Calculo(Operacion.RESTA);
	}
	
	@Test
	public void RestaEnterosTest() {
		double resultado = this.calculo.calcular(2, 2);
		
		assertTrue(resultado == 0);
	}
	
	@Test
	public void RestaDecimalesTest() {
		double resultado = this.calculo.calcular(3, 1.5);
		
		assertTrue(resultado == 1.5);
	}
	
	@Test
	public void RestaNegativosTest() {
		double resultado = this.calculo.calcular(-10, -5);
		
		assertTrue(resultado == -5);
	}
}
