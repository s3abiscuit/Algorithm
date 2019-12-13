## 题目描述

给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

给定 nums = [0,1,2,2,3,0,4,2], val = 2, 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。


## 解法


```java
class Solution {
    public int removeElement(int[] nums, int val) {
        int size = nums.length;
        if (size == 0) return 0;
        if (size == 1 && nums[0] != val) return 1;
        // double pointer
        int i = 0, j = size-1;
        while (i < size && j >= 0 && i < j) {
            while (nums[i] != val) {    // i走到头说明数组中不含有val
                if (i == size-1) break;
                i++;
            }
            if (i == size-1 && nums[i] != val) {
                return size;
            }
            while (nums[j] == val) {
                if (j==i) break;
                j--;
            }
            if (j==i) break;
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
        }
        return j;
    }
}
```
