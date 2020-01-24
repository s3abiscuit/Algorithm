## 题目描述

给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 
needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

## 解法

```java
class Solution {
    public int strStr(String haystack, String needle) {
        int l1 = haystack.length(), l2 = needle.length();
        int result = 0;
        if(l2==0) return 0;
        // i是遍历haystack的下标 范围是[0, haystack.length()-needle.length()]
        for (int i = 0; i <= l1-l2; i++) {
            for (int j = 0; j<l2; j++) {
                if (haystack.charAt(i+j) != needle.charAt(j)) break;
                if (j == l2-1) return i;
            }
        }
        return -1;
    }
}
```

简略写法

```java
class Solution {
    public int strStr(String haystack, String needle) {
        int l1 = haystack.length(), l2 = needle.length();
        for (int i = 0; ; i++) {
            if (i + l2 > l1) return -1;
            for (int j = 0; ; j++) {
                if (j == l2) return i;
                if (haystack.charAt(i + j) != needle.charAt(j)) break;
            }
        }
    }
}
```
