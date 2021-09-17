//题号：226
//https://leetcode-cn.com/problems/invert-binary-tree/description/
//翻转一棵二叉树。 
//
// 示例： 
//
// 输入： 
//
//     4
//   /   \
//  2     7
// / \   / \
//1   3 6   9 
//
// 输出： 
//
//     4
//   /   \
//  7     2
// / \   / \
//9   6 3   1 
//
// 备注: 
//这个问题是受到 Max Howell 的 原问题 启发的 ： 
//
// 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。 
// Related Topics 树 
// 👍 762 👎 0


package leetcode.editor.cn;

import com.sun.istack.internal.NotNull;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree{
      public static void main(String[] args) {
          Solution solution = new InvertBinaryTree().new Solution();
          solution.invertTree(new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7, new TreeNode(6), new TreeNode(9))));
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
    public TreeNode invertTree(TreeNode root) {


        if (root == null) {
            return root;
        }

        Deque<TreeNode> stack = new LinkedList<>();

        stack.push(root);


        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;

            if (node.left != null) {
                stack.push(node.left);
            }

            if (node.right != null) {
                stack.push(node.right);
            }

        }

        return root;










        /**
         * 递归法：时间复杂度O(n)，空间复杂度O(h),h是树的高度
         */
        //递归结束条件
//        if (root == null) {
//            return null;
//        }
//
//        //当前层逻辑
//        TreeNode temp = root.left;
//        root.left = root.right;
//        root.right = temp;
//
//        //进入下一层
//        invertTree(root.left);
//        invertTree(root.right);
//
//        //这里直接用root.left或者root.right会因为递归导致指向出问题
//        //因此需要额外的变量去记录
////        final TreeNode left = root.left, right = root.right;
////
////        //进入下一层
////        root.right = invertTree(left);
////        root.left = invertTree(right);
//
//        return root;

        /**
         * 迭代法：自己维护一个栈
         * 时间复杂度O(n)，空间复杂度O(n)
         */

//        if (root == null) {
//            return null;
//        }
//
//        final Deque<TreeNode> stack = new LinkedList<>();
//        stack.push(root);
//
//        while (!stack.isEmpty()) {
//            //出栈，交换左右子节点
//            final TreeNode node = stack.pop();
//            final TreeNode left = node.left;
//            node.left = node.right;
//            node.right = left;
//
//            /**
//             * 分别判断左右子树是否为空，不为空则放入栈里，重复上述步骤
//             */
//            if (node.left != null) {
//                stack.push(node.left);
//            }
//
//            if (node.right != null) {
//                stack.push(node.right);
//            }
//
//        }
//        return root;

        /**
         * 迭代法：运用队列,这儿是先进先出->BFS，栈是后进先出
         * 时间复杂度O(n)，空间复杂度O(n)
         */

//        if (root == null) {
//            return null;
//        }
//
//
//        //这儿其实栈和队列存储都没关系，因为都会遍历左右子树，
//        // 先遍历左子树后右子树和先遍历右子树再左子树没区别。
//        final Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//
//        while (!queue.isEmpty()) {
//            final TreeNode node = queue.poll();
//            final TreeNode left = node.left;
//            node.left = node.right;
//            node.right = left;
//
//            if (node.left != null) {
//                queue.offer(node.left);
//            }
//
//            if (node.right != null) {
//                queue.offer(node.right);
//            }
//
//
//        }
//
//
//        return root;
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