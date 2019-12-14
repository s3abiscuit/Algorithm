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

## 解法

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
