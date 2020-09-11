package com.lbin.leetcode.A216_Combination_Sum_3;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * id
 * name
 */
@Slf4j
public class Code {

    @Test
    public void test() {
        System.out.println(combinationSum3(3, 9));
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> combine = new ArrayList<Integer>();
        dp(ans, combine, k, n, 0);
        return ans;
    }

    private void dp(List<List<Integer>> ans, List<Integer> combine, int k, int n, int index) {
        if (n == 0 && k == 0) {
            ans.add(new ArrayList<>(combine));
            return;
        }
        if (n > 0) {
            for (int i = index + 1; i < 10; i++) {
                combine.add(i);
                dp(ans, combine, k - 1, n - i, i);
                combine.remove(combine.size() - 1);
            }
        }
    }


}
