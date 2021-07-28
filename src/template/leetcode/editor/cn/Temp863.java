package template.leetcode.editor.cn;

import tree.BinaryTreeNode;

public class Temp863 {
  private Map<Integer, BinaryTreeNode> parentMap = new HashMap<>();
  private List<Integer> result = new ArrayList<>();
  
  public static void main(String[] args) {
    Temp863 temp = new Temp863();
    
    // TODO: 用例补充
  }
  
  private List<Integer> solution863(BinaryTreeNode root, BinaryTreeNode target, int k) {
    result.clear();
    findParents(root);
    findResult(target, null, 0, k);
    return result;
  }
  
  private void findParents(BinaryTreeNode node) {
    if (node.left != null) {
      parentMap.put(node.left.val, node);
      findParents(node.left);
    }
    if (node.right != null) {
      parentMap.put(node.right.val, node);
      findParents(node.right);
    }
  }
  
  private void findResult(BinaryTreeNode node, BinaryTreeNode from, int depth, int k) {
    if (node == null) {
      return;
    }
    if (depth == k) {
      result.add(node.val);
      return;
    }
    if (node.left != from) {
      findResult(node.left, from, depth + 1, k);
    }
    if (node.right != from) {
      findResult(node.right, from, depth + 1, k);
    }
    if (parentMap.get(node.val) != from) {
      findResult(parentMap.get(node.val), from, depth + 1, k);
    }
  }
}
