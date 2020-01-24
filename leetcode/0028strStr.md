## 题目描述

给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 
needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

## 解法

```java
class Solution {
    public int strStr(String haystack, String needle) {
        int sizeHS = haystack.length();
        int sizeND = needle.length();

        if (sizeHS == 0 && sizeND == 0) return 0;
        if (sizeHS == 0 && sizeND > 0) return -1;
        if (sizeHS > 0 && sizeND == 0) return 0;
        int result = 0;
        char temp = needle.charAt(0);
        // i是遍历haystack的下标 范围是[0, haystack.length()-needle.length()]
        for (int i = 0; i <= sizeHS-sizeND; i++) {
            
            if (temp == haystack.charAt(i)) {
                result = i;
                int j = 1;
                while (j<sizeND) {
                    if (needle.charAt(j) != haystack.charAt(i+j)) {
                        break;
                    }
                    j++;
                }
                if (j == sizeND && needle.charAt(j-1) == haystack.charAt(i+j-1)) 
                    return result;
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
