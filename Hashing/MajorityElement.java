/*
Given an array of n-integers. Find the number that occurs more then n/3 times

Eg: nums[] = {1,3,2,5,1,3,1,5,1}
    O/P = 1        (Because 9/3 = 3; 1 appears 4 times, which is more than 3)

    nums[] = {1,2}
    O/P = 1,2       (Because 2/3 = 0; 1,2 both appear 1 time, which is more than 0)
*/

import java.util.HashMap;

public class MajorityElement {

    public static void majorityElement(int nums[]){
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(map.containsKey(nums[i]))
                map.put(nums[i], map.get(nums[i])+1);
            else
                map.put(nums[i],1);
        }

        for(int key : map.keySet()){
            if(map.get(key) > n/3)
                System.out.println(key + " ");
        }
    }
    public static void main(String[] args) {
        int num[] = {1,3,2,5,1,3,1,5,1};
        majorityElement(num);
    }
}
