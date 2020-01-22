## 题目描述

给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

你可以假设数组中无重复元素。

|case|输入|输出|
|:--|:--|:--|
|1|`[1,3,5,6], 5`|`2`|
|1|`[1,3,5,6], 0`|`0`|

## 解法

解法一: 遍历一遍数组

```java
class Solution {
    public int searchInsert(int[] nums, int target) {
        int size = nums.length;
        if (target<nums[0]) return 0;
        if (target > nums[size-1]) return size;
        for (int i = 0; i < size; i++) {
            if (target == nums[i]) return i;
            if (target>nums[i] && target<nums[i+1]) return i+1;
        }
        return size;
    }
}
```

解法二: 二分查找

```java
class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid = (right + left) >> 1;
        while (left <= right) {
            if (target < nums[mid]) right = mid - 1;
            else if (target > nums[mid]) left = mid + 1;
            else return mid;
            mid = (right + left) >> 1;
        }
        return left;
    }
}
```

二分查找更统一的实现

```java
class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid = (right + left) >> 1;
        while (left <= right) {
            if (target <= nums[mid]) right = mid - 1;
            else left = mid + 1;
            mid = (right + left) >> 1;
        }
        return left;
    }
}
```

## 总结: 需要对二分查找有更加深刻的理解

1. mid可以走到数组所有的下标
2. 没有命中的结束条件是lo>hi, 这个时候要清楚lo和hi的位置

```java
public static int indexOf(int[] a, int key) {
    int lo = 0;
    int hi = a.length - 1;
    while (lo <= hi) {
        // Key is in a[lo..hi] or not present.
        int mid = lo + (hi - lo) / 2;
        if      (key < a[mid]) hi = mid - 1;
        else if (key > a[mid]) lo = mid + 1;
        else return mid;
    }
    return -1;
}
```
