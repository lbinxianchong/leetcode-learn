### 题目

#### [486. 预测赢家](https://leetcode-cn.com/problems/predict-the-winner/)

给定一个表示分数的非负整数数组。 玩家 1 从数组任意一端拿取一个分数，随后玩家 2 继续从剩余数组任意一端拿取分数，然后玩家 1 拿，…… 。每次一个玩家只能拿取一个分数，分数被拿取之后不再可取。直到没有剩余分数可取时游戏结束。最终获得分数总和最多的玩家获胜。

给定一个表示分数的数组，预测玩家1是否会成为赢家。你可以假设每个玩家的玩法都会使他的分数最大化。

### 思路

1.递归

递归考虑所有可能性，奇数为正，偶数为负，遍历所有得出最大数

2.动态规划

动态规划，先从2位开始，考虑先手最大值，加入1位，3位。。。。。。到最大位数，无论哪位都考虑位数最大值，减去上一次位数最大值

[i+1,j]-max[i,j]

[i,j+1]-max[i,j]

参考

定义二维数组 \textit{dp}dp，其行数和列数都等于数组的长度，\textit{dp}[i][j]dp[i][j] 表示当数组剩下的部分为下标 ii 到下标 jj 时，当前玩家与另一个玩家的分数之差的最大值，注意当前玩家不一定是先手。

只有当 i \le ji≤j 时，数组剩下的部分才有意义，因此当 i>ji>j 时，\textit{dp}[i][j]=0dp[i][j]=0。

当 i=ji=j 时，只剩一个数字，当前玩家只能拿取这个数字，因此对于所有 0 \le i < \textit{nums}.\text{length}0≤i<nums.length，都有 \textit{dp}[i][i]=\textit{nums}[i]dp[i][i]=nums[i]。

当 i<ji<j 时，当前玩家可以选择 \textit{nums}[i]nums[i] 或 \textit{nums}[j]nums[j]，然后轮到另一个玩家在数组剩下的部分选取数字。在两种方案中，当前玩家会选择最优的方案，使得自己的分数最大化。因此可以得到如下状态转移方程：

### 解答

1.递归

```java
	public boolean PredictTheWinner(int[] nums) {
        return to(nums, 0, nums.length - 1, 1) >= 0;
    }

    public int to(int[] nums, int i, int j, int num) {
        if (i == j) {
            return nums[i] * num;
        }
        int a = nums[i] * num + to(nums, i + 1, j, -num);
        int b = nums[j] * num + to(nums, i, j - 1, -num);
        if (a * num > b * num) {
            return a;
        } else {
            return b;
        }
    }
```

2.动态规划

```java
	public boolean PredictTheWinner(int[] nums) {
        int length = nums.length;
        int[][] ints = new int[length][length];
        for (int i = 0; i < nums.length; i++) {
            ints[i][i] = nums[i];
        }
        for (int i = length - 2; i > 0; i--) {
            for (int j = i + 1; j < length; j++) {
                int a = nums[i] - ints[i + 1][j];
                int b = nums[j] - ints[i][j - 1];
                if (a > b) {
                    ints[i][j] = a;
                } else {
                    ints[i][j] = b;
                }
            }
        }
        return ints[0][length - 1] > 0;
    }

    public boolean PredictTheWinner2(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        for (int i = 0; i < length; i++) {
            dp[i] = nums[i];
        }
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
            }
        }
        return dp[length - 1] >= 0;
    }
```