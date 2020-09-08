package com.lbin.leetcode.A001_Two_Sum;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Code2 {
    @Test
    public void test() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        for (int anInt : twoSum(nums, target)) {
            System.out.println(anInt);
        }
    }

    public int[] twoSum(int[] nums, int target) {
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

}
