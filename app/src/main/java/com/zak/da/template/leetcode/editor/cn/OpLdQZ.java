package com.zak.da.template.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
<p>给定一个二叉搜索树的 <strong>根节点</strong> <code>root</code>&nbsp;和一个整数 <code>k</code> , 请判断该二叉搜索树中是否存在两个节点它们的值之和等于 <code>k</code> 。假设二叉搜索树中节点的值均唯一。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入: </strong>root =<strong> </strong>[8,6,10,5,7,9,11], k = 12
<strong>输出: </strong>true
<strong>解释: </strong>节点 5 和节点 7 之和等于 12
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入: </strong>root =<strong> </strong>[8,6,10,5,7,9,11], k = 22
<strong>输出: </strong>false
<strong>解释: </strong>不存在两个节点值之和为 22 的节点
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li>二叉树的节点个数的范围是&nbsp;&nbsp;<code>[1, 10<sup>4</sup>]</code>.</li>
	<li><code>-10<sup>4</sup>&nbsp;&lt;= Node.val &lt;= 10<sup>4</sup></code></li>
	<li><code>root</code>&nbsp;为二叉搜索树</li>
	<li><code>-10<sup>5</sup>&nbsp;&lt;= k &lt;= 10<sup>5</sup></code></li>
</ul>

<p>&nbsp;</p>

<p>注意：本题与主站 653 题相同：&nbsp;<a href="https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/">https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/</a></p>
<div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>广度优先搜索</li><li>二叉搜索树</li><li>哈希表</li><li>双指针</li><li>二叉树</li></div></div><br><div><li>👍 1</li><li>👎 0</li></div>
*/
public class OpLdQZ{

    public static void main(String[] args) {
        Solution solution = new OpLdQZ().new Solution();

        TreeNode demoTree = new TreeNode(8,
                new TreeNode(6,
                        new TreeNode(5),
                        new TreeNode(7)),
                new TreeNode(10,
                        new TreeNode(9),
                        new TreeNode(11)));

        System.out.println("暴力解法: ");
        System.out.println("root = [8, 6, 10, 5, 7, 9, 11], k = 12，是否有两个节点值 == 12: " + solution.findTargetBl(demoTree, 12));
        System.out.println("root = [8, 6, 10, 5, 7, 9, 11], k = 22，是否有两个节点值 == 22: " + solution.findTargetBl(demoTree, 22));

        System.out.println("=========");

        System.out.println("更优解法: ");
        System.out.println("root = [8, 6, 10, 5, 7, 9, 11], k = 12，是否有两个节点值 == 12: " + solution.findTargetBetter(demoTree, 12));
        System.out.println("root = [8, 6, 10, 5, 7, 9, 11], k = 22，是否有两个节点值 == 22: " + solution.findTargetBetter(demoTree, 22));
    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.*/
private static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    /**
     * 暴力解法（获取中序遍历序列，然后两层循环计算出是否有符合 k 值的两个节点
     *
     * @param root root
     * @param k k
     * @return result
     */
    public boolean findTargetBl(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        int size = result.size();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (result.get(i) + result.get(j) == k) {
                    return true;
                }
            }
        }
        return false;
    }

    private void inorder(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        inorder(node.left, result);
        result.add(node.val);
        inorder(node.right, result);
    }

    public boolean findTargetBetter(TreeNode root, int k) {
        TreeIterator left = new TreeIterator(root, true);
        TreeIterator right = new TreeIterator(root, false);
        if (left.hasNext() && right.hasNext()) {
            TreeNode l = left.next(), r = right.next();
            while (l.val < r.val) {
                while (l.val + r.val > k && right.hasNext()) r = right.next();
                while (l.val + r.val < k && left.hasNext()) l = left.next();
                if (l.val != r.val && l.val + r.val == k) return true;
            }
        }
        return false;
    }

    // 二叉树中序迭代器
    private class TreeIterator implements Iterator<TreeNode> {

        // 用一个标记表示先左后右遍历，还是先右后左遍历
        private final boolean leftFirst;
        private final Stack<TreeNode> stack;
        private TreeNode currentNode;

        public TreeIterator(TreeNode root, boolean leftFirst) {
            this.leftFirst = leftFirst;
            this.currentNode = root;
            this.stack = new Stack<>();
        }

        // 该方法需要注意的是：只要没有调用过next()，那么不管调用多少次hashNext()都是幂等的
        @Override
        public boolean hasNext() {
            if (currentNode == null) return !stack.isEmpty();
            if (leftFirst) {
                while (currentNode != null) {
                    stack.push(currentNode);
                    currentNode = currentNode.left;
                }
            } else {
                while (currentNode != null) {
                    stack.push(currentNode);
                    currentNode = currentNode.right;
                }
            }
            return !stack.isEmpty();
        }

        @Override
        public TreeNode next() {
            if (stack.isEmpty()) return null; // 在工程代码中，这里应该抛出异常
            TreeNode ret = stack.pop();
            currentNode = null;
            if (leftFirst && ret.right != null) {
                currentNode = ret.right;
            } else if (!leftFirst && ret.left != null) {
                currentNode = ret.left;
            }
            return ret;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}