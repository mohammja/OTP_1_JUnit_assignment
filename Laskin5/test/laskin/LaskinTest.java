package laskin;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
/*
 * JUnit 5
 */

public class LaskinTest { // Luokan nimen loppu pitää olla Test

    // Fixture ("vakiokaluste"): kaikki testit käyttävät samaa laskinta,
    // joka nollataan ennen kutakin testiä.
    private Laskin laskin = new Laskin();
    private final double DELTA = 0.001;

    @BeforeEach
    public void clearCalculator() {
        laskin.nollaa();
    }

    // Testimetodin nimi voi olla mitä tahansa, edessä annotaatio @Test
    @Test
    @DisplayName("Testaa lisäyslasku 1 + 2")
    public void testLisaa() {
        laskin.lisaa(1);
        laskin.lisaa(2);
        assertEquals(3, laskin.annaTulos(),DELTA, "Lukujen 1 ja 2 summa väärin");
    }

    @Test
    @DisplayName("Testaa vähennyslasku 10 - 2")
    public void testVahenna() {
        laskin.lisaa(10);
        laskin.vahenna(2);
        assertEquals(8, laskin.annaTulos(),DELTA, "Lukujen 10 ja 2 erotus väärin");
    }

    @Test
    @DisplayName("Testaa jakolasku 8 / 2")
    public void testJaa() {
        laskin.lisaa(8);
        laskin.jaa(2);
        assertEquals(4, laskin.annaTulos(),DELTA, "Jakolasku 8/2 väärin");
    }

    // Testin oikea tulos on, että nollallajako heittää poikkeuksen,
    // kutsuja käsittelee sen sitten haluamallaan tavalla
    @Test
    @DisplayName("Testaa nollallajako")
    public void testJaaNollalla() {
        ArithmeticException poikkeus = assertThrows(ArithmeticException.class, () -> laskin.jaa(0));
        assertEquals("Nollalla ei voi jakaa", poikkeus.getMessage());
    }

    @Test
    //@Disabled("HUOMAA - Metodi kerro() on vielä toteuttamatta, eikä sitä haluta ajaa vielä")
    @DisplayName("Testaa Kertolasku 5 * 2")
    public void testKerro() {
        //fail("TESTIÄ EI OLE VIELÄ TOTEUTETTU");
        laskin.lisaa(5);
        laskin.kerro(2);
        assertEquals(10,laskin.annaTulos(),DELTA,"Kertolasku 5*2 väärin");
    }
}
