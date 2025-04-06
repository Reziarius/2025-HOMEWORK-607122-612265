package Giocatore;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class GiocatoreTest {
	private Giocatore giocatore;
	private Borsa borsa;
		
	@BeforeEach
	public void setUp() {
		giocatore= new Giocatore();
		borsa= new Borsa();
	}
	
	@Test
	public void testGetCfu() {
		assertEquals(20,giocatore.getCfu());
	}
	
	@Test
	public void testSetAndGetBorsa() {
		giocatore.setBorsa(borsa);
		assertSame(borsa,giocatore.getBorsa());
	}
}
