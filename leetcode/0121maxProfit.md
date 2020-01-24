## [题目描述](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock)

给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。

注意你不能在买入股票前卖出股票。

|case|input|output|
|:--|:--|:--|
|1|`[7,1,5,3,6,4]`|`5`|
|2|`[7,6,4,3,1]`|`0`|

## 解法

两轮循环穷举所有可能，发现更大值时替换。

```java
class Solution {
    public int maxProfit(int[] prices) {
        int size = prices.length, maxProfit = 0;
        for (int i=0; i<size; i++) {
            for (int j=i+1; j<size; j++) {
                int tmp = prices[j]-prices[i];
                maxProfit = tmp>maxProfit? tmp:maxProfit;
            }
        }
        return maxProfit;
    }
}
```

正统解法： 找到所有连续的谷峰差，然后求和

```java
class Solution {
    public int maxProfit(int[] prices) {
        int i = 0;
        int valley = prices[0];
        int peak = prices[0];
        int maxprofit = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1])
                i++;
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1])
                i++;
            peak = prices[i];
            maxprofit += peak - valley;
        }
        return maxprofit;
    }
}
```

投机解法：只使用一轮循环，每次记录之前的最小值

```java
class Solution {
    public int maxProfit(int[] prices) {
        int max = 0, minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; ++i) {
            if (prices[i] < minPrice) minPrice = prices[i];
            int delta = prices[i] - minPrice;
            if (delta > max) max = delta;
        }
        return max;
    }
}
```