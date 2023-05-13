package org.asmoc.algorithm;

public class RobII {
    public int rob(int[] nums) {
        if (nums.length==0) return 0;
        if (nums.length==1) return nums[0];
        if (nums.length==2) return Math.max(nums[0], nums[1]);
        int a = help(nums, 0, nums.length-1);
        int b = help(nums, 1, nums.length);
        return Math.max(a, b);
    }

    public int help(int[] nums, int start, int end) {
        int f0 = nums[start];
        int f1 = Math.max(nums[start+1], nums[start]);
        for (int i=start+2; i<end; i++) {
            int f = Math.max(f0+nums[i], f1);
            f0 = f1;
            f1 = f;
        }
        return f1;
    }
}
