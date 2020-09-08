package com.lbin.leetcode.A011_Container_With_Most_Water;

import org.junit.Test;

public class Code {
    @Test
    public void test() {
        int[] ints = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(ints));
    }

    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int a = height[i] < height[j] ? height[i] : height[j];
                if (a * (j - i) > max) {
                    max = a * (j - i);
                }
            }
        }
        return max;
    }
}
