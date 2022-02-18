//题号：106
//根据一棵树的中序遍历与后序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
// Related Topics 树 深度优先搜索 数组 
// 👍 453 👎 0

  
package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal{
      public static void main(String[] args) {
           Solution solution = new ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        if (inorder == null || postorder == null) {
            return null;
        }

        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) indexMap.put(inorder[i], i);
        return recur(postorder, 0, postorder.length - 1, 0, indexMap);

    }

    /**
     * [9,3,15,20,7]
     * [9,15,7,20,3]
     */
    private TreeNode recur(int[] postOrder, int postOrderLeft, int postOrderRight, int inOrderLeft, Map<Integer, Integer> indexMap) {

        if (postOrderLeft > postOrderRight) {
            return null;
        }

        TreeNode root = new TreeNode(postOrder[postOrderRight]);
        int inOrderRootIndex = indexMap.get(postOrder[postOrderRight]);
        int leftSize = inOrderRootIndex - inOrderLeft;

        root.left = recur(postOrder, postOrderLeft, postOrderLeft + leftSize - 1, inOrderLeft, indexMap);
        root.right = recur(postOrder, postOrderLeft + leftSize, postOrderRight - 1, inOrderRootIndex + 1, indexMap);

        return root;
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