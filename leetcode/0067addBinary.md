## 题目描述

给定两个二进制字符串，返回他们的和（用二进制表示）。

输入为非空字符串且只包含数字 1 和 0。


|case|输入|输出|
|:--|:--|:--|
|1|`"11", "1"`|`"100"`|
|2|`"1010", "1011"`|`"10101"`|



## 解法

```java
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0, p1 = a.length() - 1, p2 = b.length() - 1;
        while (p1 >= 0 && p2 >= 0) {
            carry += a.charAt(p1--) - '0';
            carry += b.charAt(p2--) - '0';
            sb.insert(0, (char) (carry % 2 + '0'));
            carry >>= 1;
        }
        while (p1 >= 0) {
            carry += a.charAt(p1--) - '0';
            sb.insert(0, (char) (carry % 2 + '0'));
            carry >>= 1;
        }
        while (p2 >= 0) {
            carry += b.charAt(p2--) - '0';
            sb.insert(0, (char) (carry % 2 + '0'));
            carry >>= 1;
        }
        if (carry == 1) {
            sb.insert(0, '1');
        }
        return sb.toString();
    }
}
```
