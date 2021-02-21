//题号：111
//https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
//给定一个二叉树，找出其最小深度。 
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明：叶子节点是指没有子节点的节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：root = [2,null,3,null,4,null,5,null,6]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数的范围在 [0, 105] 内 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 455 👎 0

  
  package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class MinimumDepthOfBinaryTree{
      public static void main(String[] args) {
           Solution solution = new MinimumDepthOfBinaryTree().new Solution();
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
    public int minDepth(TreeNode root) {

        /**
         * 递归
         */
//        if (root == null) {
//            return 0;
//        }
//
//        //1.左孩子和有孩子都为空的情况，说明到达了叶子节点，直接返回1即可
////        if (root.left == null && root.right == null) {
////            return 1;
////        }
//
//        //2.如果左孩子和右孩子其中一个为空，那么需要返回比较大的那个孩子的深度
//        int left = minDepth(root.left);
//        int right = minDepth(root.right);
//
//        //1.如果左孩子和右孩子有为空的情况，直接返回m1+m2+1(这个也等于Math.max(m1,m2)+1)
//        //2.如果都不为空，返回较小深度+1
////        return root.left == null || root.right == null ? left + right + 1 : Math.min(left,right) + 1;
//        return 1 + (Math.min(left, right) > 0 ? Math.min(left, right) : Math.max(left, right));

        /**
         * 迭代 BFS
         *
         * 这题BFD会比DFS好很多，如果在左右子树极不平衡的情况下，BFS会比DFS快很多
         * 如左子树500节点，右子树一个节点。
         */


        if (root == null) {
            return 0;
        }

        int depth = 1;
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            //遍历每层
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            depth++;
        }

        return depth;


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