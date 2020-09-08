package com.lbin.leetcode.A841_Keys_and_Rooms;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

public class Code3 {
    @Test
    public void test() {
        List<List<Integer>> list = new ArrayList<>();
        System.out.println(canVisitAllRooms(list));
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size(), num = 0;
        boolean[] vis = new boolean[n];

        LinkedList<Integer> que = new LinkedList<Integer>();
        vis[0] = true;
        que.offer(0);
        while (!que.isEmpty()) {
            int x = que.poll();
            num++;
            for (int it : rooms.get(x)) {
                if (!vis[it]) {
                    vis[it] = true;
                    que.offer(it);
                }
            }
        }
        return n == num;
    }

}
