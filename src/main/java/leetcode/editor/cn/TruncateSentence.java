//题号：1816
//句子 是一个单词列表，列表中的单词之间用单个空格隔开，且不存在前导或尾随空格。每个单词仅由大小写英文字母组成（不含标点符号）。 
//
// 
// 例如，"Hello World"、"HELLO" 和 "hello world hello world" 都是句子。 
// 
//
// 给你一个句子 s 和一个整数 k ，请你将 s 截断 ，使截断后的句子仅含 前 k 个单词。返回 截断 s 后得到的句子。 
//
// 
//
// 示例 1： 
//
// 输入：s = "Hello how are you Contestant", k = 4
//输出："Hello how are you"
//解释：
//s 中的单词为 ["Hello", "how" "are", "you", "Contestant"]
//前 4 个单词为 ["Hello", "how", "are", "you"]
//因此，应当返回 "Hello how are you"
// 
//
// 示例 2： 
//
// 输入：s = "What is the solution to this problem", k = 4
//输出："What is the solution"
//解释：
//s 中的单词为 ["What", "is" "the", "solution", "to", "this", "problem"]
//前 4 个单词为 ["What", "is", "the", "solution"]
//因此，应当返回 "What is the solution" 
//
// 示例 3： 
//
// 输入：s = "chopper is not a tanuki", k = 5
//输出："chopper is not a tanuki"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 500 
// k 的取值范围是 [1, s 中单词的数目] 
// s 仅由大小写英文字母和空格组成 
// s 中的单词之间由单个空格隔开 
// 不存在前导或尾随空格 
// 
// Related Topics 数组 字符串 
// 👍 25 👎 0

  
package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class TruncateSentence{
      public static void main(String[] args) {
           Solution solution = new TruncateSentence().new Solution();
          solution.truncateSentence("chopper is not a tanuki", 5);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String truncateSentence(String s, int k) {

        /**
         * 看下我的思路再看下全球站高赞解法的思路，大概就是一般coder和大神的思路区别吧
         */
//        String[] strs = s.split(" ");
//        String res = new String();
//        for (int i = 0; i < k - 1; i++) {
//            res += strs[i] + " ";
//        }
//        //单独处理第k个元素，因为不需要空格
//        res += strs[k - 1];
//        return res;

//        int start = 0;
//        Deque<String> queue = new LinkedList<>();
//        for (int i = 0; i < s.length(); i++) {
//            if (queue.size() < k) {
//                if (s.charAt(i) == ' ') {
//                    queue.offer(s.substring(start, i));
//                    start = i + 1;
//                } else if (s.length() - 1 == i) {
//                    queue.offer(s.substring(start, i + 1));
//                    start = i + 1;
//                }
//            }
//        }
//
//        String res = "";
//        while (!queue.isEmpty()) {
//            res += queue.poll() + " ";
//        }
//
//        return res.trim();


        /**
         * 全球站高赞解法，看完在看我自己的解法感觉自己像个弱智。。。
         *
         * 思路其实很简单，这个返回只有两种情况，
         * 一个是k在中间，那其实是以' '结尾，直接从' '位置split就行。
         * 另外一种情况就是K包含所有单词，这个就更简单了，直接返回所有单词即可。
         */

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ' && --k == 0) {
                return s.substring(0, i);
            }
        }

        return s;




    }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }