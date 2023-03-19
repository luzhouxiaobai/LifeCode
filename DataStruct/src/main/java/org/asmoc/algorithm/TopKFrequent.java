package org.asmoc.algorithm;

import java.util.*;

public class TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> hmap = new HashMap<>();
        for (int num: nums) hmap.put(num, hmap.getOrDefault(num, 0) + 1);

        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((e1, e2) -> e1.getValue()-e2.getValue());
        for (Map.Entry<Integer, Integer> entry: hmap.entrySet()) {
            if (heap.size()<k) heap.offer(entry);
            else {
                if (heap.peek().getValue() < entry.getValue()) {
                    heap.poll();
                    heap.offer(entry);
                }
            }
        }

        int[] list = new int[heap.size()];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry: heap) {
            list[i++] = entry.getKey();
        }
        return list;

    }

}
