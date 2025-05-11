package Comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class ComandoVaiTest {
	private Comando comandoVai;
	
	
	@BeforeEach
	public void setUp() {
		comandoVai=new ComandoVai();
		comandoVai.setParametro("nord");
	}
	
	@Test
	void testGetNomeCorretto() {
		assertEquals(comandoVai.getNome(),"vai");
	}
	@Test
	void testGetNomeSbagliato() {
		assertNotEquals(this.comandoVai.getNome(),"comando non valido");
	}
	@Test
	void testGetParametroCorretto() {
		assertEquals(this.comandoVai.getParametro(),"nord");
	}
	@Test
	void testGetParametroSbagliato() {
		assertNotEquals(this.comandoVai.getParametro(),"sud");
	}
	@Test
	void testGetParametroNull() {
		this.comandoVai.setParametro(null);
		assertNull(this.comandoVai.getParametro());
	}
	
	//METODO ESEGUI DA IMPLEMENTARE DOPO IOSIMULATOR
	
}
