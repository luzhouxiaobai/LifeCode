package org.asmoc.algorithm;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        LinkedList<Integer> tmp = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();

        help(candidates, target, 0, tmp, result);
        return result;
    }

    public void help(int[] nums, int target, int i, LinkedList<Integer> tmp, List<List<Integer>> result) {

        if (target==0) {
            result.add(new LinkedList<>(tmp));
        } else if (target > 0 && i < nums.length) {

            help(nums, target, i+1, tmp, result);
            tmp.add(nums[i]);
            help(nums, target-nums[i], i, tmp, result);
            tmp.removeLast();

        }

    }

}
