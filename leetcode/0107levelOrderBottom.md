## 题目描述

给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）

```
    3
   / \
  9  20 
    /  \
   15   7
```

|case|input|output|
|:--|:--|:--|
|1|`[3,9,20,null,null,15,7]`|`[15,7,9,20,3]`|

## 解法

非递归解法，层次遍历，借助队列，插入时插到list头部

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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<List<Integer>> list = new LinkedList<>();
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> sub = new LinkedList();
            for(int i = 0; i < size; ++i) {
                TreeNode node = q.remove();
                sub.add(node.val);
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            list.add(0, sub);
        }
        return list;
    }
}
```