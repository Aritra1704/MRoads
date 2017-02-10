package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class VerifyFlights {

    public static String checkFlight(ArrayList<String> arrFlights, String stoppage) {
        String flights = "";
        StringBuilder strFlight = new StringBuilder();
        if(!isEmpty(stoppage) && stoppage.contains("-")) {
            String source = stoppage.split("-")[0];
            String destination = stoppage.split("-")[1];

            if(arrFlights != null && arrFlights.size() > 0) {
                LinkedHashMap<String, Integer> hashMap = new LinkedHashMap<>();
                for (String flight : arrFlights) {
                    if(flight.contains(source) && flight.contains(destination)) {
                        String[] flightPath = flight.split("/");
                        int inBetStop = getStringPosition(flightPath, destination) - getStringPosition(flightPath, source);
                        if(inBetStop > 0) {
                            hashMap.put(flightPath[0], inBetStop);
                        }
                    }
                }

                hashMap = sortByComparator(hashMap, true);
                Object[] flightList = hashMap.keySet().toArray();
                for (int i = 0; i < flightList.length; i++) {
                    strFlight.append(flightList[i]);
                    strFlight.append(",");
                }
            }
        }

        flights = removeLastComma(strFlight.toString());

        return flights;
    }

    public static String removeLastComma(String inputString){
        String finalStr = "";

        if(!isEmpty(inputString)){
            inputString = inputString.toString().trim();

            if(inputString.contains(","))
                finalStr = inputString.substring(0, inputString.lastIndexOf(","));
            else
                finalStr = inputString;
        }

        return finalStr;
    }

    static boolean isEmpty(String inputString) {
        if(inputString != null && !inputString.equalsIgnoreCase(""))
            return false;
        else
            return true;
    }

    static int getStringPosition(String[] allStop, String stop) {
        for (int i = 0; i < allStop.length; i++) {
            if(allStop[i].equals(stop)){
                return i;
            }
        }
        return -1;
    }

    private static LinkedHashMap<String, Integer> sortByComparator(LinkedHashMap<String, Integer> unsortMap, final boolean order)
    {
        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(unsortMap.entrySet());

        // Sorting the list based on values
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (order) {
                    return o1.getValue().compareTo(o2.getValue());
                } else {
                    return o2.getValue().compareTo(o1.getValue());
                }
            }
        });

        // Maintaining insertion order with the help of LinkedList
        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }
}
