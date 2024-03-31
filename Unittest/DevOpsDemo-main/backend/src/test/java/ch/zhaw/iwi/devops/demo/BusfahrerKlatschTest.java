package ch.zhaw.iwi.devops.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class BusfahrerKlatschTest {

    @Test
    public void zweiBusfahrerTreffenSichAnErsterHaltestelle() {
        BusfahrerKlatsch klatsch = new BusfahrerKlatsch();
        int[][] buslinien = {{1, 2, 3}, {1, 8, 5}};
        assertEquals("1", klatsch.berechneAustauschDauer(buslinien));
    }  
}
