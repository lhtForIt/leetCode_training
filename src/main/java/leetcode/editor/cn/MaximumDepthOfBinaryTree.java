//题号：104
//https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//    3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索 递归 
// 👍 786 👎 0

  
package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MaximumDepthOfBinaryTree{
      public static void main(String[] args) {
           Solution solution = new MaximumDepthOfBinaryTree().new Solution();
          solution.maxDepth(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7))));
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

        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;



        /**
         * 树大多数解法都适合用递归
         * DFS
         */

//        if (root == null) {
//            return 0;
//        }
//        //分别求左右子树高度
//        int left = maxDepth(root.left);
//        int right = maxDepth(root.right);
//        //返回层数=左右子树最大高度+1
//        return Math.max(left, right) + 1;



        /**
         * 迭代：BFS
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
//            //获取队列中的树的个数
//            int size = queue.size();
//            //分别将树取出并将左右子树放入队列
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
//            //该层遍历完毕，高度+1
//            ans++;
//        }
        //这儿不需要+1，因为是从跟开始计算高度的，这和递归从左右子树计算高度有点不一样
//        return ans;

        /**
         * 迭代：DFS
         */

//        if (root == null) {
//            return 0;
//        }
//
//        Stack<TreeNode> stack = new Stack<>();
//        Stack<Integer> value = new Stack<>();
//
//        stack.push(root);
//        value.push(1);
//
//        int max = 0;
//
//        while (!stack.isEmpty()) {
//            TreeNode node = stack.pop();
//            int temp = value.pop();
//            max = temp > max ? temp : max;
//            if (node.left != null) {
//                stack.push(node.left);
//                value.push(temp + 1);
//            }
//            if (node.right != null) {
//                stack.push(node.right);
//                value.push(temp + 1);
//            }
//        }
//
//        return max;

    }
}
//leetcode submit region end(Prohibit modification and deletion)


      public static class TreeNode {
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