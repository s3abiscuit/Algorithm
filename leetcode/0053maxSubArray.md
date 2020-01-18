```java
class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length, max = nums[0];
        for (int i = 0; i<len; i++) { //连续数组的可能起点
            int max_i = nums[i];
            if (max_i>max) max = max_i;
            for (int j = i+1; j<len; j++) {
                max_i += nums[j];
                if (max_i>max) max = max_i;
            }
        }
        return max;
    }
}
```
