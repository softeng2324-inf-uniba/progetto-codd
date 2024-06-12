package it.uniba.app.testclass;

import it.uniba.app.campodagioco.Cella;
import it.uniba.app.campodagioco.Tavoliere;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

/**
* Classe per i test della classe Cella.
*/
class CellaTest {
    private Cella cella;

    /**
     * Test per il primo costruttore della classe Cella.
    */
    @Test
    public void testCostruttoreCella() {
        var tavoliere = new Tavoliere();
        final int coordinataZero = 0;
        final int coordinataTre = 3;
        final int coordinataCinque = 5;
        assertEquals(2, tavoliere.getIdTav(coordinataZero, coordinataZero));
        assertEquals(2, tavoliere.getIdTav(coordinataTre, coordinataZero));
        assertEquals(2, tavoliere.getIdTav(coordinataCinque, coordinataCinque));
    }

    /**
     * Test per il secondo costruttore della classe Cella.
     */
    @Test
    public void testSecondoCostruttoreCella() {
        cella = new Cella(1);
        assertEquals(1, cella.getId());
    }

    /**
     * Test per i metodo SetId e GetId.
     */
    @Test
    public void testSetGetId() {
        final int valoreInserito = 3;
        Cella newCella = new Cella(1);
        newCella.setId(valoreInserito);
        assertEquals(valoreInserito, newCella.getId());
        final int valoreInserito2 = 500;
        newCella.setId(valoreInserito2);
        assertEquals(valoreInserito2, newCella.getId());
        final int valoreInserito3 = 500;
        newCella.setId(valoreInserito3);
        assertEquals(valoreInserito3, newCella.getId());
        char valInserito = 'c';
        newCella.setId(valInserito);
        assertEquals(valInserito, newCella.getId());
    }
}
