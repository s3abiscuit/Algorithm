## 题目描述

给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

|case|输入|输出|
|:--|:--|:--|
|1|[-2,1,-3,4,-1,2,1,-5,4]|6|

## 解法

遍历的方式

```java
class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length, max = nums[0];
        for (int i = 0; i<len; i++) { //连续数组的可能起点
            int max_i = nums[i]; // 每一轮找到一个最大值
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
