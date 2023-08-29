/*
Given two arrays, find their union
*/

import java.util.*;

public class UnionOfArrays {
    public static HashSet<Integer> union(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<Integer>();
        int n = arr1.length; int m = arr2.length;
        for(int i = 0; i < n; i++) {
            set.add(arr1[i]);
        }
        for(int i = 0; i < m; i++) {
            set.add(arr2[i]);
        }
        return set;
        
    }
    public static void main(String[] args) {
        int a[] ={7,3,9};
        int b[]={6,3,9,10,2,4,5};
        System.out.println("Union: "+union(a,b));
    }
    
}
