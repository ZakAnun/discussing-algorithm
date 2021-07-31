package template.leetcode.editor.cn;

//Given the root of a binary tree, calculate the vertical order traversal of the
// binary tree. 
//
// For each node at position (row, col), its left and right children will be at 
//positions (row + 1, col - 1) and (row + 1, col + 1) respectively. The root of th
//e tree is at (0, 0). 
//
// The vertical order traversal of a binary tree is a list of top-to-bottom orde
//rings for each column index starting from the leftmost column and ending on the 
//rightmost column. There may be multiple nodes in the same row and same column. I
//n such a case, sort these nodes by their values. 
//
// Return the vertical order traversal of the binary tree. 
//
// 
// Example 1: 
//
// 
//Input: root = [3,9,20,null,null,15,7]
//Output: [[9],[3,15],[20],[7]]
//Explanation:
//Column -1: Only node 9 is in this column.
//Column 0: Nodes 3 and 15 are in this column in that order from top to bottom.
//Column 1: Only node 20 is in this column.
//Column 2: Only node 7 is in this column. 
//
// Example 2: 
//
// 
//Input: root = [1,2,3,4,5,6,7]
//Output: [[4],[2],[1,5,6],[3],[7]]
//Explanation:
//Column -2: Only node 4 is in this column.
//Column -1: Only node 2 is in this column.
//Column 0: Nodes 1, 5, and 6 are in this column.
//          1 is at the top, so it comes first.
//          5 and 6 are at the same position (2, 0), so we order them by their v
//alue, 5 before 6.
//Column 1: Only node 3 is in this column.
//Column 2: Only node 7 is in this column.
// 
//
// Example 3: 
//
// 
//Input: root = [1,2,3,4,6,5,7]
//Output: [[4],[2],[1,5,6],[3],[7]]
//Explanation:
//This case is the exact same as example 2, but with nodes 5 and 6 swapped.
//Note that the solution remains the same since 5 and 6 are in the same location
// and should be ordered by their values.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 1000]. 
// 0 <= Node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 哈希表 二叉树 
// 👍 146 👎 0

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import tree.BinaryTreeNode;

public class VerticalOrderTraversalOfABinaryTree{

    public static void main(String[] args) {
        Solution solution = new VerticalOrderTraversalOfABinaryTree().new Solution();

        BinaryTreeNode demoOne = new BinaryTreeNode(3,
                new BinaryTreeNode(9, null, null),
                new BinaryTreeNode(20,
                        new BinaryTreeNode(15, null, null),
                        new BinaryTreeNode(7, null, null)));

        BinaryTreeNode demoTwo = new BinaryTreeNode(1,
                new BinaryTreeNode(2,
                        new BinaryTreeNode(4, null, null),
                        new BinaryTreeNode(5, null, null)),
                new BinaryTreeNode(3,
                        new BinaryTreeNode(6, null, null),
                        new BinaryTreeNode(7, null, null)));

        BinaryTreeNode demoThr = new BinaryTreeNode(1,
                new BinaryTreeNode(2,
                        new BinaryTreeNode(4, null, null),
                        new BinaryTreeNode(6, null, null)),
                new BinaryTreeNode(3,
                        new BinaryTreeNode(5, null, null),
                        new BinaryTreeNode(7, null, null)));

        List<List<Integer>> resultOne = solution.verticalTraversal(demoOne);
        List<List<Integer>> resultTwo = solution.verticalTraversal(demoTwo);
        List<List<Integer>> resultThr = solution.verticalTraversal(demoThr);

        System.out.println("二叉树 [3, 9, 20, null, null, 15, 7] 的垂序遍历序列为: ");
        System.out.print("[ ");
        for (List<Integer> group : resultOne) {
            System.out.print("[");
            for (int item : group) {
                System.out.print(item + " ");
            }
            System.out.print("] ");
        }
        System.out.println(" ]");
        System.out.println("二叉树 [1, 2, 3, 4, 5, 6, 7] 的垂序遍历序列为: ");
        System.out.print("[ ");
        for (List<Integer> group : resultTwo) {
            System.out.print("[");
            for (int item : group) {
                System.out.print(item + " ");
            }
            System.out.print("] ");
        }
        System.out.println(" ]");
        System.out.println("二叉树 [1, 2, 3, 4, 6, 5, 7] 的垂序遍历序列为: ");
        System.out.print("[ ");
        for (List<Integer> group : resultThr) {
            System.out.print("[");
            for (int item : group) {
                System.out.print(item + " ");
            }
            System.out.print("] ");
        }
        System.out.println(" ]");
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
    private List<Location> locations = new ArrayList<>();

    public List<List<Integer>> verticalTraversal(BinaryTreeNode root) {
        locations.clear();
        generateLocations(root, 0, 0);
        Collections.sort(locations);

        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        int pre = locations.get(0).x;
        for (Location loc : locations) {
            if (loc.x != pre) {
                pre = loc.x;
                result.add(new ArrayList<>());
            }
            result.get(result.size() - 1).add(loc.value);
        }

        return result;
    }

    private void generateLocations(BinaryTreeNode node, int x, int y) {
        if (node == null) {
            return;
        }

        locations.add(new Location(x, y, node.getValue()));
        generateLocations(node.getLeft(), x - 1, y + 1);
        generateLocations(node.getRight(), x + 1, y + 1);
    }
}

class Location implements Comparable<Location> {

    int x;
    int y;
    int value;

    public Location(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }

    @Override
    public int compareTo(@NotNull Location that) {
        if (this.x != that.x) {
            return Integer.compare(this.x, that.x);
        } else if (this.y != that.y) {
            return Integer.compare(this.y, that.y);
        } else {
            return Integer.compare(this.value, that.value);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}