//题号：105
//https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组 
// 👍 878 👎 0

  
package leetcode.editor.cn;

import org.springframework.beans.factory.NoUniqueBeanDefinitionException;

import java.util.*;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal{
      public static void main(String[] args) {
          Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
          solution.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
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

    private Map<Integer, Integer> indexMap = new HashMap<>();
    private int in = 0;
    private int pre = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder == null || inorder == null) {
            return null;
        }


        for (int i = 0; i < inorder.length; i++) indexMap.put(inorder[i], i);

        return recurtion(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1,indexMap);












//        if (preorder == null || inorder == null) {
//            return null;
//        }
//
//        Map<Integer, Integer> myMap = new HashMap<>();
//        for (int i = 0; i < inorder.length; i++) myMap.put(inorder[i], i);
//        //inorder的rightIndex完全没有用，可以去掉
//        return recurs(preorder, 0, preorder.length - 1, 0, myMap);















        /**
         * 这里记住要持续递归，而不能靠常规思维去判断，有时候容易把左右子节点判断出错，要不断用前序和中序去判断
         */
//        if (preorder == null || inorder == null) {
//            return null;
//        }
//
//        for (int i = 0; i < inorder.length; i++) indexMap.put(inorder[i], i);
//
//        return recursion(preorder, 0, preorder.length - 1, 0, inorder.length - 1);






        /**
         * 递归
         * 时间复杂度O(n)，空间复杂度O(n)
         */

//        int n = preorder.length;
//        //利用map存储节点位置，以方便我们快速查找
//        for (int i = 0; i < n; i++) {
//            indexMap.put(inorder[i], i);
//        }
//
//        //这里的参数其实是限定preorder和inorder数组边界
//        return recur(preorder, inorder, 0, n - 1, 0, n - 1);

        /**
         * 迭代
         * 时间复杂度O(n)，空间复杂度O(n)
         */

//        if (preorder == null || preorder.length == 0) {
//            return null;
//        }
//
//        TreeNode root = new TreeNode(preorder[0]);
//        Deque<TreeNode> stack = new LinkedList<>();
//        stack.push(root);
//
//        int inOrderIndex = 0;
//        for (int i = 1; i < preorder.length; i++) {
//
//            int preOrderVal = preorder[i];
//            TreeNode node = stack.peek();
//            if (node.val != inorder[inOrderIndex]) {
//                node.left = new TreeNode(preOrderVal);
//                stack.push(node.left);
//            } else {
//                while (!stack.isEmpty() && stack.peek().val == inorder[inOrderIndex]) {
//                    node = stack.pop();
//                    inOrderIndex++;
//                }
//
//                node.right = new TreeNode(preOrderVal);
//                stack.push(node.right);
//            }
//        }
//
//        return root;


        /**
         * 递归优化
         */

//        return build(preorder, inorder, Integer.MIN_VALUE);




    }

    private TreeNode recurtion(int[] preorder, int preLeft, int preRight, int[] inorder, int inOrderLeft, int inOrderRight, Map<Integer, Integer> indexMap) {

        if (preLeft > preRight) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preLeft]);

        int inOrderRoot = indexMap.get(preorder[preLeft]);

        int leftSize = inOrderRoot - inOrderLeft;

        root.left = recurtion(preorder, preLeft + 1, preLeft + leftSize, inorder, inOrderLeft, inOrderRoot - 1, indexMap);
        root.right = recurtion(preorder, preLeft + leftSize + 1, preRight, inorder, inOrderRoot + 1, inOrderRight, indexMap);

        return root;



















    }

    private TreeNode recurs(int[] preorder, int preLeft, int preRight, int inLeft, Map<Integer, Integer> myMap) {

        if (preLeft > preRight) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preLeft]);

        int rootIndex = myMap.get(preorder[preLeft]);

        int leftSize = rootIndex - inLeft;

        root.left = recurs(preorder, preLeft + 1, preLeft + leftSize, inLeft, myMap);
        root.right = recurs(preorder, preLeft + leftSize + 1, preRight, rootIndex + 1, myMap);


        return root;










    }


    private TreeNode recursion(int[] preOrder, int preOrderLeft, int preOrderRight, int inOrderLeft, int inOrderRight) {

        if (preOrderLeft > preOrderRight) {
            return null;
        }

        TreeNode root = new TreeNode(preOrder[preOrderLeft]);

        int index = indexMap.get(preOrder[preOrderLeft]);

        int leftSize = index - inOrderLeft;

        root.left = recursion(preOrder, preOrderLeft + 1, preOrderLeft + leftSize, inOrderLeft, index - 1);
        root.right = recursion(preOrder, preOrderLeft + leftSize + 1, preOrderRight, index + 1, inOrderRight);

        return root;
    }


    private TreeNode recure(int[] preOrder, int preOrder_left, int preOrder_right, int inOrder_left, int inOrder_right) {

        if (preOrder_left > preOrder_right) {
            return null;
        }
        //构建根
        TreeNode root = new TreeNode(preOrder[preOrder_left]);
        //找打中序中对应下标
        int inOrderRoot = indexMap.get(preOrder[preOrder_left]);

        //左子树节点数
        int sub_left = inOrderRoot - inOrder_left;

        //这儿左边界要+1，不然会把根节点带进去
        root.left = recure(preOrder, preOrder_left + 1, preOrder_left + sub_left, inOrder_left, inOrderRoot - 1);
        root.right = recure(preOrder, preOrder_left + sub_left + 1, preOrder_right, inOrderRoot + 1, inOrder_right);

        return root;
    }

    private TreeNode build(int[] preOrder, int[] inOrder, int stop) {

        if (pre>=preOrder.length) return null;

        if (inOrder[in] == stop) {
            in++;
            return null;
        }

        TreeNode node = new TreeNode(preOrder[pre++]);
        node.left = build(preOrder, inOrder, node.val);
        node.right = build(preOrder, inOrder, stop);
        return node;
    }

    private TreeNode recur(int[] preOrder, int[] inOrder, int preOrder_left, int preOrder_right, int inOrder_left, int inOrder_right) {

        // 前序遍历数组已经到尾部了，直接返回Null
        if (preOrder_left > preOrder_right) {
            return null;
        }

        int preOrder_root = preOrder_left;
        //根据前序的根节点在map得到中序根节点的位置
        int inOrder_root = indexMap.get(preOrder[preOrder_root]);


        //根节点
        TreeNode root = new TreeNode(preOrder[preOrder_root]);
        //左子树中节点数目
        int subLeft = inOrder_root - inOrder_left;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 subLeft」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        //根据上一步得到的左子树节点个数，在前序和中序数组中分别找到左子树的数据，并进行下一层递归
        root.left = recur(preOrder, inOrder, preOrder_left + 1, preOrder_left + subLeft, inOrder_left, inOrder_root - 1);

        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = recur(preOrder, inOrder, preOrder_left + subLeft + 1, preOrder_right, inOrder_root + 1, inOrder_right);

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