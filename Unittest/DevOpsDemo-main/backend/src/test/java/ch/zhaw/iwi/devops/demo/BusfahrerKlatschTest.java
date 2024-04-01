package ch.zhaw.iwi.devops.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BusfahrerKlatschTest {

    @Test
    public void zweiBusfahrerTreffenSichAnErsterHaltestelle() {
        BusfahrerKlatsch klatsch = new BusfahrerKlatsch();
        int[][] buslinien = {{1, 2, 3}, {1, 8, 5}};
        assertEquals("1", klatsch.berechneAustauschDauer(buslinien));
    }  

    @Test
    public void busfahrerTauschenGeschichtenNachMehrerenRundenAus() {
        BusfahrerKlatsch klatsch = new BusfahrerKlatsch();
        int[][] buslinien = {{1, 4, 7}, {2, 4, 6}, {3, 5, 7}};
        // Annahme: Die Methode gibt die Runde zurück, in der der letzte Austausch stattfindet,
        // unter Berücksichtigung der Wiederholung der Routen und indirekter Austausche.
        assertEquals("5", klatsch.berechneAustauschDauer(buslinien));
    }  
}
