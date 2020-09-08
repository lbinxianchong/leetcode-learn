package com.lbin.leetcode.A486_Predict_the_Winner;

import org.junit.Test;

public class Code2 {
    @Test
    public void test() {
        int[] ints = {1, 5, 2};
        System.out.println(PredictTheWinner(ints));
    }

    public boolean PredictTheWinner(int[] nums) {
        int length = nums.length;
        int[][] ints = new int[length][length];
        for (int i = 0; i < nums.length; i++) {
            ints[i][i] = nums[i];
        }
        for (int i = length - 2; i > 0; i--) {
            for (int j = i + 1; j < length; j++) {
                int a = nums[i] - ints[i + 1][j];
                int b = nums[j] - ints[i][j - 1];
                if (a > b) {
                    ints[i][j] = a;
                } else {
                    ints[i][j] = b;
                }
            }
        }
        return ints[0][length - 1] > 0;
    }

    public boolean PredictTheWinner2(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        for (int i = 0; i < length; i++) {
            dp[i] = nums[i];
        }
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
            }
        }
        return dp[length - 1] >= 0;
    }


}
