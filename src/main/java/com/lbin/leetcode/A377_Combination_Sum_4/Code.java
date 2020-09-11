package com.lbin.leetcode.A377_Combination_Sum_4;


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
        int[] ints = new int[]{1, 2, 3};
        System.out.println(combinationSum4(ints, 4));
    }
    public int combinationSum4(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> combine = new ArrayList<Integer>();
        dfs(candidates, target, ans, combine);
        return ans.size();
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            ans.add(new ArrayList<>(combine));
            return;
        } else {
            for (int i = 0; i < candidates.length; i++) {
                combine.add(candidates[i]);
                dfs(candidates, target - candidates[i], ans, combine);
                combine.remove(combine.size() - 1);
            }
        }


    }


}
