package com.lbin.leetcode.A017_Letter_Combinations_of_a_Phone_Number;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * id
 * name
 */
@Slf4j
public class Code {

    @Test
    public void test() {
        System.out.println(letterCombinations("23"));
    }

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits.length() == 0) {
            return list;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        list.add("");
        for (int i = 0; i < digits.length(); i++) {
            char c = digits.charAt(i);
            String phone = phoneMap.get(c);
            List<String> newlist = new ArrayList<>();
            for (String s : list) {
                for (int j = 0; j < phone.length(); j++) {
                    char charAt = phone.charAt(j);
                    newlist.add(s + charAt);
                }
            }
            list = newlist;
        }
        return list;

    }

}
