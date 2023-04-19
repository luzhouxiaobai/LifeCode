package org.asmoc.algorithm;

import java.util.Random;

public class FindKthLargest {

    public int findKthLargest(int[] nums, int k) {

        int left = 0, right = nums.length-1;
        int index = partition(nums, left, right);
        while (index != nums.length-k) {
            if (index > nums.length-k) {
                index = partition(nums, left, index-1);
            } else {
                index = partition(nums, index+1, right);
            }
        }
        return nums[index];
    }

    public int partition(int[] nums, int left, int right) {
        int pos = left, posV = nums[left];
        int i = left + 1;
        for (; i<=right; i++) {
            if (nums[i]<posV) {
                pos++;
                if (i != pos) {
                    swap(nums, i, pos);
                }
            }
        }
        swap(nums, pos, left);
        return pos;
    }

    public void swap(int[] nums, int left, int right) {
        int val = nums[left];
        nums[left] = nums[right];
        nums[right] = val;
    }

}
