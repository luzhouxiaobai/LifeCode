package org.asmoc.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {

        LinkedList<Integer> tmp = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();

        dfs(nums, 0, tmp, result);
        return result;

    }

    public void dfs(int[] nums, int index, LinkedList<Integer> tmp, List<List<Integer>> result) {
        if (index==nums.length) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        dfs(nums, index+1, tmp, result);
        tmp.add(nums[index]);
        dfs(nums, index+1, tmp, result);
        tmp.removeLast();
    }

}
