//题号：145
//https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
//给定一个二叉树，返回它的 后序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 534 👎 0

  
package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePostorderTraversal{
      public static void main(String[] args) {
           Solution solution = new BinaryTreePostorderTraversal().new Solution();
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

    private List<Integer> res = new LinkedList<>();

    public List<Integer> postorderTraversal(TreeNode root) {

        /**
         * 递归
         */
//        if (root == null) {
//            return res;
//        }
//
//        postorderTraversal(root.left);
//        postorderTraversal(root.right);
//        res.add(root.val);
//
//        return res;


        /**
         * 迭代
         */

        LinkedList<Integer> res = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();

        while (root != null || !stack.isEmpty()) {

            while (root != null) {
                stack.push(root);
                res.addFirst(root.val);
                root = root.right;
            }

            root = stack.pop();
            root = root.left;


        }

        return res;



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