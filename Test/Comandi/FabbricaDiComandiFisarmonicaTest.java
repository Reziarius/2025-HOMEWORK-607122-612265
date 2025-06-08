package Comandi;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
class FabbricaDiComandiFisarmonicaTest {
	private FabbricaDiComandi factory;
	private Comando comando;
	
	@BeforeEach
	public void setUp() {
		factory=new FabbricaDiComandiFisarmonica();
	}
	
	@Test
	public void testCostruisciComandoCorrettoVai(){
		comando=this.factory.costruisciComando("vai nord");
		assertEquals(this.comando.getNome(),"vai");
		assertEquals(this.comando.getParametro(),"nord");
	}
	
	@Test
	public void testCostruisciComandoSbagliatoVai(){
		comando=this.factory.costruisciComando("posa nord");
		assertNotEquals(this.comando.getNome(),"vai");
		assertEquals(this.comando.getParametro(),"nord");
		assertEquals(this.comando.getNome(),"posa");
	}
	@Test
	public void testCostruisciComandoCorrettoPosa() {
		comando=this.factory.costruisciComando("posa SpadoneDellaLunaNera");
		assertEquals(this.comando.getNome(),"posa");
		assertEquals(this.comando.getParametro(),"SpadoneDellaLunaNera");
	}
	@Test
	public void testCostruisciComandoSbagliatoPosa() {
		comando=this.factory.costruisciComando("guarda SpadoneDellaLunaNera");
		assertNotEquals(this.comando.getNome(),"posa");
		assertNull(this.comando.getParametro());
		assertEquals(this.comando.getNome(),"guarda");
	}
	@Test
	public void testCostruisciComandoCorrettoPrendi() {
		comando=this.factory.costruisciComando("prendi SpadoneDellaLunaNera");
		assertEquals(this.comando.getNome(),"prendi");
		assertEquals(this.comando.getParametro(),"SpadoneDellaLunaNera");
	}
	@Test
	public void testCostruisciComandoSbagliatoPrendi() {
		comando=this.factory.costruisciComando("fine SpadoneDellaLunaNera");
		assertNotEquals(this.comando.getNome(),"prendi");
		assertNull(this.comando.getParametro());
		assertEquals(this.comando.getNome(),"fine");
	}
	@Test
	public void testCostruisciComandoCorrettoGuarda() {
		comando=this.factory.costruisciComando("guarda");
		assertEquals(this.comando.getNome(),"guarda");
		assertNull(this.comando.getParametro());
	}
	@Test
	public void testCostruisciComandoSbagliatoGuarda() {
		comando=this.factory.costruisciComando("prendi LunaVelata");
		assertNotEquals(this.comando.getNome(),"guarda");
	}
	@Test
	public void testCostruisciComandoCorrettoFine() {
		comando=this.factory.costruisciComando("fine");
		assertEquals(this.comando.getNome(),"fine");
		assertNull(this.comando.getParametro());
	}
	@Test
	public void testCostruisciComandoSbagliatoFine() {
		comando=this.factory.costruisciComando("posa LunaVelata");
		assertNotEquals(this.comando.getNome(),"fine");
	}
	@Test
	public void testCostruisciComandoAiuto() {
		comando=this.factory.costruisciComando("aiuto");
		assertEquals(this.comando.getNome(),"aiuto");
		assertNull(this.comando.getParametro());
	}
	@Test
	public void testCostruisciComandoSbagliatoAiuto() {
		comando=this.factory.costruisciComando("fine");
		assertNotEquals(this.comando.getNome(),"aiuto");
		assertNull(this.comando.getParametro());
		assertEquals(this.comando.getNome(),"fine");
	}
}
