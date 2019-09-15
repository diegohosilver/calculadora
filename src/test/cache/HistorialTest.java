package test.cache;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Map;
import java.util.UUID;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.Test;

import main.negocio.Historial;
import main.negocio.Operacion;
import main.negocio.Util;

public class HistorialTest {

	@Test(expected = IllegalArgumentException.class)
	public void DescripcionVaciaTest() {
		Historial historial = Historial.obtenerInstancia();
		
		historial.agregar("", 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void DescripcionNullTest() {
		Historial historial = Historial.obtenerInstancia();
		
		historial.agregar(null, 1);
	}
	
	@Test(expected = NoSuchElementException.class)
	public void ClaveInexistenteTest(){
		Historial historial = Historial.obtenerInstancia();
		
		historial.obtener(Util.ObtenerGuid());
	}
	
	@Test
	public void NuevoItemValidoTest() {
		Historial historial = Historial.obtenerInstancia();
		
		historial.agregar("1 + 1", 2);
		
		for (Map.Entry<String, Operacion> item : historial.listar().entrySet()) {
			// Validar clave
			String guid = Util.ParsearGuid(item.getKey());
			UUID uuid = UUID.fromString(guid);
			
			assertEquals(guid, uuid.toString());
		    
		    //Validar valor
			assertEquals("1 + 1", item.getValue().descripcion());
		    assertTrue(2 == item.getValue().valor());
		}
	}
	
	@Test
	public void ObtenerItemTest() {
		Historial historial = Historial.obtenerInstancia();
		Operacion operacion = new Operacion("5*5", 25);
		String clave = Util.ObtenerGuid();
		
		historial.agregar(clave, operacion);
		
		//Validar el elemento solicitado
		Operacion busqueda = historial.obtener(clave);
		
		assertTrue("5*5" == busqueda.descripcion());
		assertTrue(25 == busqueda.valor());
	}
	
	@Test
	public void VaciarTest() {
		Historial historial = Historial.obtenerInstancia();
		
		historial.vaciar();
		
		assertTrue(historial.listar().size() == 0);
	}
	
	@Test(expected = NoSuchElementException.class)
	public void TruncarItemInexistenteTest() {
		Historial historial = Historial.obtenerInstancia();
		
		String clave = Util.ObtenerGuid();
		
		historial.restaurar(clave);
	}
	
	@Test
	public void TruncarHistorialTest() {
		Historial historial = Historial.obtenerInstancia();
		
		// Comenzar con un historial limpio
		historial.vaciar();
		
		String clave = Util.ObtenerGuid();
		Operacion operacion = new Operacion("4+4", 8);
		
		historial.agregar("2+2", 4);
		historial.agregar("3+3", 6);
		historial.agregar(clave, operacion);
		historial.agregar("5+5", 10);
		
		historial.restaurar(clave);
		
		assertTrue(historial.listar().size() == 3);
		
		Optional<Operacion> itemInexistente = historial.listar().entrySet().stream()
				.filter(x -> x.getValue().descripcion().equals("5+5"))
				.map(Map.Entry::getValue)
				.findFirst();
		
		assertFalse(itemInexistente.isPresent());
	}
}