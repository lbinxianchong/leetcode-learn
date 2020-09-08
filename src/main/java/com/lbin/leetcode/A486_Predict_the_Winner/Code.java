package com.lbin.leetcode.A486_Predict_the_Winner;

import org.junit.Test;

public class Code {
    @Test
    public void test() {
        int[] ints = {1, 5, 2};
        System.out.println(PredictTheWinner(ints));
    }

    public boolean PredictTheWinner(int[] nums) {
        return to(nums, 0, nums.length - 1, 1) >= 0;
    }

    public int to(int[] nums, int i, int j, int num) {
        if (i == j) {
            return nums[i] * num;
        }
        int a = nums[i] * num + to(nums, i + 1, j, -num);
        int b = nums[j] * num + to(nums, i, j - 1, -num);
        if (a * num > b * num) {
            return a;
        } else {
            return b;
        }
    }




}
