## 题目描述：

给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。

## 解决方法：

`abcdefgahijklmn`

第一轮, abcdefg 读到下一个a的时候变为bcdefga,然后继续

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

优化

```java
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}
```

## 总结

1 滑动窗口的使用
