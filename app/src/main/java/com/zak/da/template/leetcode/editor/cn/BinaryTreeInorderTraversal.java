package com.zak.da.template.leetcode.editor.cn;

import com.zak.da.tree.BinaryTreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
<p>给定一个二叉树的根节点 <code>root</code> ，返回它的 <strong>中序</strong> 遍历。</p>

<p> </p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/09/15/inorder_1.jpg" style="width: 202px; height: 324px;" />
<pre>
<strong>输入：</strong>root = [1,null,2,3]
<strong>输出：</strong>[1,3,2]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>root = []
<strong>输出：</strong>[]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>root = [1]
<strong>输出：</strong>[1]
</pre>

<p><strong>示例 4：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/09/15/inorder_5.jpg" style="width: 202px; height: 202px;" />
<pre>
<strong>输入：</strong>root = [1,2]
<strong>输出：</strong>[2,1]
</pre>

<p><strong>示例 5：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/09/15/inorder_4.jpg" style="width: 202px; height: 202px;" />
<pre>
<strong>输入：</strong>root = [1,null,2]
<strong>输出：</strong>[1,2]
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li>树中节点数目在范围 <code>[0, 100]</code> 内</li>
	<li><code>-100 <= Node.val <= 100</code></li>
</ul>

<p> </p>

<p><strong>进阶:</strong> 递归算法很简单，你可以通过迭代算法完成吗？</p>
<div><div>Related Topics</div><div><li>栈</li><li>树</li><li>深度优先搜索</li><li>二叉树</li></div></div><br><div><li>👍 1077</li><li>👎 0</li></div>
*/
public class BinaryTreeInorderTraversal{

    public static void main(String[] args) {
        Solution solution = new BinaryTreeInorderTraversal().new Solution();

        BinaryTreeNode demoOne = new BinaryTreeNode(1, null,
                new BinaryTreeNode(2,
                        new BinaryTreeNode(3, null, null), null));
        BinaryTreeNode demoTwo = null;
        BinaryTreeNode demoThr = new BinaryTreeNode(1, null, null);
        BinaryTreeNode demoFou = new BinaryTreeNode(1,
                new BinaryTreeNode(2, null, null), null);
        BinaryTreeNode demoFiv = new BinaryTreeNode(1, null,
                new BinaryTreeNode(2, null, null));

        System.out.println("demoOne [1, null, 2, 3]");
        solution.inorderTraversal(demoOne);

        System.out.println();

        System.out.println("demoTwo []");
        solution.inorderTraversal(demoTwo);

        System.out.println();

        System.out.println("demoThr [1]");
        solution.inorderTraversal(demoThr);

        System.out.println();

        System.out.println("demoFou [1, 2]");
        solution.inorderTraversal(demoFou);

        System.out.println();

        System.out.println("demoFiv [1, null, 2]");
        solution.inorderTraversal(demoFiv);
    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(BinaryTreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderDiGui(root, result);
        System.out.print("递归得出的二叉树中序遍历序列为：" + Arrays.toString(result.toArray()));

        System.out.println();

        result.clear();
        inorderForeach(root, result);
        System.out.print("遍历得出的二叉树中序遍历序列为：" + Arrays.toString(result.toArray()));

        System.out.println();

        return result;
    }

    private void inorderDiGui(BinaryTreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inorderDiGui(root.getLeft(), result);
        result.add(root.getValue());
        inorderDiGui(root.getRight(), result);
    }

    private void inorderForeach(BinaryTreeNode root, List<Integer> result) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        if (root == null) {
            return;
        }
        BinaryTreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.getLeft();
            }

            cur = stack.pop();
            result.add(cur.getValue());
            cur = cur.getRight();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}