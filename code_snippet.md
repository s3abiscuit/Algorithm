```java
int[] a = new int[N];
int min = 0;
for (int i = 1; i < a.length; i++){
    if (a[i] < a[min]) {
        min = i;
    }
}    
```
