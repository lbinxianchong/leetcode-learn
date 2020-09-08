package com.lbin.leetcode.B020_isNumbe;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * id
 * name
 */
@Slf4j
public class Code {

    @Test
    public void test() {

    }

    public boolean isNumber(String s) {
        if(s.endsWith("f")||s.endsWith("D")) return false;
        try {
            Double.valueOf(s);
            return true;
        }catch (Exception ex){
            return false;
        }
    }



}
