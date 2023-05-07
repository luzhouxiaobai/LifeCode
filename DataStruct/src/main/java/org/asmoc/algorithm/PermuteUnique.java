package org.asmoc.algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PermuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] flag = new boolean[nums.length];
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> tmp = new LinkedList<>();

        Arrays.sort(nums);

        dfs(nums, flag, res, tmp);
        return res;
    }

    public void dfs(int[] nums, boolean[] flag, List<List<Integer>> res, LinkedList<Integer> tmp) {
        if (tmp.size()==nums.length) {
            res.add(new LinkedList<>(tmp));
            return;
        }
        for (int i=0; i<nums.length; i++) {
            if (flag[i] || (i>0 && !flag[i-1] && nums[i]==nums[i-1]))
                continue;
            flag[i] = true;
            tmp.add(nums[i]);
            dfs(nums, flag, res, tmp);
            flag[i] = false;
            tmp.removeLast();
        }
    }

    public static void main(String[] args) {

        int[] nums = {1,2,3};
        PermuteUnique p = new PermuteUnique();
        p.permuteUnique(nums);

    }

}
