## 题目描述

给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。

如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。

如果不存在最后一个单词，请返回 0 。

说明：一个单词是指仅由字母组成、不包含任何空格的 最大子字符串。

|case|输入|输出|
|:--|:--|:--|
|1|`"Hello World "`|`55`|

## 解法

```java
class Solution {
    public int lengthOfLastWord(String s) {
        int len = s.length(), result=0;
        if (len == 0) return result;
        // 去除倒数开始的空格
        while (len > 0 && s.charAt(--len) == ' ') ;
        len++;
        while (len > 0 && s.charAt(--len) != ' ') {
            result++;
            int tmp = len-1;
        }
        return result;
    }
}
```
