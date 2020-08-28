package com.learn.leetcode.Top100LikedQuestions.code;

import org.junit.Test;

public class RobotReturntoOrigin {
    @Test
    public void test() {
        System.out.println(judgeCircle("LL"));
    }

    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        char[] chars = moves.toCharArray();
        for (char aChar : chars) {
            switch (aChar) {
                case 'R':
                    x++;
                    break;
                case 'L':
                    x--;
                    break;
                case 'U':
                    y++;
                    break;
                case 'D':
                    y--;
                    break;
            }
        }
        return x == 0 && y == 0;
    }
}
