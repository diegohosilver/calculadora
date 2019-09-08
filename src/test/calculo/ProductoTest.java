package test.calculo;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import main.negocio.calculo.Calculo;
import main.negocio.calculo.Operacion;

public class ProductoTest {
	private Calculo calculo;
	
	@Before
	public void configurarTest() {
		this.calculo = new Calculo(Operacion.PRODUCTO);
	}
	
	@Test
	public void ProductoDecimalesTest() {
		double resultado = this.calculo.calcular(2.0, 2.0);
		assertTrue(resultado == 4.0);
	}
	
	@Test
	public void ProductoEnterosTest() {
		double resultado = this.calculo.calcular(5, 5);
		assertTrue(resultado == 25);
	}
	
	@Test
	public void ProductoPositivoTest(){
		double resultado = this.calculo.calcular(-3, -40);
		assertTrue(resultado == 120);
	}
	
	@Test
	public void ProductoPrimerTerminoNegativoTest() {
		double resultado = this.calculo.calcular(-4, 6);
		assertTrue(resultado == -24);
	}
	
	@Test
	public void ProductoSegundoTerminoNegativo() {
		double resultado = this.calculo.calcular(4, -8);
		assertTrue(resultado == -32);
	}
	
	@Test
	public void ProductoCero(){
		double resultado = this.calculo.calcular(0, 100);
		assertTrue(resultado == 0);
	}
}
