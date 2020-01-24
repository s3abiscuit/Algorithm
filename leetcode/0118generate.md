## 题目描述

给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。

|case|输入|输出|
|:--|:--|:--|
|1|`5`|`[[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]`|

## 解法

两轮循环，每一轮循环单独考虑第一个和最后一个数

```java
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i<numRows; i++){
            List<Integer> tmp = new ArrayList<>();
            for (int j=0; j<=i; j++){
                if (j==0 || j==i) tmp.add(1);
                else {
                    List<Integer> last = list.get(i-1);
                    tmp.add(last.get(j-1)+last.get(j));
                }
            }
            list.add(tmp);
        }
        return list;
    }
}
```
