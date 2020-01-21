## 题目描述

将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的

|case|输入|输出|
|:--|:--|:--|
|1|`1->2->4, 1->3->4`|`1->1->2->3->4->4`|

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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dumyHead = new ListNode(0),  walker = dumyHead;
        ListNode node;
        while (l1 != null && l2 != null) {
            int temp1 = l1.val;
            int temp2 = l2.val;

            if (temp1 < temp2) {
                node = new ListNode(temp1);
                walker.next = node;
                walker = node;
                l1 = l1.next;
            } else {
                node = new ListNode(temp2);
                walker.next = node;
                walker = node;
                l2 = l2.next;
            }
        }

        if (l1 != null) walker.next = l1;
        if (l2 != null) walker.next = l2;
        
        return dumyHead.next;
    }
}
```
