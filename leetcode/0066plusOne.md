## 题目描述

给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

你可以假设除了整数 0 之外，这个整数不会以零开头。


|case|输入|输出|
|:--|:--|:--|
|1|`[1,2,3]`|`[1,2,4]`|
|2|`[9,9,9]`|`[1,0,0,0]`|



## 解法

```java
class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int tmp = len;
        while (--len>=0) {
            if (digits[len]+1<10) {
                digits[len] += 1;
                return digits;
            }
            digits[len] = 0;
            if (len==0) {
                int[] result = new int[tmp+1];
                // 下面一行代码可以不需要, 初始值为0
                // while (--tmp>=0) result[tmp] = digits[tmp];
                result[0] = 1;
                return result;
            }
        }
        return digits;
    }
}
```


改进

```java
class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        while (--len>=0) {
            if (digits[len]+1<10) {
                digits[len] += 1;
                break;
            }
            digits[len] = 0;
            if (len==0) {
                digits = new int[digits.length+1];
                digits[0] = 1;
                break;
            }
        }
        return digits;
    }
}
```
