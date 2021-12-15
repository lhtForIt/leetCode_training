//题号：144
//https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
//给你二叉树的根节点 root ，返回它节点值的 前序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,2,3]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[1,2]
// 
//
// 示例 5： 
//
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 511 👎 0

  
package leetcode.editor.cn;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePreorderTraversal{
      public static void main(String[] args) {
           Solution solution = new BinaryTreePreorderTraversal().new Solution();
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

    LinkedList<Integer> res = new LinkedList<>();

    public List<Integer> preorderTraversal(TreeNode root) {


        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                result.add(root.val);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }

        return result;













        /**
         * 法一：递归
         */

//        if (root == null) {
//            return res;
//        }
//
//        res.add(root.val);
//        preorderTraversal(root.left);
//        preorderTraversal(root.right);
//
//        return res;


        /**
         * 法二：迭代
         */

//        LinkedList<Integer> res = new LinkedList<>();
//        Deque<TreeNode> stack = new LinkedList<>();
//
//        while (root != null || !stack.isEmpty()) {
//            while (root != null) {
//                res.add(root.val);
//                stack.push(root);
//                root = root.left;
//            }
//
//            root = stack.pop();
//            root = root.right;
//        }
//
//
//        return res;

        /**
         * 迭代二：
         * 逆向递推栈
         */

//        List<Integer> ress = new LinkedList<>();
//        if (root == null) {
//            return ress;
//        }
//        Deque<TreeNode> stack = new LinkedList<>();
//        stack.push(root);
//        while (!stack.isEmpty()) {
//            TreeNode node = stack.pop();
//            ress.add(node.val);
//            if (node.right != null) stack.push(node.right);
//            if (node.left != null) stack.push(node.left);
//        }
//        return ress;

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