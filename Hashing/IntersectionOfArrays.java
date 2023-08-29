/*
Given two arrays, find their Intersection.
*/
import java.util.*;

public class IntersectionOfArrays {
    public static ArrayList<Integer> intersection(int [] arr1, int [] arr2) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }
        for(int j = 0; j < arr2.length; j++){
            if(set.contains(arr2[j])){
                res.add(arr2[j]);
                set.remove(arr2[j]);
            }
                
            // else
            //     res.add(arr2[j]);
        }

        return res;
    }
    public static void main(String[] args) {
        int a[] = {7,3,9,5};
        int b[] = {5,7,2,3,6,8};

        System.out.println("Intersection: " + intersection(a,b));
    }
}
