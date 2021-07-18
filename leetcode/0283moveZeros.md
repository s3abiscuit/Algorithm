[选择排序]
```
class Solution {
    public void moveZeroes(int[] nums) {
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            if (nums[i] != 0) continue;
            for (int j = i + 1; j < size; j++) {
                if (nums[j] == 0) continue;
                exch(nums, i, j);
                break;
            }
        }
    }

    public void exch(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }
}
```