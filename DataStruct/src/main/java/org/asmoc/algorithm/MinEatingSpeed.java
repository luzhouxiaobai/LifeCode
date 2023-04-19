package org.asmoc.algorithm;

public class MinEatingSpeed {

    public int minEatingSpeed(int[] piles, int h) {

        int left = 1, right = Integer.MIN_VALUE;
        for (int tok: piles) {
            right = Math.max(right, tok);
        }

        while (left<right) {
            int mid = (left+right) / 2;
            if (getH(piles, mid, h)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;

    }

    public boolean getH(int[] piles, int speed, int h) {
        int sum = 0;
        for (int tok: piles) {
            if (tok % speed==0) {
                sum += (tok / speed);
            } else {
                sum += (tok / speed) + 1;
            }
        }
        if (sum <= h) return true;
        return false;
    }

}
