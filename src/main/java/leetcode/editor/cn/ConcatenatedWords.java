//题号：472
//给你一个 不含重复 单词的字符串数组 words ，请你找出并返回 words 中的所有 连接词 。 
//
// 连接词 定义为：一个完全由给定数组中的至少两个较短单词组成的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：words = ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","ra
//t","ratcatdogcat"]
//输出：["catsdogcats","dogcatsdog","ratcatdogcat"]
//解释："catsdogcats" 由 "cats", "dog" 和 "cats" 组成; 
//     "dogcatsdog" 由 "dog", "cats" 和 "dog" 组成; 
//     "ratcatdogcat" 由 "rat", "cat", "dog" 和 "cat" 组成。
// 
//
// 示例 2： 
//
// 
//输入：words = ["cat","dog","catdog"]
//输出：["catdog"] 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 104 
// 0 <= words[i].length <= 1000 
// words[i] 仅由小写字母组成 
// 0 <= sum(words[i].length) <= 105 
// 
// Related Topics 深度优先搜索 字典树 数组 字符串 动态规划 
// 👍 155 👎 0

  
package leetcode.editor.cn;

import java.util.*;

public class ConcatenatedWords{
      public static void main(String[] args) {
           Solution solution = new ConcatenatedWords().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        /**
         * 法一
         */
        List<String> result = new ArrayList<>();
        Set<String> preWords = new HashSet<>();
        Arrays.sort(words, (s1, s2) -> s1.length() - s2.length());

        for (int i = 0; i < words.length; i++) {
            if (canForm(words[i], preWords)) {
                result.add(words[i]);
            }
            preWords.add(words[i]);
        }

        return result;




    }



              private boolean canForm(String word, Set<String> dict) {
              if (dict.isEmpty()) return false;
              boolean[] dp = new boolean[word.length() + 1];
              dp[0] = true;
              for (int i = 1; i <= word.length(); i++) {
                  for (int j = 0; j < i; j++) {
                      if (!dp[j]) continue;
                      if (dict.contains(word.substring(j, i))) {
                          dp[i] = true;
                          break;
                      }
                  }
              }
              return dp[word.length()];
          }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }