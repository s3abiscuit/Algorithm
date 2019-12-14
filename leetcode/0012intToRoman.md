## 题目藐视

整数转换为罗马数字, 数字范围是1-3999

## 解法

```java
class Solution {
    public String intToRoman(int num) {
        String result = "";
        int[] a = new int[4];
        int index = 0;

        while (num/10 != 0) {
            a[index++] = num%10;
            num /= 10;
        }
        a[index] = num;

        for (int i = index; i >= 0; i--) {
            int tmp = a[i];
            if (i == 3) {
                while(tmp-- > 0) result += "M";
            }
            if (i == 2) {
                if (tmp == 9) result += "CM";
                else if (tmp == 4) result += "CD";
                else if (tmp >= 5) {
                    result += "D";
                    tmp -= 5;
                    while (tmp-- > 0) result += "C";
                }
                else {
                    while(tmp-- > 0) result += "C"; 
                }
            }
            if (i == 1) {
                if (tmp == 9) result += "XC";
                else if (tmp == 4) result += "XL";
                else if (tmp >= 5) {
                    result += "L";
                    tmp -= 5;
                    while(tmp-- > 0) result += "X";
                }
                else {
                    while(tmp-- > 0) result += "X"; 
                }
            }
            if (i == 0) {
                if (tmp == 9) result += "IX";
                else if (tmp == 4) result += "IV";
                else if (tmp >= 5) {
                    result += "V";
                    tmp -= 5;
                    while(tmp-- > 0) result += "I";
                }
                else {
                    while(tmp-- > 0) result += "I"; 
                }
            }
        }
        return result;
    }
}
```
