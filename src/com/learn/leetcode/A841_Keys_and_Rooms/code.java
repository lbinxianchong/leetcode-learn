package com.learn.leetcode.Top100LikedQuestions;

import org.junit.Test;

import java.util.*;

public class code {
    @Test
    public void test() {
        List<List<Integer>> list = new ArrayList<>();
        System.out.println(canVisitAllRooms(list));
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        List<Integer> list = rooms.get(0);
        set.addAll(list);
        for (Integer integer : set) {
            list = rooms.get(integer);
            set.addAll(list);
        }
        return set.size() == rooms.size();
    }

    boolean[] vls;
    int num;

    public boolean canVisitAllRooms2(List<List<Integer>> rooms) {
        int size = rooms.size();
        vls = new boolean[size];
        dtf(rooms, 0);
        return size == num;
    }

    private void dtf(List<List<Integer>> rooms, int i) {
        num++;
        vls[i] = true;
        List<Integer> list = rooms.get(i);
        for (Integer integer : list) {
            if (!vls[integer]) {
                vls[integer] = true;
                num++;
                dtf(rooms, i);
            }
        }
    }

    public boolean canVisitAllRooms3(List<List<Integer>> rooms) {
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
