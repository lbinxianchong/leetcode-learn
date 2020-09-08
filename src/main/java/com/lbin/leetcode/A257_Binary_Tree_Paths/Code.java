package com.lbin.leetcode.A257_Binary_Tree_Paths;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * id
 * name
 */
@Slf4j
public class Code {

    @Test
    public void test() {

    }

    List<String> list;

    public List<String> binaryTreePaths(TreeNode root) {
        list = new ArrayList<>();
        bi(root, String.valueOf(root.val));
        return list;
    }

    private void bi(TreeNode root, String valueOf) {
        String v = valueOf + "->" + root.val;
        if (root.left == null && root.right == null) {
            list.add(v);
        }
        if (root.left != null) {
            bi(root.left, v);
        }
        if (root.right != null) {
            bi(root.right, v);
        }
    }




}
