题目描述：
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

解决方法：

使用滑动窗口

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        // HashSet的目的是为了计数
        // ABCDEC
        HashSet<Character> set = new HashSet<>();
        int i = 0, j = 0, result = 0, n = s.length();
        while (i < n && j < n) {
            // 添加第二个C之前先判断
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                result = Math.max(result, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return result;
    }
}
```