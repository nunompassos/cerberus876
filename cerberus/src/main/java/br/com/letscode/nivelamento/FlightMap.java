package br.com.letscode.nivelamento;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class FlightMap implements Travel{
    public Map<String, List<String>> conexoes = Map.of(
    "POA", List.of("BSB"),
    "BSB", List.of("SSA", "NAT", "GRU"),
    "SSA", List.of("REC", "NAT"),
    "GRU", List.of("REC", "POA", "BSB"),
    "SDU", List.of("SSA"),
    "VCP", List.of("SSA"),
    "NAT", Collections.emptyList(),
    "REC", Collections.emptyList()
    );

    public static void main(String[] args) {

    	FlightMap route = new FlightMap();

        System.out.println(route.isReachable("BSB", "REC", 0));
        System.out.println(route.isReachable("REC", "POA", 3));

    }

    @Override
    public boolean isReachable(String from, String to, int numberConnections) {
        if(numberConnections < 0) {
            return false;
        }
        
        List<String> destinos = conexoes.get(from.toUpperCase());

        if (destinos.contains(to.toUpperCase())) {
            return true;
        } else {
            if(destinos.size() == 0){
                return false;
            }
            for (String destino : destinos) {
                if(isReachable(destino, to, --numberConnections)) {
                    return true;
                }
            }
        }
        return false;
    }
}

interface Travel {
    public boolean isReachable(String from, String to, int numberConnections);
}
