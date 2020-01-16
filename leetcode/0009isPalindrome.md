```java
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        String str = "";
        while (x/10 != 0) {
            str += x%10;
            x=x/10;
        }
        str += x;
        System.out.println(str);
        int N = str.length();
        for (int i = 0; i < N/2; i++) {
            if (str.charAt(i) != str.charAt(N-1-i)) return false;
        }
        return true;
    }
}
```
