## 题目描述

给定一个二叉树，判断它是否是高度平衡的二叉树。

本题中，一棵高度平衡二叉树定义为：

`一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。`

Given the following tree :

```
    3
   / \
  9  20
    /  \
   15   7
```

```
       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
```

|case|input|output|
|:--|:--|:--|
|1|`[3,9,20,null,null,15,7]`|`true`|
|2|`[1,2,2,3,3,null,null,4,4]`|`false`|

## 解法

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        return helper(root) != -1;
    }

    // 得到树高，如果左右子树不平衡则直接返回-1
    private int helper(TreeNode node) {
        if (node == null) return 0;
        int l = helper(node.left);
        if (l == -1) return -1;
        int r = helper(node.right);
        if (r == -1) return -1;
        if (Math.abs(l - r) > 1) return -1;
        return 1 + Math.max(l, r);
    }
}
```