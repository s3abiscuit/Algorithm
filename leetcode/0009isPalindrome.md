## 题目描述

判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

|case|输入|输出|
|:--|:--|:--|
|1|`121`|`true`|
|2|`10`|`false`|

## 解法
```java
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        String str = "";
        while (x/10 != 0) {
            str += x%10;
            x=x/10;
        }
        str += x;
        System.out.println(str);
        int N = str.length();
        for (int i = 0; i < N/2; i++) {
            if (str.charAt(i) != str.charAt(N-1-i)) return false;
        }
        return true;
    }
}
```

优化

```java
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        String str = "";
        while (x != 0) {
            str += x%10;
            x=x/10;
        }
        int N = str.length();
        for (int i = 0; i < N/2; i++) {
            if (str.charAt(i) != str.charAt(N-1-i)) return false;
        }
        return true;
    }
}
```

优化二

```java
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int copyX = x, reverse = 0;
        while (copyX > 0) {
            reverse = reverse * 10 + copyX % 10;
            copyX /= 10;
        }
        return x == reverse;
    }
}
```

优化三

遍历一半, 但是要注意10010这类以0结尾的数

```java
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) return false;
        int halfReverseX = 0;
        while (x > halfReverseX) {
            halfReverseX = halfReverseX * 10 + x % 10;
            x /= 10;
        }
        return halfReverseX == x || halfReverseX / 10 == x;
    }
}
```
