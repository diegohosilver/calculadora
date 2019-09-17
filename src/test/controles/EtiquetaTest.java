package test.controles;

import static org.junit.Assert.assertEquals;

import javax.swing.JLabel;

import org.junit.Test;

import main.interfaz.controles.*;

public class EtiquetaTest {

	@Test(expected = IllegalArgumentException.class)
	public void GenerarEtiquetaTextoVacioTest() {
		Control.generarEtiqueta("", new Dimensiones(10, 10, 20, 30));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void GenerarEtiquetaTextoNullTest() {
		Control.generarEtiqueta(null, new Dimensiones(10, 10, 20, 30));
	}
	
	@Test
	public void GenerarEtiquetaTest() {
		JLabel etiqueta = Control.generarEtiqueta("Texto", new Dimensiones(10, 10, 20, 30));
		
		assertEquals("Texto", etiqueta.getText());
		assertEquals(10, etiqueta.getX());
		assertEquals(10, etiqueta.getY());
		assertEquals(20, etiqueta.getWidth());
		assertEquals(30, etiqueta.getHeight());
	}
}
