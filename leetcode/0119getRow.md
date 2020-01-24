## 题目描述

给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。你可以优化你的算法到 O(k) 空间复杂度吗？

|case|input|output|
|:--|:--|:--|
|1|`0`|`[1]`|
|2|`1`|`[1,1]`|
|3|`2`|`[1,2,1]`|
|4|`3`|`[1,3,3,1]`|

## 解法

一轮循环，没轮循环覆盖上次的list，注意rowIndex从0开始

```java
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= rowIndex; ++i) {
            res.add(1);
            for (int j = i - 1; j > 0; --j) {
                res.set(j, res.get(j - 1) + res.get(j));
            }
        }
        return res;
    }
}
```