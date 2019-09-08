package test.calculo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import main.negocio.calculo.Calculo;
import main.negocio.calculo.Operacion;

public class CalculoTest {

	@Test(expected = IllegalArgumentException.class)
	public void CalculoSinOperacionTest() {
		Calculo calculo = new Calculo(null);
	}
	
	@Test
	public void ObtenerOperadorTest() {
		Calculo calculo = new Calculo(Operacion.SUMA);
		
		assertTrue(calculo.obtenerOperadorActual() == Operacion.SUMA);
	}
	
	@Test
	public void CambiarOperadorTest() {
		Calculo calculo = new Calculo(Operacion.SUMA);
		
		calculo.cambiarOperador(Operacion.RESTA);
		
		assertTrue(calculo.obtenerOperadorActual() == Operacion.RESTA);
	}
}
