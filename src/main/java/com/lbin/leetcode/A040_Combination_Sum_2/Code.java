package com.lbin.leetcode.A040_Combination_Sum_2;


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
        int[] ints = new int[]{10, 1, 2,1, 7, 6, 1, 5};
        System.out.println(combinationSum2(ints, 8));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> combine = new ArrayList<Integer>();
        Arrays.sort(candidates);
        dfs(candidates, target, ans, combine, 0);
        return ans;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int index) {
        if (target == 0) {
            ans.add(new ArrayList<>(combine));
            return;
        } else if (target > 0) {
            for (int i = index; i < candidates.length; i++) {
                if (i > index && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                combine.add(candidates[i]);
                dfs(candidates, target-candidates[i], ans, combine, i + 1);
                combine.remove(combine.size() - 1);
            }
        }
    }


}
