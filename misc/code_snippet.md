## find the minist number in an array

```java
public int findMinist(int[] nums) {
    int[] a = nums;
    int min = 0;
    for (int i = 1; i < a.length; i++){
        if (a[i] < a[min]) {
            min = i;
        }
    }
}

// resursion
public static int findMinist(int[] arrays, int L, int R) {

    //如果该数组只有一个数，那么最小的就是该数组第一个值了
    if (L == R) {
        return arrays[L];
    } else {
        int a = arrays[L];
        int b = findMinist(arrays, L + 1, R);
        if (a < b) {
            return a;
        } else {
            return b;
        }
    }
}
```

## string to integer

input: "123"

output: 123

```java
public int strToInt(String str) {
    int result = 0;
    for (int i = 0; i < str.length(); i++) {
        // result = result*10 + Integer.parseInt(String.valueOf(str.charAt(startIndex)));
        result = result*10 + (num.charAt(x) - '0');
    }
    return result;
} 
```

## reverse integer

input: 123, 110, -123

output: 321, 11, -321

```java
public int reverse(int x) {
    int rev = 0;
    while (x != 0) {
        int pop = x % 10;
        x /= 10;
        if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
        if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
        rev = rev * 10 + pop;
    }
    return rev;
}
```

## is Palindromic

```java
private boolean validPalindromic(String str, int left, int right) {
    while (left < right) {
        if (str.charAt(left) != str.charAt(right) {
            return false;
        }
        left++;
        right--;
    }
    return true;
}
```

## char to int and int to char

```java
// char to int
char cNumber2='3';
int number2=cNumber2-'0';

// int to char
int number = 9;
char cNumber= (char) (number+'0');
```
