package ambiente;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import attrezzi.Attrezzo;

class StanzaBuiaTest {
	private Stanza stanzaBuia;
	private Attrezzo LarvaDelSole;
	
	@BeforeEach
	public void setUP() {
		stanzaBuia=new StanzaBuia("Tomba dei Giganti","LarvaDelSole");
	}
	
	@Test
	public void testGetDescrizioneBuio() {
		assertEquals(stanzaBuia.getDescrizione(),"qui c'è buio pesto");
	}
	@Test
	public void testGetDescrizioneNormale() {
		LarvaDelSole=new Attrezzo("LarvaDelSole",2);
		assertTrue(stanzaBuia.addAttrezzo(LarvaDelSole));
		assertNotEquals(stanzaBuia.getDescrizione(),"qui c'è buio pesto");
	}
}
