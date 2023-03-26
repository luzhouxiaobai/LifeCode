package org.asmoc.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class KSmallestPairs {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        PriorityQueue<int[]> heap = new PriorityQueue<>((p1, p2) -> p2[0] + p2[1] - p1[0] - p1[1]);

        int iMax = Math.min(k, nums1.length);
        int jMax = Math.min(k, nums2.length);
        for (int i=0; i<iMax; i++) {
            for (int j=0; j<jMax; j++) {
                if (heap.size()<k) heap.offer(new int[] {nums1[i], nums2[j]});
                else {
                    if (nums1[i]+nums2[j] >= heap.peek()[0] + heap.peek()[1]) continue;
                    else {
                        heap.poll();
                        heap.offer(new int[] {nums1[i], nums2[j]});
                    }
                }
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        while (!heap.isEmpty()) {
            int[] val = heap.poll();
            res.add(Arrays.asList(val[0], val[1]));
        }
        return res;

    }

}
