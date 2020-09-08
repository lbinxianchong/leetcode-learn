package com.lbin.leetcode.A002_Add_Two_Numbers;

import org.junit.Test;

public class Code {


    @Test
    public void test() {
        ListNode a = set(542);
        ListNode b = set(656);
        System.out.println(addTwoNumbers(a, b));
    }

    private ListNode set(int i) {
        if (i == 0) {
            return null;
        }
        int j = i % 10;
        return new ListNode(j, set(i / 10));
    }

    private int get(ListNode i) {
        if (i == null) {
            return 0;
        }
        return i.val + get(i.next) * 10;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return set(get(l1) + get(l2));
    }

}
