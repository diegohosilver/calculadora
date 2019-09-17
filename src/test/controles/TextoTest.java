package test.controles;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.awt.Color;

import javax.swing.JTextField;

import org.junit.Test;

import main.interfaz.controles.*;

public class TextoTest {
	
	@Test(expected = IllegalArgumentException.class)
	public void GenerarTextoEventoVacioTest() {
		Control.generarTexto(new Dimensiones(10, 10, 20, 30), Color.WHITE, false, null);
	}
	
	@Test
	public void GenerarTextoTest() {
		JTextField texto = Control.generarTexto(new Dimensiones(10, 10, 20, 30), Color.WHITE, false);
		
		assertEquals(10, texto.getX());
		assertEquals(10, texto.getY());
		assertEquals(20, texto.getWidth());
		assertEquals(30, texto.getHeight());
		assertEquals(Color.WHITE, texto.getBackground());
		assertFalse(texto.isEditable());
	}

}
