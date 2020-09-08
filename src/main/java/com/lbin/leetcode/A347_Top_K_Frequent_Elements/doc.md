### 题目

#### [347. 前 K 个高频元素](https://leetcode-cn.com/problems/top-k-frequent-elements/)

给定一个非空的整数数组，返回其中出现频率前 **k** 高的元素。

### 思路

1.暴力法

map数值计算各个数出现次数，k遍历map数值最大次数，删除上一个数值

### 解答

```
public int[] topKFrequent(int[] nums, int k) {
        int[] maxnums = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer integer = map.get(num);
            if (integer == null) {
                map.put(num, 1);
            } else {
                map.put(num, integer + 1);
            }
        }
        for (int i = 0; i < k; i++) {
            int max = 0;
            int key = 0;
            for (Integer integer : map.keySet()) {
                Integer v = map.get(integer);
                if (max < v) {
                    max = v;
                    key = integer;
                }
            }
            map.remove(key);
            maxnums[i] = key;
        }
        return maxnums;
    }
```

