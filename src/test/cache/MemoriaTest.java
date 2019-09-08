package test.cache;

import static org.junit.Assert.*;

import org.junit.Test;

import main.negocio.Memoria;

public class MemoriaTest {

	@Test
	public void ArrayVacioTest() {
		Memoria memoria = Memoria.obtenerInstancia();
		
		memoria.vaciar();
		
		assertTrue(memoria.listar().size() == 0);
	}
	
	@Test
	public void LimiteSuperadoDevuelve3ElementosTest() {
		Memoria memoria = Memoria.obtenerInstancia();
		
		memoria.agregar(1);
		memoria.agregar(2);
		memoria.agregar(3);
		memoria.agregar(4);
		
		assertTrue(memoria.listar().size() == 3);
		assertFalse(memoria.listar().contains(1));
	}
	
}
