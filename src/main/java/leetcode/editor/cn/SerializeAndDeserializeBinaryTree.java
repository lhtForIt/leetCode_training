//题号：297
//序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方
//式重构得到原数据。 
//
// 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串
//反序列化为原始的树结构。 
//
// 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的
//方法解决这个问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,3,null,null,4,5]
//输出：[1,2,3,null,null,4,5]
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
// 
//
// 提示： 
//
// 
// 树中结点数在范围 [0, 104] 内 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 设计 
// 👍 473 👎 0

  
  package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree{
      public static void main(String[] args) {
          Codec solution = new SerializeAndDeserializeBinaryTree().new Codec();
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
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        /**
         * 递归：DFS
         * 时间复杂度O(n)，空间复杂度O(n)
         */
//        if (root == null) {
//            //供反序列化验证是否有效数据的标志
//            return "X,";
//        }
//
//        String left = serialize(root.left);
//        String right = serialize(root.right);
//
//        return root.val + "," + left + right;

        /**
         * 迭代： BFS
         * 时间复杂度O(n)，空间复杂度O(n)
         */

        if (root == null) {
            return "";
        }

        StringBuilder res = new StringBuilder();
        res.append("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();
            if (node != null) {

                res.append("" + node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            } else {
                res.append("null");
            }
            res.append(",");
        }

        res.append("]");
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        /**
         * 递归 DFS
         */
//        String[] temp = data.split(",");
//        Deque<String> dq = new LinkedList<>(Arrays.asList(temp));
//        return buildTree(dq);

        /**
         * 迭代 BFS
         */


        if (data.equals("")) {
            return null;
        }
        String[] dataList = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.valueOf(dataList[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!dataList[i].equals("null")) {
                node.left = new TreeNode(Integer.valueOf(dataList[i]));
                queue.offer(node.left);
            }
            i++;
            if (!dataList[i].equals("null")) {
                node.right = new TreeNode(Integer.valueOf(dataList[i]));
                queue.offer(node.right);
            }
            i++;
        }

        return root;

    }

    private TreeNode buildTree(Deque<String> dq) {

        String s = dq.poll();//拿到当前节点
        if (s.equals("X")) return null;
        TreeNode node = new TreeNode(Integer.valueOf(s));
        node.left = buildTree(dq);//构建左子树
        node.right = buildTree(dq);//构建右子树
        return node;

    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)
public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 }