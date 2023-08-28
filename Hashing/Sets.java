package Hashing;

import java.util.*;

public class Sets {
    public static void main(String[] args) {
        //Creation
        HashSet<Integer> set = new HashSet<Integer>();
        
        //Insertng element to set - .add(e)
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        set.add(1);//doesn't allow duplicates

        //Print the whole set
        System.out.println("Set: " + set);

        //Search - .contains(e)
        System.out.println(set.contains(1));
        System.out.println(set.contains(6));

        //Delete - .remove(e)
        set.remove(5);
        System.out.println(set);

        //Size - .size()
        System.out.println(set.size());

        //Iterators - .iterator()
        Iterator it = set.iterator();
        
        //Iterator initially points to null.
        //To return the next value: .next()
        System.out.println("Next: " + it.next());
        System.out.println("Again Next: " + it.next());

        //Iterators are automatically updated
        
        //Check if next value exists - .hasNext()
        while (it.hasNext()){
            //This won't print from the first, because the first two elements are already Iterated.
            System.out.println(it.next());
        }
    }
    
    
}
