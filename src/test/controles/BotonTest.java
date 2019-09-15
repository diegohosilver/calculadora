package test.controles;

import static org.junit.Assert.assertEquals;

import java.awt.Dimension;

import javax.swing.JButton;

import org.junit.Test;

import main.interfaz.controles.Boton;
import main.interfaz.controles.BotonDimensiones;

public class BotonTest {
	
	@Test
	public void GenerarBotonTest() {
		JButton boton = Boton.generarBoton("Texto", new BotonDimensiones(10, 10, 20, 30));
		
		assertEquals("Texto", boton.getText());
		assertEquals(10, boton.getX());
		assertEquals(10, boton.getY());
		assertEquals(20, boton.getWidth());
		assertEquals(30, boton.getHeight());
	}
}
