package org.asmoc.algorithm;

public class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        int[] nums = new int[cost.length];
        if (cost.length<2) return 0;
        nums[0] = cost[0];
        nums[1] = cost[1];

        for (int i=2; i<nums.length; i++) {
            nums[i] = Math.min(nums[i-1], nums[i-2]) + cost[i];
        }
        return Math.min(nums[nums.length-1], nums[nums.length-2]);
    }

    public static void main(String[] args) {
        int[] n = {1,100,1,1,1,100,1,1,100,1};
        MinCostClimbingStairs ms = new MinCostClimbingStairs();
        int res = ms.minCostClimbingStairs(n);
        System.out.println(res);
    }

}
