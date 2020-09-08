package com.lbin.leetcode.A002_Add_Two_Numbers;

import org.junit.Test;

public class Code2 {

    @Test
    public void test() {
        ListNode a = ListNode.set(542);
        ListNode b = ListNode.set(656);
        System.out.println(addTwoNumbers(a, b));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        } else {
            if (l1 == null) {
                l1 = new ListNode(0);
            } else if (l2 == null) {
                l2 = new ListNode(0);
            }
        }
        int num = l1.val + l2.val;
        if (num > 10) {
            num = num % 10;
            if (l1.next == null) {
                l1.next = new ListNode(0);
            }
            l1.next.val += 1;
        }
        return new ListNode(num, addTwoNumbers(l1.next, l2.next));
    }
}
