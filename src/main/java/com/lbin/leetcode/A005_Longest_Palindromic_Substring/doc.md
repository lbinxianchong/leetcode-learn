### 题目

#### [5. 最长回文子串](https://leetcode-cn.com/problems/longest-palindromic-substring/)

难度中等2652收藏分享切换为英文关注反馈英文版讨论区

给定一个字符串 `s`，找到 `s` 中最长的回文子串。你可以假设 `s` 的最大长度为 1000。

### 思路

1.暴力法

考虑所有可能性

### 解答

1.暴力破解

```java
	public String longestPalindrome(String s) {
        String max = "";
        String[] split = s.split("");
        String temp = "" + split;
        for (int i = 0; i < split.length - 1; i++) {
            for (int j = i; j < split.length; j++) {
                if (max.length() < j - i + 1) {
                    int a = i;
                    int b = j;
                    boolean e = true;
                    while (a < b) {
                        if (!split[a].equals(split[b])) {
                            e = false;
                            break;
                        }
                        a++;
                        b--;
                    }
                    if (e) {
                        max = s.substring(i, j+1);
                    }
                }
            }
        }
        return max;
    }
```