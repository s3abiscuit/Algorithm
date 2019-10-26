题目描述：

给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

解决方法

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
            if (flag) {
                temp1 = (l1.val + l2.val + 1) % 10;
                temp2 = (l1.val + l2.val + 1) / 10;
            } else {
                temp1 = (l1.val + l2.val) % 10;
                temp2 = (l1.val + l2.val) / 10;
            }
            flag = temp2 == 1;
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

        if (flag) {    // [5], [5]
            walker.next = new ListNode(1);
            walker = walker.next;
            flag = false;
        }
        return result;
    }
}
```