package com.lbin.leetcode.A019_Remove_Nth_Node_From_End_of_List;


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

    public static ListNode set(int... i) {
        return new ListNode(i[0], set(1, i));
    }

    private static ListNode set(int n, int... i) {
        if (i.length > n) {
            return new ListNode(i[n], set(n + 1, i));
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        if (this.next == null) {
            return String.valueOf(this.val);
        }
        return this.val + this.next.toString();
    }
}
