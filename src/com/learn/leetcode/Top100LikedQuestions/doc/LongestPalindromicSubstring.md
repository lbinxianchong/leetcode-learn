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