//题号：236
//https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出：3
//解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
// 
//
// 示例 2： 
//
// 
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出：5
//解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2], p = 1, q = 2
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [2, 105] 内。 
// -109 <= Node.val <= 109 
// 所有 Node.val 互不相同 。 
// p != q 
// p 和 q 均存在于给定的二叉树中。 
// 
// Related Topics 树 
// 👍 953 👎 0

  
package leetcode.editor.cn;
public class LowestCommonAncestorOfABinaryTree{
      public static void main(String[] args) {
           Solution solution = new LowestCommonAncestorOfABinaryTree().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) {
            return right;
        }

        if (right == null) {
            return left;
        }

        return root;




























        /**
         * 最近公共祖先的定义： 设节点 root 为节点 p, q 的某公共祖先，
         * 若其左子节点 root.left 和右子节点 root.right 都不是 p,q 的公共祖先，
         * 则称 root 是 “最近的公共祖先” 。
         *
         * 根据以上定义，若 root 是 p, q 的 最近公共祖先 ，则只可能为以下情况之一：
         *
         * p 和 q 在 root 的子树中，且分列 root 的 异侧（即分别在左、右子树中）；
         * p = root ，且 q 在 root 的左或右子树中；
         * q = root ，且 p 在 root 的左或右子树中；
         *
         */

//
//        if (root == null || root == p || root == q) {
//            return root;
//        }
//
//        TreeNode left = lowestCommonAncestor(root.left, p, q);
//        TreeNode right = lowestCommonAncestor(root.right, p, q);
//
//        if (left == null) {
//            return right;
//        }
//
//        if (right == null) {
//            return left;
//        }
//
//        return root;









    }
}
//leetcode submit region end(Prohibit modification and deletion)
public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 }