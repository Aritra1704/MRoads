package com.example;

import java.util.ArrayList;

import java.util.ArrayList;

public class VerifyFlights {

    public static String checkFlight(ArrayList<String> arrFlights, String stoppage) {
        String flights = "";
        StringBuilder strFlight = new StringBuilder();
        if(!isEmpty(stoppage) && stoppage.contains("-")) {
            String source = stoppage.split("-")[0];
            String destination = stoppage.split("-")[1];

            if(arrFlights != null && arrFlights.size() > 0) {
                for (String flight : arrFlights) {
                    if(flight.contains(source) && flight.contains(destination)) {
                        strFlight.append(flight.split("/")[0]);
                        strFlight.append(",");
                    }
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
}
