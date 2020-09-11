package com.lbin.leetcode.A015_3Sum;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * id
 * name
 */
@Slf4j
public class Code2 {

    @Test
    public void test() {
        int[] ints=new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(ints));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists=new ArrayList<>();
        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i+1; j < nums.length-1; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    if (nums[i]+nums[j]+nums[k]==0){
                        List<Integer> list=new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        lists.add(list);
                        break;
                    }
                }
            }
        }
        return lists;
    }
}
