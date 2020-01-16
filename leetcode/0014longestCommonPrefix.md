编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

```java
class Solution {
    public String longestCommonPrefix(String[] strs) {
        String result = "";
        if (strs.length == 0) return result;
        int minLength = strs[0].length(), indexMinLength = 0;
        // 找到长度最小的字符串和它的长度
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < minLength) {
                minLength = strs[i].length();
                indexMinLength = i;
            }
        }

        boolean flag = false;
        // 遍历长度最小的字符串
        for (int i = 0; i < strs[indexMinLength].length(); i++) {
            for (int j = 0; j < strs.length; j++) {
                //if (j == indexMinLength) continue;
                if (strs[j].charAt(i) != strs[indexMinLength].charAt(i)) {
                    flag = true;
                    break;
                }
            }
            if (!flag) result += strs[indexMinLength].charAt(i);
            else break;
        }
        return result;
    }
}
```
