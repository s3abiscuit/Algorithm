```java
class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int tmp = len;
        while (--len>=0) {
            if (digits[len]+1<10) {
                digits[len] += 1;
                return digits;
            }
            digits[len] = 0;
            if (len==0) {
                int[] result = new int[tmp+1];
                // 下面一行代码可以不需要, 初始值为0
                // while (--tmp>=0) result[tmp] = digits[tmp];
                result[0] = 1;
                return result;
            }
        }
        return digits;
    }
}
```


改进

```java
class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        while (--len>=0) {
            if (digits[len]+1<10) {
                digits[len] += 1;
                break;
            }
            digits[len] = 0;
            if (len==0) {
                digits = new int[digits.length+1];
                digits[0] = 1;
                break;
            }
        }
        return digits;
    }
}
```
