package Comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ComandoPrendiTest {
	private Comando comandoPrendi;
	
	
	@BeforeEach
	public void setUp() {
		comandoPrendi=new ComandoPrendi();
		comandoPrendi.setParametro("Claymore");
	}
	
	@Test
	void testGetNomeCorretto() {
		assertEquals(comandoPrendi.getNome(),"prendi");
	}
	@Test
	void testGetNomeSbagliato() {
		assertNotEquals(this.comandoPrendi.getNome(),"comando non valido");
	}
	@Test
	void testGetParametroCorretto() {
		assertEquals(this.comandoPrendi.getParametro(),"Claymore");
	}
	@Test
	void testGetParametroSbagliato() {
		assertNotEquals(this.comandoPrendi.getParametro(),"Lungo artiglio");
	}
	@Test
	void testGetParametroNull() {
		this.comandoPrendi.setParametro(null);
		assertNull(this.comandoPrendi.getParametro());
	}
	
	//METODO ESEGUI DA IMPLEMENTARE DOPO IOSIMULATOR
}
