package ambiente;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ambiente.Stanza;
class LabirintoTest {
	
	private Labirinto labirinto;
	private Stanza tavolaRotonda; 
	private Stanza alberoMadre;
	
	@BeforeEach
	
	public void setUp() {
		labirinto = new Labirinto();
		tavolaRotonda =new Stanza("tavola rotonda");
		alberoMadre = new Stanza("albero madre");
	}
	
	@Test
	public void testSetANDGetStanzaIN() {
		labirinto.setStanzaIniziale(alberoMadre);
		assertSame(alberoMadre,labirinto.getStanzaInziale());
		labirinto.setStanzaIniziale(null);
		assertNull(labirinto.getStanzaInziale());
	}
	
	@Test
	public void testSetANDGetStanzaFIN() {
		labirinto.setStanzaFinale(alberoMadre);
		assertSame(alberoMadre,labirinto.getStanzaFinale());
		labirinto.setStanzaFinale(null);
		assertNull(labirinto.getStanzaFinale());
	}
}



