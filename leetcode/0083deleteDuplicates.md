## 题目描述

给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。

|case|输入|输出|
|:--|:--|:--|
|1|`1->1->2`|`1->2`|
|2|`1->1->2->3->3`|`1->2->3`|

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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode walker = head.next, pre = head;
        while(walker != null) {
            if (walker.val == pre.val) {
                pre.next = walker.next;
            } else {
                pre = pre.next;
            }
            walker = walker.next;
        }
        return head;
    }
}
```

参考

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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode curr = head;
        while (curr.next != null) {
            if (curr.next.val == curr.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }
}
```
