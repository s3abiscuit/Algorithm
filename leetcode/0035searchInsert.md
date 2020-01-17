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
