package Hashing;

import java.util.*;

public class Maps {
    public static void main(String[] args) {
        //Creation
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        //Insertion - .put(key, value)
        //Maps are unordered, this means insertion order doesn't matter
        map.put("India" , 140);
        map.put("USA" , 30);
        map.put("China" , 120);
        map.put("Japan" ,20);

        System.out.println("Initial Map: " + map);

        //If a key already exists, then the corresponding value is updated
        map.put("India",130);
        System.out.println("Updated Map: "+map);

        //Searching - .containsKey(keyName) [Searches if a key is present]
        System.out.println("Key China Present: " + map.containsKey("China"));
        System.out.println("Key Indonesia Present: " + map.containsKey("Indonesia"));

        //Searching - .get (keyName) [returns corresponding Value]
        System.out.println("China Value: " + map.get("China"));
        System.out.println("Indonesia Value: " + map.get("Indonesia"));

        //Enhanced for-loop for Collection
        //for(dataType val : collectionName){ print(val)}
        for(Map.Entry<String,Integer> e : map.entrySet()){
            System.out.print(e.getKey() + " = " + e.getValue() + "; ");
        }

        System.out.println("\n");

        //Iterating over KeySets - map.keySet()
        //map.get(key) -> Gives the value for the corresponding key
        Set<String> keys = map.keySet();
        for(String key : keys){
            System.out.println(key + " = " + map.get(key));
        }


        //Remove a pair - .remove(key)
        //Corresponding value will also be removed
        map.remove("China");
        System.out.println(map);

        map.remove("Indonesia");//does nothing, bcz key doesn't exist
        System.out.println(map);
    }
}
