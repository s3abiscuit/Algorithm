## 题目描述

给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

|case|输入|输出|
|:--|:--|:--|
|1|`123`|`321`|
|2|`120`|`21`|

## 解法

需要考虑到Interger的最大值和最小值

```java
class Solution {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
```

借助于long类型

```java
class Solution {
    public int reverse(int x) {
        long res = 0;
        for (; x != 0; x /= 10)
            res = res * 10 + x % 10;
        return res > Integer.MAX_VALUE || res < Integer.MIN_VALUE ? 0 : (int) res;
    }
}
```
