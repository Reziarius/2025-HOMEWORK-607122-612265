package Comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ComandoPosaTest {
	private Comando comandoPosa;
	
	@BeforeEach
	public void setUp() {
		comandoPosa=new ComandoPosa();
		comandoPosa.setParametro("Claymore");
	}
	
	@Test
	void testGetNomeCorretto() {
		assertEquals(comandoPosa.getNome(),"posa");
	}
	@Test
	void testGetNomeSbagliato() {
		assertNotEquals(this.comandoPosa.getNome(),"comando non valido");
	}
	@Test
	void testGetParametroCorretto() {
		assertEquals(this.comandoPosa.getParametro(),"Claymore");
	}
	@Test
	void testGetParametroSbagliato() {
		assertNotEquals(this.comandoPosa.getParametro(),"Lungo artiglio");
	}
	@Test
	void testGetParametroNull() {
		this.comandoPosa.setParametro(null);
		assertNull(this.comandoPosa.getParametro());
	}
	
	//METODO ESEGUI DA IMPLEMENTARE DOPO IOSIMULATOR
	

}
