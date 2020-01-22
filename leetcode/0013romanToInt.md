## 题目描述

罗马数字转整数
给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。

I 1

V 5

X 10

L 50

C 100

D 500

M 1000

特殊情况
IV 4

IX 9

XL 40

XC 90

CD 400

CM 900

|case|输入|输出|
|:--|:--|:--|
|1|`"III"`|`3`|
|1|`"IV"`|`4`|
|1|`"LVIII"`|`58`|

## 解法

解法一: 一轮遍历, 所有特殊情况做单独的处理

```java
// 1 考虑数组越界
// 2 char的表示要使用''
class Solution {
    public int romanToInt(String s) {
        int result = 0, size = s.length();
        for (int i = 0; i < size; i++) {
            char temp = s.charAt(i);
            switch (temp) {
                case 'I' :
                    if ((i+1) < size && s.charAt(i+1) == 'V') {
                        result += 4;
                        i++;
                        break;
                    }
                    if ((i+1) < size && s.charAt(i+1) == 'X') {
                        result += 9;
                        i++;
                        break;
                    }
                    result += 1;
                    break;
                case 'V' :
                    result += 5;
                    break;
                case 'X' :
                    if ((i+1) < size && s.charAt(i+1) == 'L') {
                        result += 40;
                        i++;
                        break;
                    }
                    if ((i+1) < size && s.charAt(i+1) == 'C') {
                        result += 90;
                        i++;
                        break;
                    }
                    result += 10;
                    break;
                case 'L' :
                    result += 50;
                    break;
                case 'C' :
                    if ((i+1) < size && s.charAt(i+1) == 'D') {
                        result += 400;
                        i++;
                        break;
                    }
                    if ((i+1) < size && s.charAt(i+1) == 'M') {
                        result += 900;
                        i++;
                        break;
                    }
                    result += 100;
                    break;
                case 'D' :
                    result += 500;
                    break;
                case 'M' :
                    result += 1000;
                    break;
            }
        }
        return result;
    }
}
```

优化一: 从右往左一轮循环, 对每位判断加或者减

```java
class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int len = s.length();
        int sum = map.get(s.charAt(len - 1));
        for (int i = len - 2; i >= 0; --i) {
            if (map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                sum -= map.get(s.charAt(i));
            } else {
                sum += map.get(s.charAt(i));
            }
        }
        return sum;
    }
}
```
