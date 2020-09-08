### 题目

#### [1. 两数之和](https://leetcode-cn.com/problems/two-sum/)

给定一个整数数组 `nums` 和一个目标值 `target`，请你在该数组中找出和为目标值的那 **两个** 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

### 思路

1.暴力冒泡

遍历所有元素相加，找到为止

2.两遍哈希表

遍历所有元素的值和它的索引添加到表中，遍历元素,判断target-x存在于表中

3.一遍哈希表

跟两遍哈希表差不多，判断后把元素的值和它的索引添加到表中

### 解答

#### 1.暴力法(冒泡)

```java
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int b = nums[j];
                if ((a + b) == target) {
                    int[] t = {i, j};
                    return t;
                }
            }
        }
        throw new IllegalArgumentException("No twoSum");
    }
```

#### 2.两遍哈希表

```java
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int a = target - nums[i];
            if (map.get(a) != null && map.get(a) != i) {
                return new int[]{i, map.get(a)};
            }
        }
        throw new IllegalArgumentException("No twoSum");
    }
```

#### 3.一遍哈希表

```java
    public int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int a = target - nums[i];
            if (map.get(a) != null ) {
                return new int[]{i, map.get(a)};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No twoSum");
    }
```