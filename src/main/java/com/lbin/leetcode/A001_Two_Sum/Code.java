package com.lbin.leetcode.A001_Two_Sum;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;


@Slf4j
public class Code {
    @Test
    public void test() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        for (int anInt : twoSum(nums, target)) {
            System.out.println(anInt);
        }
    }


    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int b = nums[j];
                if ((a + b) == target) {
                    int[] t = {i, j};
                    return t;
                }
            }
        }
        throw new IllegalArgumentException("No twoSum");
    }
}
