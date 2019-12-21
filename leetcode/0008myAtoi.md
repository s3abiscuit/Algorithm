## 题目描述

请你来实现一个 atoi 函数，使其能将字符串转换成整数。atoi (表示ascii to integer)是把字符串转换成整型数的一个函数

首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。

当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。

该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。

注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。

在任何情况下，若函数不能进行有效的转换时，请返回 0。


## 解法

```java
class Solution {
    public int myAtoi(String str) {
        // 找到第一个+ - 或数字, 然后往前查找和往后查找
        // 往前查找前面必须都是空格
        // 往后查找后面连接的都必须是数字
        int result = 0;
        if (str == null) return result;

        int size = str.length();
        int startIndex = -1;

        for (int i = 0; i < size; i++) {
            if (isDigit(str.charAt(i)) || isRight(str.charAt(i))) {
                startIndex = i;
                break;
            }
        }

        if (startIndex == -1) return 0;

        for (int j = startIndex-1; j >=0; j--) {
            if (str.charAt(j) != ' ') return 0; 
        }

        int endIndex = startIndex+1;
        while(endIndex<size) {
            if (!isDigit(str.charAt(endIndex))) break;
            else endIndex++;
        }
        endIndex--;

        if (str.charAt(startIndex) == '+') {
            if (startIndex == endIndex) return 0;
            else {
                while (endIndex>startIndex) {
                    result = result*10 + Integer.parseInt(String.valueOf(str.charAt(startIndex+1)));
                    startIndex++;
                }
                return result;
            }
        } else if (str.charAt(startIndex) == '-'){
            if (startIndex == endIndex) return 0;
            else {
                while (endIndex>startIndex) {
                    result = result*10 + Integer.parseInt(String.valueOf(str.charAt(startIndex+1)));
                    startIndex++;
                }
                return -result;
            }
        } else {
            while (endIndex>=startIndex) {
                result = result*10 + Integer.parseInt(String.valueOf(str.charAt(startIndex)));
                startIndex++;
            }
            return result;
        }
    }
    

    private boolean isDigit(char c){
        return c >= '0' && c <= '9';
    }

    private boolean isRight(char c) {
        return c == '+' || c == '-';
    }
}
```
