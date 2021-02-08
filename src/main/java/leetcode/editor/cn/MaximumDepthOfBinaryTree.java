//题号：104
//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索 递归 
// 👍 786 👎 0

  
  package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree{
      public static void main(String[] args) {
           Solution solution = new MaximumDepthOfBinaryTree().new Solution();
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
    public int maxDepth(TreeNode root) {

        /**
         * 树大多数解法都适合用递归
         * DFS
         */
        if (root == null) {
            return 0;
        }
        //分别求左右子树高度
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        //返回层数=左右子树最大高度+1
        return Math.max(left, right) + 1;



        /**
         * BFS
         */
//        if (root == null) {
//            return 0;
//        }
//
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        //记录访问的层数
//        int ans = 0;
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            while (size > 0) {
//                TreeNode node = queue.poll();
//                if (node.left != null) {
//                    queue.offer(node.left);
//                }
//                if (node.right != null) {
//                    queue.offer(node.right);
//                }
//                size--;
//            }
//            ans++;
//        }
//        return ans;




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