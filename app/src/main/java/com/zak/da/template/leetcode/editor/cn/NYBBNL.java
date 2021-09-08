package com.zak.da.template.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
<p>给你一棵二叉搜索树，请&nbsp;<strong>按中序遍历</strong> 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2020/11/17/ex1.jpg" style="width: 600px; height: 350px;" /></p>

<pre>
<strong>输入：</strong>root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
<strong>输出：</strong>[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
</pre>

<p><strong>示例 2：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2020/11/17/ex2.jpg" style="width: 300px; height: 114px;" /></p>

<pre>
<strong>输入：</strong>root = [5,1,7]
<strong>输出：</strong>[1,null,5,null,7]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li>树中节点数的取值范围是 <code>[1, 100]</code></li>
	<li><code>0 &lt;= Node.val &lt;= 1000</code></li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 897&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/increasing-order-search-tree/">https://leetcode-cn.com/problems/increasing-order-search-tree/</a></p>
<div><div>Related Topics</div><div><li>栈</li><li>树</li><li>深度优先搜索</li><li>二叉搜索树</li><li>二叉树</li></div></div><br><div><li>👍 2</li><li>👎 0</li></div>
*/
public class NYBBNL{

    public static void main(String[] args) {
        Solution solution = new NYBBNL().new Solution();

        TreeNode demoOne = new TreeNode(5,
                new TreeNode(3,
                        new TreeNode(2,
                                new TreeNode(1, null, null), null),
                        new TreeNode(4, null, null)),
                new TreeNode(6, null,
                        new TreeNode(8,
                                new TreeNode(7, null, null),
                                new TreeNode(9, null, null))));

        TreeNode demoTwo = new TreeNode(5,
                new TreeNode(1, null, null),
                new TreeNode(7, null, null));

        TreeNode resultOne = solution.increasingBST(demoOne);
        TreeNode resultTwo = solution.increasingBST(demoTwo);

        System.out.print("resultOne preorder == ");
        NYBBNL.preorder(resultOne);

        System.out.println();

        System.out.print("resultTwo preorder == ");
        NYBBNL.preorder(resultTwo);
    }

    private static void preorder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        preorder(node.left);
        preorder(node.right);
    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 */
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
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> inorderList = new ArrayList<>();
        inorder(root, inorderList);
        int size = inorderList.size();
        TreeNode result = new TreeNode(inorderList.get(0));
        TreeNode temp = result;
        for (int i = 1; i < size; i++) {
            temp.right = new TreeNode(inorderList.get(i));
            temp = temp.right;
        }
        return result;
    }

    private void inorder(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        inorder(node.left, result);
        result.add(node.val);
        inorder(node.right, result);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}