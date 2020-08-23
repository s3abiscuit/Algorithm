## 题目描述

![](./pic/0031nextPermutation.png)

## 解法

```java
class Solution {
    public void nextPermutation(int[] nums) {
        int size = nums.length;
        boolean flag = false;
        for(int i = size-1; i > 0; i--) {
            int j = i-1;
            if(nums[i]>nums[j]){
                flag = true;
                int k = i;
                while((++k<size) && (nums[k]>nums[j])){}
                exch(nums, k-1, j);
                for(int l=i;l<i+(size-i)/2;l++){
                    exch(nums, l, size-1-(l-i));
                }
                //exch(nums, i, size-1);
                return;
            }
        }
        if(!flag){
            for(int i = 0; i<size/2; i++){
                exch(nums, i, size-i-1);
            }
        }
        return;
    }

    private void exch(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
```