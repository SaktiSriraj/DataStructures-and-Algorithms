/*
Given a list of destinations, find the starting point and print the journey path.
Note: No loops present. One to One mapping only. We cannot go to more than one destination from a single source

E.g. :  Chennai -> Bengaluru
        Mumbai -> Delhi
        Goa -> Chennai
        Delhi -> Goa

O/P: Mumbai -> Delhi -> Goa -> Chennai -> Bengaluru

*/

import java.util.*;

public class FindItinerary {

    public static String getStart(HashMap<String, String> tick){
        HashMap<String, String> revMap  = new HashMap<String, String>();
        for(String key : tick.keySet()){
            //key -> key; val -> tick.get(key);
            revMap.put(tick.get(key),key);
        }

        for(String key : tick.keySet()){
            if(!revMap.containsKey(key)){
                return key;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        HashMap<String,String> tickets = new HashMap<>();
        tickets.put("Chennai", "Bengaluru");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");

        String start = getStart(tickets);

        System.out.print("Journey path: ");
        while(tickets.containsKey(start)){
            System.out.print(start + " -> ");
            start = tickets.get(start);
        }
        System.out.print(start);
    }
}