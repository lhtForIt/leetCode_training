//题号：98
//https://leetcode-cn.com/problems/validate-binary-search-tree/
//给定一个二叉树，判断其是否是一个有效的二叉搜索树。 
//
// 假设一个二叉搜索树具有如下特征： 
//
// 
// 节点的左子树只包含小于当前节点的数。 
// 节点的右子树只包含大于当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 示例 1: 
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
// 
// Related Topics 树 深度优先搜索 递归 
// 👍 926 👎 0

  
  package leetcode.editor.cn;

import java.util.Stack;

public class ValidateBinarySearchTree{
      public static void main(String[] args) {
           Solution solution = new ValidateBinarySearchTree().new Solution();
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
    public boolean isValidBST(TreeNode root) {

        /**
         * 递归法：时间复杂度O(n)，空间复杂度O(n)
         */

//        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);

        /**
         * 迭代：
         */


        /**
         * 中序遍历原始代码：
         * public List<Integer> inorderTraversal(TreeNode root) {
         *     List<Integer> list = new ArrayList<>();
         *     if(root == null) return list;
         *     Stack<TreeNode> stack = new Stack<>();
         *     while(root != null || !stack.empty()){
         *         while(root != null){
         *             stack.push(root);
         *             root = root.left;
         *         }
         *         root = stack.pop();
         *         list.add(root.val);
         *         root = root.right;
         *
         *     }
         *     return list;
         * }
         *
         * 利用这个结构可以找二叉搜索树第K小的元素
         * public int kthSmallest(TreeNode root, int k) {
         *      Stack<TreeNode> stack = new Stack<>();
         *      while(root != null || !stack.isEmpty()) {
         *          while(root != null) {
         *              stack.push(root);
         *              root = root.left;
         *          }
         *          root = stack.pop();
         *          if(--k == 0) break;
         *          root = root.right;
         *      }
         *      return root.val;
         *  }
         *
         *  也可以用这个验证是否是二叉搜索树
         *
          */

        if (root == null) {
            return true;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre != null && root.val <= pre.val) {
                return false;
            }
            pre = root;
            root = root.right;
        }

        return true;
    }

    private boolean isValidBST(TreeNode root, long min, long max) {

        if (root == null) {
            return true;
        }

        if (root.val <= min || root.val >= max) {
            return false;
        }

        //&&左右两边分别代表左右子树的遍历，因此左子树最大值是根的值，右子树最小值是根的值
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
public class TreeNode {
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
 }