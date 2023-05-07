package org.asmoc.algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        LinkedList<Integer> tmp = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();

        help(candidates, target, 0, tmp, res);

        return res;

    }

    public void help(int[] nums, int target, int index, LinkedList<Integer> tmp, List<List<Integer>> res) {

        if (target==0) {
            res.add(new LinkedList<>(tmp));
            return;
        }

        int i = index;

        while (i < nums.length) {

            if (target - nums[i] >= 0) {
                tmp.add(nums[i]);
                help(nums, target-nums[i], i+1, tmp, res);
                tmp.removeLast();
            } else {
                break;
            }

            int j = i;
            while (j< nums.length && nums[j]==nums[i])  j++;
            i = j;
        }

    }

    public static void main(String[] args) {
        int[] nums = {10,1,2,7,6,1,5};
        CombinationSum2 c = new CombinationSum2();
        List<List<Integer>> res = c.combinationSum2(nums, 8);
        System.out.println(res.toString());
    }

}
