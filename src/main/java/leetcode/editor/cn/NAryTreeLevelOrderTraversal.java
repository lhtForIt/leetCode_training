//题号：429
//https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
//给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。 
//
// 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,null,3,2,4,null,5,6]
//输出：[[1],[3,2,4],[5,6]]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,
//null,13,null,null,14]
//输出：[[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
// 
//
// 
//
// 提示： 
//
// 
// 树的高度不会超过 1000 
// 树的节点总数在 [0, 10^4] 之间 
// 
// Related Topics 树 广度优先搜索 
// 👍 135 👎 0

  
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class NAryTreeLevelOrderTraversal{
      public static void main(String[] args) {
           Solution solution = new NAryTreeLevelOrderTraversal().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        recur(0, root, res);


        return res;








        /**
         * bfs
         *
         * 时间复杂度O(n)，空间复杂度O(n)
         */

//        List<List<Integer>> res = new ArrayList<>();
//
//        if (root == null) {
//            return res;
//        }
//        Deque<Node> queue = new LinkedList<>();
//        queue.offer(root);
//
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            List<Integer> subRes = new ArrayList<>();
//            for (int i = 0; i < size; i++) {
//                Node node = queue.poll();
//                subRes.add(node.val);
////                for (int j = 0; j < node.children.size(); j++) {
////                    queue.offer(node.children.get(j));
////                }
//                //queue也是一个linkedList，可以直接通过addAll()方法添加
//                queue.addAll(node.children);
//            }
//            res.add(subRes);
//        }
//
//
//        return res;


        /**
         * dfs
         *
         * 时间复杂度O(n)，空间复杂度O(n)
         *
         */

//        if (root == null) {
//            return res;
//        }
//
//        dfs(root, 0, res);
//
//        return res;

    }

    private void recur(int level, Node root, List<List<Integer>> res) {

        if (root == null) {
            return;
        }

        if (res.size() == level) {
            res.add(new ArrayList<>());
        }


        res.get(level).add(root.val);

        for (Node child : root.children) {
            recur(level + 1, child, res);
        }



    }

    private void dfs(Node root, int level, List<List<Integer>> res) {


        if (res.size() == level) {
            res.add(new ArrayList<>());
        }

        res.get(level).add(root.val);

        for (Node child : root.children) {
            dfs(child, level + 1, res);
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
  }