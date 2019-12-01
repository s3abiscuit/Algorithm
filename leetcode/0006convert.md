```java
class Solution {
    public String convert(String s, int numRows) {
        if (numRows < 1 || s == null) return "";
        String result = "";
        if (numRows == 1) {
            result = s;
        } else if (numRows ==2) {
            for (int i = 0; i < s.length(); i += 2) {
                char temp = s.charAt(i);
                result += temp;
            }
            for (int j = 1; j < s.length(); j +=2) {
                char temp2 = s.charAt(j);
                result += temp2;
            }
        } else {
            for (int i = 0; i < numRows; i++) {
                for (int j = i; j < (s.length()+2*numRows-2); j += 2*numRows-2) {
                    int temp3 = 2*i;
                    if ((j-temp3<s.length()) && (j-temp3)>(j-(2*numRows-2)) && j-(2*numRows-2) > 0 && temp3 > 0) result += s.charAt(j-temp3);
                    if (j < s.length()) result += s.charAt(j);
                }
            }
        }
        return result;
    }
}
```
