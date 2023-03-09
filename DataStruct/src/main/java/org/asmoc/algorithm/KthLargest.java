package org.asmoc.algorithm;

import java.util.PriorityQueue;

public class KthLargest {

    PriorityQueue<Integer> heap ;
    int size;

    public KthLargest(int k, int[] nums) {

        size = k;
        heap = new PriorityQueue<>();
        for (int num: nums) {
            add(num);
        }

    }

    public int add(int val) {

        if(heap.size()<size) heap.offer(val);
        else {
            if (heap.peek()<val)  {
                heap.poll();
                heap.offer(val);
            }
        }
        return heap.peek();

    }

}
