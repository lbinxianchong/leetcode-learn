package com.lbin.leetcode.A841_Keys_and_Rooms;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

public class Code2 {
    @Test
    public void test() {
        List<List<Integer>> list = new ArrayList<>();
        System.out.println(canVisitAllRooms(list));
    }

    boolean[] vls;
    int num;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
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
}
