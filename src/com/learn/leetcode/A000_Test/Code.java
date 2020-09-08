package com.learn.leetcode.A001_Two_Sum;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Code {
    @Test
    public void test() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        for (int anInt : twoSum(nums, target)) {
            System.out.println(anInt);
        }for (int anInt : twoSum2(nums, target)) {
            System.out.println(anInt);
        }for (int anInt : twoSum3(nums, target)) {
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

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int a = target - nums[i];
            if (map.get(a) != null && map.get(a) != i) {
                return new int[]{i, map.get(a)};
            }
        }
        throw new IllegalArgumentException("No twoSum");
    }

    public int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int a = target - nums[i];
            if (map.get(a) != null ) {
                return new int[]{i, map.get(a)};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No twoSum");
    }
}
