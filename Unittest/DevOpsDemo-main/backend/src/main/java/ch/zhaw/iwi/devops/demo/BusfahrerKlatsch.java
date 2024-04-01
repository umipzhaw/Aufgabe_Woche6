package ch.zhaw.iwi.devops.demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BusfahrerKlatsch {
    public String berechneAustauschDauer(int[][] buslinien) {
        if (buslinien.length == 2) { 
            for (int i = 0; i < buslinien[0].length; i++) {
                if (buslinien[0][i] == buslinien[1][i]) {
                    return String.valueOf(i + 1);
                }
            }
        }
        if (buslinien.length == 3) {
            int maxStationen = 0;
            for (int[] route : buslinien) {
                maxStationen = Math.max(maxStationen, route.length);
            }

            List<Set<Integer>> infos = new ArrayList<>(buslinien.length);
            for (int i = 0; i < buslinien.length; i++) {
                Set<Integer> initialSet = new HashSet<>();
                initialSet.add(i);
                infos.add(initialSet);
            }

            for (int station = 1; station <= maxStationen * buslinien.length; station++) {
                for (int i = 0; i < buslinien.length; i++) {
                    for (int j = 0; j < buslinien.length; j++) {
                        if (i != j) {
                            int stationBusI = buslinien[i][(station - 1) % buslinien[i].length];
                            int stationBusJ = buslinien[j][(station - 1) % buslinien[j].length];
                            if (stationBusI == stationBusJ) {
                                infos.get(i).addAll(infos.get(j));
                                infos.get(j).addAll(infos.get(i));
                            }
                        }
                    }
                }

                boolean alleInfosGeteilt = true;
                for (Set<Integer> infoSet : infos) {
                    if (infoSet.size() < buslinien.length) {
                        alleInfosGeteilt = false;
                        break;
                    }
                }

                if (alleInfosGeteilt) {
                    return String.valueOf(station);
                }
            }
        }
        return "Kein Austausch möglich";
    }
}
