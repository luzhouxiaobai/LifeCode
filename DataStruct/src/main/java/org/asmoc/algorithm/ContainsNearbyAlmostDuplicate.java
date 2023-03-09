package org.asmoc.algorithm;

import java.util.TreeSet;

public class ContainsNearbyAlmostDuplicate {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        TreeSet<Long> set = new TreeSet<>();
        for(int i=0; i<nums.length; i++) {

            Long res1 = set.floor((long)nums[i]);
            if (res1!=null && (long)nums[i]-res1<=t) return true;

            Long res2 = set.ceiling((long)nums[i]);
            if (res2!=null && res2-(long)nums[i]<=t) return true;

            set.add((long)nums[i]);
            if (i>=k) {
                set.remove((long)nums[i-k]);
            }

        }

        return false;

    }

}
