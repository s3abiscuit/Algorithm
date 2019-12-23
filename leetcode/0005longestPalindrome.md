## 题目描述

输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。

## 解法

```java
class Solution {
    public String longestPalindrome(String s) {
        int size =  s.length();
        int result = 1;
        int start = 0, end = 0;
        if (size==0) return "";
        for (int i = 0; i < size; i++) {
            int before = i-1, after = i+1, tempMax = 1;
            int before1 = i, after1 = i+1, tempMax1 = 0;
            while (before >= 0 && after < size) {
                if (s.charAt(before) == s.charAt(after)) {
                    tempMax +=2;
                    before--;
                    after++;
                }
                else break;
            }
            while (before1>=0 && after1<size) {
                if (s.charAt(before1) == s.charAt(after1)) {
                    tempMax1 += 2;
                    before1--;
                    after1++;
                } else break;
            }
            if (tempMax>result) {
                result = tempMax;
                start = before+1;
                end = after-1;
            }
            if (tempMax1>result) {
                result = tempMax1;
                start = before1+1;
                end = after1-1;
            }
        }
        return s.substring(start, end+1);
    }
}
```
