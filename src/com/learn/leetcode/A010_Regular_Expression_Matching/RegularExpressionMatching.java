package com.learn.leetcode.Top100LikedQuestions.code;

import org.junit.Test;

public class RegularExpressionMatching {
    @Test
    public void test() {

    }

    public boolean isMatch(String s, String p) {
        boolean is = true;
        String[] ps = p.split("");
        String[] ss = s.split("");
        int j = 0;
        for (int i = 0; i < ps.length; i++) {
            String pa = ps[i];
            String sa = ss[j];
            if (pa.equals(sa)) {
                j++;
            }else {
                if (pa.equals(".")){

                }
            }
        }
        return is;

    }
    public boolean isMatch2(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                }
                else {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }

    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

}
