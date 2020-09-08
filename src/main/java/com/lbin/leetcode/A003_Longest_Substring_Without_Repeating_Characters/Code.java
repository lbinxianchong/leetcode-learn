package com.lbin.leetcode.A003_Longest_Substring_Without_Repeating_Characters;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class Code {
    @Test
    public void test() {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        String max = "";
        String temp = "";
        String[] split = s.split("");
        for (int i = 0; i < split.length; i++) {
            int indexOf = temp.indexOf(split[i]);
            if (indexOf > -1) {
                temp = temp.substring(indexOf + 1);
            }
            temp += split[i];
            if (temp.length() > max.length()) {
                max = temp;
            }
        }
//        System.out.println(max);
        return max.length();
    }
}
