package DiaDia;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import ambiente.Stanza;

class PartitaTest {
	private Partita partita;
	private Stanza stanza;
	
	
	@BeforeEach
	public void setUp() {
		partita=new Partita();
		stanza=new Stanza("stanza");
	}

	
	@Test
	public void testSetGetStanzaCorrente() {
		partita.setStanzaCorrente(stanza);
		assertEquals(stanza,partita.getStanzaCorrente());
	}
	
	@Test
	public void testSetStanzaCorrenteNull() {
		partita.setStanzaCorrente(null);
		assertNull(partita.getStanzaCorrente());
	}
	
	@Test
	public void testIsFinitaNO() {
		assertFalse(partita.isFinita());
	}
	
	@Test
	void testIsFinitaSI() {
		partita.setStanzaCorrente(partita.getLabirinto().getStanzaFinale());
		assertTrue(partita.isFinita());
	}
}
