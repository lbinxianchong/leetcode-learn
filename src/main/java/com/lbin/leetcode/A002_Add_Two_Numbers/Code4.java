package com.lbin.leetcode.A002_Add_Two_Numbers;

import org.junit.Test;

public class Code4 {


    @Test
    public void test() {
        ListNode a = ListNode.set(542);
        ListNode b = ListNode.set(656);
        System.out.println(addTwoNumbers(a, b));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        int carry = 0;
        ListNode cur = dummy;
        while (l1 != null || l2 != null || carry > 0){
            cur.next = new ListNode();
            cur = cur.next;
            if (l1 != null ){
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null ){
                carry += l2.val;
                l2 = l2.next;
            }
            cur.val = carry %10;
            carry = carry/10;
        }
        return dummy.next;
    }


}
