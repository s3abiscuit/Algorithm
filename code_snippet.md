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
```

## string to integer

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
