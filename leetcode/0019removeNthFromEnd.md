## 题目描述

给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
给定一个链表: 1->2->3->4->5, 和 n = 2.
当删除了倒数第二个节点后，链表变为 1->2->3->5.

n保证是有效的, 说明n可能的值是1-5


## 解法

简单的解法是两遍循环, 
**第二遍关键是确定loop的值**
以上面的例子分析, 倒数第2个数(n)正着数是第4个(size-n+1), 所以需要walker指向到第3个节点(size-n)
开始循环时walker默认指向的是第1个节点, 这时候需要循环2次才能使walker指向第3个节点, loop的值为2j即(size-n-1)

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head, walker = head;
        int size = 0;
        if (temp != null) size++; 
        while (temp.next != null) {
            size++;
            temp = temp.next;
        }

        if (n == size) return head.next;

        int loop = size - n - 1;
        while (loop-- > 0) walker = walker.next;
        walker.next = walker.next.next;
        return head;
    }
}
```
