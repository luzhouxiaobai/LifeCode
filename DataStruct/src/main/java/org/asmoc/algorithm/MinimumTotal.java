package org.asmoc.algorithm;
import java.util.List;
import java.util.ArrayList;

public class MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size()==0) return 0;
        List<List<Integer>> result = new ArrayList<>();
        for (int i=0; i<triangle.size(); i++) {
            List<Integer> tmp = new ArrayList<>();
            List<Integer> tok = triangle.get(i);
            for (int j=0; j<tok.size(); j++) {
                if (i==0) {
                    tmp.add(tok.get(j));
                } else {
                    int left = 0, right = 0;
                    int lastSize = triangle.get(i-1).size();
                    right = j<lastSize ? result.get(i-1).get(j) : 0;
                    left = j-1 >0 ? result.get(i-1).get(j-1):0;
                    tmp.add(Math.min(left, right) + tok.get(j));
                }
            }
            result.add(new ArrayList<>(tmp));
        }
        int res = Integer.MAX_VALUE;
        for (int i=0; i<result.get(result.size()-1).size(); i++) {
            res = Math.min(res, result.get(result.size()-1).get(i));
        }
        return res;
    }
}