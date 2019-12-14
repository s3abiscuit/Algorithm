## 题目描述

将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。

比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：

L   C   I   R

E T O E S I I G

E   D   H   N

## 解法

```java
class Solution {
    public String convert(String s, int numRows) {
        if (numRows < 1 || s == null) return "";
        String result = "";
        if (numRows == 1) {
            result = s;
        } else if (numRows ==2) {
            for (int i = 0; i < s.length(); i += 2) {
                char temp = s.charAt(i);
                result += temp;
            }
            for (int j = 1; j < s.length(); j +=2) {
                char temp2 = s.charAt(j);
                result += temp2;
            }
        } else {
            for (int i = 0; i < numRows; i++) {
                for (int j = i; j < (s.length()+2*numRows-2); j += 2*numRows-2) {
                    int temp3 = 2*i;
                    if ((j-temp3<s.length()) && (j-temp3)>(j-(2*numRows-2)) && j-(2*numRows-2) > 0 && temp3 > 0) result += s.charAt(j-temp3);
                    if (j < s.length()) result += s.charAt(j);
                }
            }
        }
        return result;
    }
}
```

优化
1. 合并numRows为2的情况
2. 优化添加附属项的流程
3. 代码格式

```java
class Solution {
    public String convert(String s, int numRows) {
        String result = "";
        if (numRows < 1 || s == null) return result;
        if (numRows == 1) result = s;
        else {
            for (int i = 0; i < numRows; i++) {
                int delta = 2*numRows - 2;
                for (int j = i; j < s.length(); j += delta) {
                    result += s.charAt(j);
                    int distance = 2*i;
                    if (j+delta-distance<Math.min(s.length(), j+delta) && delta-distance > 0) 
                        result += s.charAt(j+delta-distance);
                }
            }
        }
        return result;
    }
}
```
