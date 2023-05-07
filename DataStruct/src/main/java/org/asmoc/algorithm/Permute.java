package org.asmoc.algorithm;

import java.util.LinkedList;
import java.util.List;

public class Permute {

    public List<List<Integer>> permute(int[] nums) {

        boolean[] flag = new boolean[nums.length];
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> tmp = new LinkedList<>();

        dfs(nums, flag, res, tmp);
        return res;

    }

    public void dfs(int[] nums, boolean[] flags, List<List<Integer>> res, LinkedList<Integer> tmp) {
        if (tmp.size()==nums.length) {
            res.add(new LinkedList<>(tmp));
            return;
        }
        for (int i = 0; i<nums.length; i++) {
            if ( !flags[i]) {
                flags[i] = true;
                tmp.add(nums[i]);
                dfs(nums, flags, res, tmp);
                flags[i] = false;
                tmp.removeLast();
            }

        }
    }

    public static void main(String[] args) {

        int[] nums = {1,2,3};
        Permute p = new Permute();
        p.permute(nums);

    }

}
