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
