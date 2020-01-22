## 题目描述

假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

|case|输入|输出|
|:--|:--|:--|
|1|`1`|`1`|
|2|`2`|`2`|
|3|`3`|`3`|
|4|`4`|`5`|
|5|`6`|`8`|

## 解法

使用递归的话到第33个数就会超时, 所以要改为循环

```java
class Solution {
    public int climbStairs(int n) {
        if (n==1) return 1;
        if (n==2) return 2;
        int a = 1, b = 2,  result=0;
        while(n-->0){
            result = a+b;
            a = b;
            b = result;
            if (n==2) break;
        }
        return result;
    }
}
```

优化: 只是用两个变量

```java
class Solution {
    public int climbStairs(int n) {
        int a = 1, b = 1;
        while (--n > 0) {
            b += a;
            a = b - a;
        }
        return b;
    }
}
```
