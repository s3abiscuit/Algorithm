## 题目描述

计算并返回 x 的平方根，其中 x 是非负整数。

由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

|case|输入|输出|
|:--|:--|:--|
|1|`4`|``1|

## 解法

使用牛顿迭代法

```java
class Solution {
    public int mySqrt(int x) {
        long n = x;
        while (n * n > x) {
            n = (n + x / n) >> 1;
        }
        return (int) n;
    }
}
```
