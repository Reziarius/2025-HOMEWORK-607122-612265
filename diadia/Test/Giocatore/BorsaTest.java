package Giocatore;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import attrezzi.Attrezzo;
class BorsaTest {
	private Attrezzo lanterna;
	private Attrezzo osso;
	private Borsa borsa;
	
	
	@BeforeEach
	public void setUp() {
		borsa = new Borsa();
		lanterna = new Attrezzo("lanterna",2);
        osso = new Attrezzo("osso",1);
        this.borsa.addAttrezzo(lanterna);
        this.borsa.addAttrezzo(osso);
	}
	
	//test case di get peso
	
	@Test
	public void testGetPeso() {
		assertEquals(3,borsa.getPeso());
	}

	//test case get attrezzo,primo caso ottengo quello giusto, il secondo cerco uno che non c'è, terzo cerco il null
	
	@Test
	public void testGetAttrezzoGiusto() {
		assertEquals(osso,borsa.getAttrezzo("osso"));
	}
	
	@Test
	public void testGetAttrezzoSbagliato() {
		assertNull(borsa.getAttrezzo("Lama del caos"));
	}
	
	@Test
	public void testGetAttrezzoNull() {
		assertNull(borsa.getAttrezzo(null));
	}
	
	//test case add attrezzo, primo aggiungo con successo, secondo fallisco, terzo inserisco null
	
	@Test
	public void testAddAttrezzoSuccesso() {
		Attrezzo LamaDiEleonora= new Attrezzo("Lama di Eleonora",6);
		assertTrue(borsa.addAttrezzo(LamaDiEleonora));
		assertTrue(borsa.hasAttrezzo("Lama di Eleonora"));
		assertEquals(9,borsa.getPeso());
	}
	
	@Test
	public void testAddAttrezzoFallito() {
		Attrezzo MoonBlade= new Attrezzo("MoonBlade",10);
		assertFalse(borsa.addAttrezzo(MoonBlade));
		assertFalse(borsa.hasAttrezzo("MoonBlade"));
		assertEquals(3,borsa.getPeso());
	}
	
	@Test
	public void testAddAttrezzoNull(){
		assertFalse(borsa.addAttrezzo(null));
	}	

	//test case remove attrezzo, uno lo rimuove con successo, uno rimuove un elemento non presente uno cerca di levare null

	@Test
	public void testRemoveAttrezzoSuccesso() {
		assertTrue(borsa.removeAttrezzo("osso"));
		assertFalse(borsa.hasAttrezzo("osso"));
		assertEquals(2,borsa.getPeso());
	}
	
	@Test
	public void testRemoveAttrezzoNonPresente() {
		assertFalse(borsa.removeAttrezzo("Uchigatana"));
	}

	@Test
	public void testRemoveAttrezzoNull() {
		assertFalse(borsa.removeAttrezzo(null));
	}
}
