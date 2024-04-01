package ch.zhaw.iwi.devops.demo;

public class BusfahrerKlatsch {

    public String berechneAustauschDauer(int[][] buslinien) {
        for (int i = 0; i < buslinien[0].length; i++) {
            int haltestelle = buslinien[0][i];
            for (int j = 0; j < buslinien[1].length; j++) {
                if (haltestelle == buslinien[1][j]) {
                    return String.valueOf(i + 1);
                }
            }
        }
        return "Keine gemeinsame Haltestelle gefunden";
    }
}
    
