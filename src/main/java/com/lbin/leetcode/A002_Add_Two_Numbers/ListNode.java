package com.lbin.leetcode.A002_Add_Two_Numbers;


public class ListNode {
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

    public static ListNode set(int i) {
        if (i == 0) {
            return null;
        }
        int j = i % 10;
        return new ListNode(j, set(i / 10));
    }

    public Integer get() {
        return get(this);
    }

    private int get(ListNode i) {
        if (i == null) {
            return 0;
        }
        return i.val + get(i.next) * 10;
    }

    @Override
    public String toString() {
        return get().toString();
    }
}
