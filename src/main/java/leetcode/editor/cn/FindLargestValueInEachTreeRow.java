//题号：515
//https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/#/description
//您需要在二叉树的每一行中找到最大的值。 
//
// 示例： 
//
// 
//输入: 
//
//          1
//         / \
//        3   2
//       / \   \  
//      5   3   9 
//
//输出: [1, 3, 9]
// 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 125 👎 0

  
package leetcode.editor.cn;

import java.net.Inet4Address;
import java.util.*;

public class FindLargestValueInEachTreeRow{
      public static void main(String[] args) {
           Solution solution = new FindLargestValueInEachTreeRow().new Solution();
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
    public List<Integer> largestValues(TreeNode root) {


        /**
         * 一开始想到的应该是BFS
         * 时间复杂度O(n)，空间复杂度O(n)，树的深度
         */

//        List<Integer> res = new ArrayList<>();
//
//        if (root == null) {
//            return res;
//        }
//
//        Deque<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//
//        while (!queue.isEmpty()) {
//
//            int size = queue.size();
//            int max = Integer.MIN_VALUE;
//            for (int i = 0; i < size; i++) {
//
//                TreeNode node = queue.poll();
//
//                max = max < node.val ? node.val : max;
//
//                if (node.left != null) {
//                    queue.offer(node.left);
//                }
//
//                if (node.right != null) {
//                    queue.offer(node.right);
//                }
//
//            }
//
//            res.add(max);
//        }
//
//        return res;


        /**
         * DFS
         */


        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(0, root, res);
        return res;




    }


    private void dfs(int level, TreeNode root, List<Integer> res) {

        if (root == null) {
            return;
        }

        //这里也可以直接设一个最小的默认值然后都进行else的操作，但是感觉没多大必要
        if (res.size() == level) {
            res.add(root.val);
        } else {
            res.set(level, root.val > res.get(level) ? root.val : res.get(level));
        }

        dfs(level + 1, root.left, res);
        dfs(level + 1, root.right, res);

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