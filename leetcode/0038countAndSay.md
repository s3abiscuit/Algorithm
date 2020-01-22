## 题目描述

「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前六项如下：

|case|输入|输出|
|:--|:--|:--|
|1|`1`|`"1"`|
|2|`2`|`"11"`|
|3|`3`|`"21"`|
|4|`4`|`"1211"`|
|5|`5`|`"111221"`|
|6|`6`|`"312211"`|

## 解法

使用两轮循环, 第一轮循环表示执行的次数, 第二轮循环加工上一轮字符串

```java
class Solution {
    // 两轮循环
    public String countAndSay(int n) {
        String str = "1";
        while (--n > 0) { //第一轮循环是执行次数
            int times = 1;
            StringBuilder sb = new StringBuilder();
            char[] chars = str.toCharArray();
            int len = chars.length;
            for (int j = 1; j < len; j++) { //加工上一轮字串
                if (chars[j - 1] == chars[j]) {
                    times++;
                } else {
                    sb.append(times).append(chars[j - 1]);
                    times = 1;
                }
            }
            str = sb.append(times).append(chars[len - 1]).toString();
        }
        return str;
    }
}
```
