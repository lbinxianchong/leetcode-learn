### 题目

[841. 钥匙和房间](https://leetcode-cn.com/problems/keys-and-rooms/)

有 `N` 个房间，开始时你位于 `0` 号房间。每个房间有不同的号码：`0，1，2，...，N-1`，并且房间里可能有一些钥匙能使你进入下一个房间。

在形式上，对于每个房间 `i` 都有一个钥匙列表 `rooms[i]`，每个钥匙 `rooms[i][j]` 由 `[0,1，...，N-1]` 中的一个整数表示，其中 `N = rooms.length`。 钥匙 `rooms[i][j] = v` 可以打开编号为 `v` 的房间。

最初，除 `0` 号房间外的其余所有房间都被锁住。

你可以自由地在房间之间来回走动。

如果能进入每个房间返回 `true`，否则返回 `false`。

bfs广度优先搜索

dfs深度优先搜索

### 思路

1.bfs+set

使用set特性，遍历存在所有钥匙房间

2.dfs

深度优先，递归遍历

2.bfs

广度优先，链表遍历

### 解答

#### 1.bfs+set

```java
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
```

#### 2.dfs

```
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

```

3.bfs

```
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
```

