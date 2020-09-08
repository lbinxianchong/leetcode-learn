package com.lbin.leetcode.A347_Top_K_Frequent_Elements;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * id
 * name
 */
@Slf4j
public class Code {

    @Test
    public void test() {
        int[] ints=new int[]{1,1,1,2,2,3,3,3};
        for (int i : topKFrequent(ints, 2)) {
            System.out.println(i);
        }

    }

    public int[] topKFrequent(int[] nums, int k) {
        int[] maxnums = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer integer = map.get(num);
            if (integer == null) {
                map.put(num, 1);
            } else {
                map.put(num, integer + 1);
            }
        }
        for (int i = 0; i < k; i++) {
            int max = 0;
            int key = 0;
            for (Integer integer : map.keySet()) {
                Integer v = map.get(integer);
                if (max < v) {
                    max = v;
                    key = integer;
                }
            }
            map.remove(key);
            maxnums[i] = key;
        }
        return maxnums;
    }
}
