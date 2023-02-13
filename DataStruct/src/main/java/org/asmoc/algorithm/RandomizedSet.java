package org.asmoc.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class RandomizedSet {

    HashMap<Integer, Integer> hashMap;
    ArrayList<Integer> nums;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        hashMap = new HashMap<>();
        nums = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (hashMap.containsKey(val))
            return false;
        hashMap.put(val, nums.size());
        nums.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
       if (hashMap.containsKey(val)) {
           int num = hashMap.get(val);
           hashMap.put(nums.get(nums.size()-1), num);
           nums.set(num, nums.get(nums.size()-1));
           hashMap.remove(val);
           nums.remove(nums.size()-1);
           return true;
       }
       return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random random = new Random();
        int to = random.nextInt(nums.size());
        return nums.get(to);
    }

}
