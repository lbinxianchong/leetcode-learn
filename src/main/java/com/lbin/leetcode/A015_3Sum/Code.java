package com.lbin.leetcode.A015_3Sum;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * id
 * name
 */
@Slf4j
public class Code {

    @Test
    public void test() {
        int[] ints = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(ints));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> nlist = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (nums[j] + nums[k] < -nums[i]) {
                    j++;
                } else if (nums[j] + nums[k] > -nums[i]) {
                    k--;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    nlist.add(list);
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }

                    while (j < k && k != nums.length - 1 && nums[k] == nums[k + 1]) {
                        k--;
                    }
                }
            }

        }

        return nlist;
    }

}
