package com.learn.leetcode.Top100LikedQuestions.code;

import org.junit.Test;

public class AddTwoNumbers {

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    @Test
    public void test() {
        ListNode a = set(542);
        ListNode b = set(656);
        System.out.println(get(addTwoNumbers(a, b)));
        System.out.println(get(addTwoNumbers2(a, b)));
        System.out.println(get(addTwoNumbers3(a, b)));
        System.out.println(get(addTwoNumbers4(a, b)));
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

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
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
            if (l1.next==null){
                l1.next=new ListNode(0);
            }
            l1.next.val += 1;
        }
        return new ListNode(num, addTwoNumbers2(l1.next, l2.next));
    }

    public ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public ListNode addTwoNumbers4(ListNode l1, ListNode l2) {
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
