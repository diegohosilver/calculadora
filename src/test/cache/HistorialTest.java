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
import main.negocio.Registro;
import main.negocio.Util;

public class HistorialTest {

	@Test(expected = IllegalArgumentException.class)
	public void DescripcionVaciaTest() {
		Historial historial = Historial.obtenerInstancia();
		
		historial.agregarRegistro("", 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void DescripcionNullTest() {
		Historial historial = Historial.obtenerInstancia();
		
		historial.agregarRegistro(null, 1);
	}
	
	@Test(expected = NoSuchElementException.class)
	public void ClaveInexistenteTest(){
		Historial historial = Historial.obtenerInstancia();
		
		historial.obtenerRegistro(Util.ObtenerGuid());
	}
	
	@Test
	public void NuevoItemValidoTest() {
		Historial historial = Historial.obtenerInstancia();
		
		historial.agregarRegistro("1 + 1", 2);
		
		for (Map.Entry<String, Registro> item : historial.listar().entrySet()) {
			// Validar clave
			String guid = Util.ParsearGuid(item.getKey());
			UUID uuid = UUID.fromString(guid);
			
			assertEquals(guid, uuid.toString());
		    
		    //Validar valor
			assertEquals("1 + 1", item.getValue().obtenerDescripcion());
		    assertTrue(2 == item.getValue().obtenerValor());
		}
	}
	
	@Test
	public void ObtenerItemTest() {
		Historial historial = Historial.obtenerInstancia();
		Registro registro = new Registro("5*5", 25);
		String clave = Util.ObtenerGuid();
		
		historial.agregarRegistro(clave, registro);
		
		//Validar el elemento solicitado
		Registro busqueda = historial.obtenerRegistro(clave);
		
		assertTrue("5*5" == busqueda.obtenerDescripcion());
		assertTrue(25 == busqueda.obtenerValor());
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
		
		historial.truncarEnRegistro(clave);
	}
	
	@Test
	public void TruncarHistorialTest() {
		Historial historial = Historial.obtenerInstancia();
		
		// Comenzar con un historial limpio
		historial.vaciar();
		
		String clave = Util.ObtenerGuid();
		Registro registro = new Registro("4+4", 8);
		
		historial.agregarRegistro("2+2", 4);
		historial.agregarRegistro("3+3", 6);
		historial.agregarRegistro(clave, registro);
		historial.agregarRegistro("5+5", 10);
		
		historial.truncarEnRegistro(clave);
		
		assertTrue(historial.listar().size() == 3);
		
		Optional<Registro> itemInexistente = historial.listar().entrySet().stream()
				.filter(x -> x.getValue().obtenerDescripcion().equals("5+5"))
				.map(Map.Entry::getValue)
				.findFirst();
		
		assertFalse(itemInexistente.isPresent());
	}
}