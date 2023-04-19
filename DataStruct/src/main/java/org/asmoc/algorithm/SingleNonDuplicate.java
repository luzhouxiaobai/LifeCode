package org.asmoc.algorithm;

public class SingleNonDuplicate {

    public int singleNonDuplicate(int[] nums) {

        int left = 0, right = nums.length - 1;
        while (left<right) {
            int mid = (left+right) / 2;
            if (nums[mid]==nums[mid^1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

}