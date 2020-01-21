## 题目描述

给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

|case|输入|输出|
|:--|:--|:--|
|1|`2 -> 4 -> 3, 5 -> 6 -> 4`|`7 -> 0 -> 8`|

342 + 465 = 807

## 解法

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null; 
        ListNode walker = null;
        boolean flag = false;
        int temp1, temp2;

        while (l1 != null && l2 != null) {    
            // 同步循环两个链表
            // 每个循环都要先考虑进位的情况
            if (flag) {    // 进位标记
                temp1 = (l1.val + l2.val + 1) % 10;
                temp2 = (l1.val + l2.val + 1) / 10;
            } else {
                temp1 = (l1.val + l2.val) % 10;
                temp2 = (l1.val + l2.val) / 10;
            }
            flag = temp2 == 1;
            // 判断是否是第一个节点, 标准答案有更优雅的解法
            if (result == null) {
                result = new ListNode(temp1);
                walker = result;
            } else {
                walker.next = new ListNode(temp1);
                walker = walker.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        
        if (l1 != null) {
            // 位数超越 + 进位
            while (flag && l1 != null) {    // [9, 9], [1]
                temp1 = (l1.val + 1) % 10;
                temp2 = (l1.val + 1) / 10;
                walker.next = new ListNode(temp1);
                walker = walker.next;
                flag = temp2 == 1;
                l1 = l1.next;
            }
            if (l1 != null) {    // [5, 4], [1]
                walker.next = l1;
            }
            if (flag) {    // [9, 9], [1]
                walker.next = new ListNode(1);
                walker = walker.next;
                flag = false;
            }             
        }

        if (l2 != null) {
            while (flag && l2 != null) {
                temp1 = (l2.val + 1) % 10;
                temp2 = (l2.val + 1) / 10;
                walker.next = new ListNode(temp1);
                walker = walker.next;
                flag = temp2 == 1;
                l2 = l2.next;
            }
            if (l2 != null){
                walker.next = l2;
            }
            if (flag) {
                walker.next = new ListNode(1);
                walker = walker.next;
                flag = false;
            }
        }
        // 到这里就可以看到这种解法很不优雅
        if (flag) {    // [5], [5]
            walker.next = new ListNode(1);
            walker = walker.next;
            flag = false;
        }
        return result;
    }
}
```

参考答案

```java
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    // 简化代码, 不用在循环中判断是否为第一个节点
    ListNode dummyHead = new ListNode(0);
    ListNode p = l1, q = l2, curr = dummyHead;
    int carry = 0;
    // 更加通用的循环, 包含了所有可能的3种情况
    // 1. 正常相加 1+1
    // 2. 溢出 1+9
    // 3. 某一个数位数较少
    while (p != null || q != null) {
        // 长度不相等时, 缺省数置为0
        int x = (p != null) ? p.val : 0;
        int y = (q != null) ? q.val : 0;
        int sum = carry + x + y;
        carry = sum / 10;
        curr.next = new ListNode(sum % 10);
        curr = curr.next;
        if (p != null) p = p.next;
        if (q != null) q = q.next;
    }
    if (carry > 0) {
        curr.next = new ListNode(carry);
    }
    return dummyHead.next;
}

作者：LeetCode
链接：https://leetcode-cn.com/problems/add-two-numbers/solution/liang-shu-xiang-jia-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

## 总结

1. 链表头节点和其余节点不同处理方式的优雅解法
2. 一个循环完成两个链表的遍历, 补0的处理
