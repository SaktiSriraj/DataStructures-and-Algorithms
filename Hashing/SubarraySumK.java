/*
Given an array of integers and an integer K.
find the number of subarrays, whose sum equals to K.
*/

import java.util.*;
public class SubarraySumK {
    public static void main(String[] args) {
        int arr[] = {10,2,-2,-20,10};
        int k = -10;
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        map.put(0,1);
        int ans = 0, sum = 0;
        for(int j=0;j<arr.length;j++){
            sum+=arr[j];

            if(map.containsKey(sum-k))
                ans += map.get(sum-k);

            if(map.containsKey(sum))
                map.put(sum,map.get(sum) + 1);
            else
                map.put(sum,1);
        }
        System.out.println(ans);
    }
}
