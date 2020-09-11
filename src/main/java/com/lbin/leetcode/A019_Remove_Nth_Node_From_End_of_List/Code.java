package com.lbin.leetcode.A019_Remove_Nth_Node_From_End_of_List;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * id
 * name
 */
@Slf4j
public class Code {

    @Test
    public void test() {
        ListNode listNode = ListNode.set(1, 2, 3, 4, 5);
        System.out.println(removeNthFromEnd(listNode, 1));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode listNode = head;
        int i = 1;
        map.put(i, listNode);
        i++;
        while (listNode.next != null) {
            listNode = listNode.next;
            map.put(i, listNode);
            i++;
        }
        if (map.size() - n > 0) {
            map.get(map.size() - n).next = map.get(map.size() - n + 2);
        } else if (map.size() - n == 0) {
            head = head.next;
        }
        return head;
    }
}
