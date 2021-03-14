//题号：剑指 Offer 68 - II
//https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4] 
//
// 
//
// 
//
// 示例 1: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出: 3
//解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
// 
//
// 示例 2: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出: 5
//解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
// 
//
// 
//
// 说明: 
//
// 
// 所有节点的值都是唯一的。 
// p、q 为不同节点且均存在于给定的二叉树中。 
// 
//
// 注意：本题与主站 236 题相同：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a
//-binary-tree/ 
// Related Topics 树 
// 👍 191 👎 0

  
package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ErChaShuDeZuiJinGongGongZuXianLcof{
      public static void main(String[] args) {
           Solution solution = new ErChaShuDeZuiJinGongGongZuXianLcof().new Solution();
//           [3,5,1,6,2,0,8,null,null,7,4]
           TreeNode root = new TreeNode(3);
           root.left = new TreeNode(5);
           root.right = new TreeNode(1);
           root.left.left = new TreeNode(6);
           root.left.right = new TreeNode(2);
           root.left.right.left = new TreeNode(7);
           root.left.right.right = new TreeNode(4);
           root.right.left = new TreeNode(0);
           root.right.right = new TreeNode(8);

          TreeNode t = solution.lowestCommonAncestor(root, new TreeNode(5), new TreeNode(1));
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

    Map<Integer, TreeNode> parent = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        /**
         * 递归
         *
         * 若root是p,q最近公共祖先，则只可能是一下几种情况：
         * 1、p和q在root的子树中，且分别位于两侧(即分别在左右子树中)。
         * 2、p==root,且q在root左右子树中。
         * 3、q==root，且p在root左右子树中。
         *
         * 因此只需要递归去访问左右子树的LCR(最近公共祖先)，当左子树返回LCR为空，则返回右子树LCR，反之亦然，
         * 当两个子树LCR都不为空，则返回他们的当前共同祖先即root。
         */
        //root==null说明到了叶子节点也没找到
        //root==p||root==q代表找到了p或者q
        //官方好像忽略了节点引用的比较，而默认用的val去比，且会忽略左右子树
        //eg.树里面节点5是有左右子树的，但是p其实就new了一个5，没有左右子树，
        //在着，即使加上左右子树
        //==比较的是内存地址，新new的树内存地址一定不等
//        if (root == null || root == p || root == q) {
////        if (root == null || root.val == p.val || root.val == q.val) {
//            return root;
//        }
//
//        TreeNode left = lowestCommonAncestor(root.left, p, q);
//        TreeNode right = lowestCommonAncestor(root.right, p, q);
//        if (left == null) {
//            return right;
//        }
//
//        if (right == null) {
//            return left;
//        }
//
//        return root;


        if (root == null || p == root || q == root) {
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






    }

    private void dfs(TreeNode root) {

    }
}
//leetcode submit region end(Prohibit modification and deletion)
public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 }