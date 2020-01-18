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
