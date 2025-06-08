package ambiente;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ambiente.StanzaMagica;
import attrezzi.Attrezzo;

public class StanzaMagicaTest {

    private StanzaMagica archiviDelDuca;

    @BeforeEach
    public void setUp() {
        archiviDelDuca = new StanzaMagica("Archivi Del Duca", 3);
    }

    @Test
    public void testAddAttrezzoSottoSogliaNonModificato() {
        Attrezzo attrezzo = new Attrezzo("MoonBlade", 2);
        assertTrue(archiviDelDuca.addAttrezzo(attrezzo));

        Attrezzo ottenuto = archiviDelDuca.getAttrezzo("MoonBlade");
        assertNotNull(ottenuto);
        assertEquals("MoonBlade", ottenuto.getNome());
        assertEquals(2, ottenuto.getPeso());
    }

    @Test
    public void testAddAttrezzoEsattamenteAllaSogliaNonModificato() {
        archiviDelDuca.addAttrezzo(new Attrezzo("LanciaDelSole", 1));
        archiviDelDuca.addAttrezzo(new Attrezzo("Claymore", 1));
        archiviDelDuca.addAttrezzo(new Attrezzo("BastoneCariano", 1)); // 3° attrezzo

        Attrezzo att = archiviDelDuca.getAttrezzo("BastoneCariano");
        assertNotNull(att);
        assertEquals("BastoneCariano", att.getNome()); // non ancora modificato
        assertEquals(1, att.getPeso());
    }

    @Test
    public void testAddAttrezzoDopoSogliaModificato() {
        archiviDelDuca.addAttrezzo(new Attrezzo("LanciaDelSole", 1));
        archiviDelDuca.addAttrezzo(new Attrezzo("Claymore", 1));
        archiviDelDuca.addAttrezzo(new Attrezzo("BastoneCariano", 1));

   
        Attrezzo attrezzoMagico = new Attrezzo("lanterna", 3);				//push del quarto
        assertTrue(archiviDelDuca.addAttrezzo(attrezzoMagico));

        
        Attrezzo modificato = archiviDelDuca.getAttrezzo("anretnal");
        assertNotNull(modificato);
        assertEquals("anretnal", modificato.getNome());
        assertEquals(6, modificato.getPeso());
    }

    @Test
    public void testAddPiùAttrezziDopoSoglia() {
        archiviDelDuca.addAttrezzo(new Attrezzo("x1", 1));
        archiviDelDuca.addAttrezzo(new Attrezzo("x2", 1));
        archiviDelDuca.addAttrezzo(new Attrezzo("x3", 1));

        archiviDelDuca.addAttrezzo(new Attrezzo("fuoco", 2));
        archiviDelDuca.addAttrezzo(new Attrezzo("ghiaccio", 1));

        assertNotNull(archiviDelDuca.getAttrezzo("ocouf"));
        assertNotNull(archiviDelDuca.getAttrezzo("oiccaihg"));
        
    }

    @Test
    public void testAttrezzoNonTrovato() {
        assertNull(archiviDelDuca.getAttrezzo("inesistente"));
    }

    @Test
    public void testRimozioneAttrezzoFunziona() {
        archiviDelDuca.addAttrezzo(new Attrezzo("ScudoOndulato", 1));
        assertTrue(archiviDelDuca.hasAttrezzo("ScudoOndulato"));
        archiviDelDuca.removeAttrezzo("ScudoOndulato");
        assertFalse(archiviDelDuca.hasAttrezzo("ScudoOndulato"));
    }
}

