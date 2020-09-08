package com.lbin.leetcode.A841_Keys_and_Rooms;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

public class Code {
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

}
