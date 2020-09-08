package com.lbin.leetcode.A010_Regular_Expression_Matching;

import org.junit.Test;

public class Code {
    @Test
    public void test() {
        System.out.println(isMatch("mississippi", "mis*is*p*."));
    }

    public boolean isMatch(String s, String p) {
        boolean is = true;
        String[] ps = p.split("");
        String[] ss = s.split("");
        int j = 0;
        for (int i = 0; i < ps.length; i++) {

        }
        return is;
    }

}
