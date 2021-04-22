//题号：94
//https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
//给定一个二叉树的根节点 root ，返回它的 中序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
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
//输出：[2,1]
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
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表 
// 👍 853 👎 0

  
package leetcode.editor.cn;

import java.util.*;

public class BinaryTreeInorderTraversal{
      public static void main(String[] args) {
           Solution solution = new BinaryTreeInorderTraversal().new Solution();
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

    LinkedList<Integer> result = new LinkedList<>();

    public List<Integer> inorderTraversal(TreeNode root) {


        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            TreeNode node = stack.pop();
            res.add(node.val);
            root = node.right;

        }

        return res;







        /**
         * 迭代思路：
         * 依次将根节点及其左儿子压入栈中，直到找到其左边叶子节点，
         * 然后弹出栈顶元素，将值放入result中，然后将根节点替换成右子树重复上述过程,
         * 就是由于有root=root.right的原因，所以外层while的root!=null不能去掉，因为如果只有
         * !stack.isEmpty()会存在当前stack为空，但是右节点没有压入栈中
         */

//        List<Integer> res = new ArrayList<>();
//        Deque<TreeNode> stack = new LinkedList<>();
//
//        while (root != null || !stack.isEmpty()) {
//            while (root != null) {
//                stack.push(root);
//                root = root.left;
//            }
//            root = stack.pop();
//            res.add(root.val);
//            root = root.right;
//        }
//
//        return res;












//        List<Integer> res = new LinkedList<>();
//        Deque<TreeNode> stack = new LinkedList<>();
//
//        while (root != null || !stack.isEmpty()) {
//
//            //这儿需要一直遍历到左边叶子节点
//            while (root != null) {
//                stack.push(root);
//                root = root.left;
//            }
//
//            root = stack.pop();
//            res.add(root.val);
//            root = root.right;
//
//        }
//
//        return res;














        /**
         * 法一：递归
         */

//        if (root == null) {
//            return result;
//        }
//
//        inorderTraversal(root.left);
//        result.add(root.val);
//        inorderTraversal(root.right);
//
//        return result;

        /**
         * 法二：非递归
         */

//        LinkedList<Integer> res = new LinkedList<>();
//        Deque<TreeNode> stack = new LinkedList<>();
//
//        while (root != null || !stack.isEmpty()) {
//            while (root != null) {
//                stack.push(root);
//                root = root.left;
//            }
//            root = stack.pop();
//            res.add(root.val);
//            root = root.right;
//
//        }
//
//        return res;


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