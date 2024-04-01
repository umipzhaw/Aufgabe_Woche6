package ch.zhaw.iwi.devops.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BusfahrerKlatschTest {

    @Test
    public void zweiBusfahrerTreffenSichAnErsterHaltestelle() {
        BusfahrerKlatsch klatsch = new BusfahrerKlatsch();
        int[][] buslinien = {{7, 2, 5}, {1, 8, 5}};
        assertEquals("3", klatsch.berechneAustauschDauer(buslinien));
    }  

        @Test
    public void busfahrerTauschenGeschichtenNachMehrerenRundenAus() {
        BusfahrerKlatsch klatsch = new BusfahrerKlatsch();
        int[][] buslinien = {{1, 4, 7}, {2, 4, 6}, {3, 5, 7}};
        // Annahme: Die Methode gibt die Runde zurück, in der der letzte Austausch stattfindet,
        // unter Berücksichtigung der Wiederholung der Routen und indirekter Austausche.
        assertEquals("5", klatsch.berechneAustauschDauer(buslinien));
    }  

    @Test
    public void busfahrerTauschenGeschichtenNichtaus() {
        BusfahrerKlatsch klatsch = new BusfahrerKlatsch();
        int[][] buslinien = {{1, 4, 7}, {2, 4, 6}, {3, 5, 9}};
        // Annahme: Die Methode gibt die Runde zurück, in der der letzte Austausch stattfindet,
        // unter Berücksichtigung der Wiederholung der Routen und indirekter Austausche.
        assertEquals("Kein Austausch möglich", klatsch.berechneAustauschDauer(buslinien));
    }  

    @Test
    public void busfahrerTauschenGeschichtenNachmehrerenDurchlufenaus() {
        BusfahrerKlatsch klatsch = new BusfahrerKlatsch();
        int[][] buslinien = {{1, 4, 7}, {2, 4, 6}, {3, 5, 7}};
        // Annahme: Die Methode gibt die Runde zurück, in der der letzte Austausch stattfindet,
        // unter Berücksichtigung der Wiederholung der Routen und indirekter Austausche.
        assertEquals("5", klatsch.berechneAustauschDauer(buslinien));
    } 

    @Test
    public void austauschDauertLaengerAls480Minuten() {
        BusfahrerKlatsch klatsch = new BusfahrerKlatsch();
    
        int[][] buslinien = new int[3][];
        buslinien[0] = new int[160]; // Bus 1
        buslinien[1] = new int[160]; // Bus 2
        buslinien[2] = new int[160]; // Bus 3
        for (int i = 0; i < 160; i++) {
            buslinien[0][i] = i + 1; // Füllen mit aufsteigenden Zahlen
            buslinien[1][i] = i + 161; // Eine andere Reihe von Zahlen, um Überschneidungen zu vermeiden
            buslinien[2][i] = i + 321; // Und eine weitere Reihe
        }
    
        // Überprüfen, ob "Zeitüberschreitung" zurückgegeben wird, da der Austausch länger als 480 Minuten dauert
        assertEquals("Zeitüberschreitung", klatsch.berechneAustauschDauer(buslinien));
    }
    



}
