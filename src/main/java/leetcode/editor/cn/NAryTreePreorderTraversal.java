//题号：589
//https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
//给定一个 N 叉树，返回其节点值的前序遍历。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其前序遍历: [1,3,5,6,2,4]。 
//
// 
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树 
// 👍 137 👎 0

  
package leetcode.editor.cn;

import lombok.val;

import java.util.*;

public class NAryTreePreorderTraversal{
      public static void main(String[] args) {
           Solution solution = new NAryTreePreorderTraversal().new Solution();
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

    LinkedList<Integer> res = new LinkedList<>();


    public List<Integer> preorder(Node root) {


        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Deque<Node> stack = new LinkedList<>();

        stack.push(root);

        while (!stack.isEmpty()) {

            Node node = stack.pop();
            result.add(node.val);

            for (int i = node.children.size() - 1; i >= 0; i--) {
                stack.push(node.children.get(i));
            }

        }


        return result;











        /**
         * 法一，递归 时间复杂度O(n2)，空间复杂度O(n)
         * 树的递归怎么缓存？
         * 这会看来当时想法还真奇怪，树递归是每个节点访问一次且仅访问一次，哪需要缓存。。
         */

//        if (root == null) {
//            return res;
//        }
//        //递归遍历整个树，将根的值放入结果中
//        res.add(root.val);
//        for (Node children : root.children) {
//            //每个孩子也是根，直接递归遍历
//            preorder(children);
//        }
//        return res;


        /**
         * 法二：非递归
         *
         * 自己维护一个栈模拟递归过程
         * 这题非递归会比递归慢很多
         *
         * 时间复杂度O(n)，空间复杂度O(n)
         *
         *
         */

//        List<Integer> res = new ArrayList<>();
//
//        if (root == null) {
//            return res;
//        }
//
//        Deque<Node> stack = new LinkedList<>();
//        stack.push(root);
//
//        while (!stack.isEmpty()) {
//            Node node = stack.pop();
//            res.add(node.val);
//            int size = node.children.size();
//            for (int i = size - 1; i >= 0; i--) {
//                stack.push(node.children.get(i));
//            }
//        }
//
//
//        return res;

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