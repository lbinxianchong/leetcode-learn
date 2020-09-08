### 题目

#### [257. 二叉树的所有路径](https://leetcode-cn.com/problems/binary-tree-paths/)

给定一个二叉树，返回所有从根节点到叶子节点的路径。

**说明:** 叶子节点是指没有子节点的节点。

### 思路

1.dfs深度优先搜索

最直观的方法是使用深度优先搜索。在深度优先搜索遍历二叉树时，我们需要考虑当前的节点以及它的孩子节点。

2.bfs广度优先搜索



### 解答

```
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
```

```
	public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<String>();
        constructPaths(root, "", paths);
        return paths;
    }

    public void constructPaths(TreeNode root, String path, List<String> paths) {
        if (root != null) {
            StringBuffer pathSB = new StringBuffer(path);
            pathSB.append(root.val);
            if (root.left == null && root.right == null) {  // 当前节点是叶子节点
                paths.add(pathSB.toString());  // 把路径加入到答案中
            } else {
                pathSB.append("->");  // 当前节点不是叶子节点，继续递归遍历
                constructPaths(root.left, pathSB.toString(), paths);
                constructPaths(root.right, pathSB.toString(), paths);
            }
        }
    }
```

