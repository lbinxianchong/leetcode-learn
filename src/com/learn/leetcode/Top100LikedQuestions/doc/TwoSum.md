#### 方法一：暴力法(冒泡)

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

#### 方法二：两遍哈希表

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

#### 方法三：一遍哈希表

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