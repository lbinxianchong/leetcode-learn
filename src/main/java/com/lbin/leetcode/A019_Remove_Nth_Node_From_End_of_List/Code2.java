package com.lbin.leetcode.A019_Remove_Nth_Node_From_End_of_List;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * id
 * name
 */
@Slf4j
public class Code2 {

    @Test
    public void test() {
        ListNode listNode = ListNode.set(1,2,3,4,5);
        System.out.println(removeNthFromEnd(listNode, 2));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 2) {
            if (head.next != null && head.next.next != null) {
                head.next = head.next.next;
            }
        }
        if (head.next!=null){
            removeNthFromEnd(head.next, n - 1);
        }
        return head;
    }
}
