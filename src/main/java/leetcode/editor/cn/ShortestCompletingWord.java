//题号：748
//给你一个字符串 licensePlate 和一个字符串数组 words ，请你找出并返回 words 中的 最短补全词 。 
//
// 补全词 是一个包含 licensePlate 中所有的字母的单词。在所有补全词中，最短的那个就是 最短补全词 。 
//
// 在匹配 licensePlate 中的字母时： 
//
// 
// 忽略 licensePlate 中的 数字和空格 。 
// 不区分大小写。 
// 如果某个字母在 licensePlate 中出现不止一次，那么该字母在补全词中的出现次数应当一致或者更多。 
// 
//
// 例如：licensePlate = "aBc 12c"，那么它的补全词应当包含字母 'a'、'b' （忽略大写）和两个 'c' 。可能的 补全词 有 "a
//bccdef"、"caaacab" 以及 "cbca" 。 
//
// 请你找出并返回 words 中的 最短补全词 。题目数据保证一定存在一个最短补全词。当有多个单词都符合最短补全词的匹配条件时取 words 中 最靠前的 
//那个。 
//
// 
//
// 示例 1： 
//
// 
//输入：licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]
//输出："steps"
//解释：最短补全词应该包括 "s"、"p"、"s"（忽略大小写） 以及 "t"。
//"step" 包含 "t"、"p"，但只包含一个 "s"，所以它不符合条件。
//"steps" 包含 "t"、"p" 和两个 "s"。
//"stripe" 缺一个 "s"。
//"stepple" 缺一个 "s"。
//因此，"steps" 是唯一一个包含所有字母的单词，也是本例的答案。 
//
// 示例 2： 
//
// 
//输入：licensePlate = "1s3 456", words = ["looks", "pest", "stew", "show"]
//输出："pest"
//解释：licensePlate 只包含字母 "s" 。所有的单词都包含字母 "s" ，其中 "pest"、"stew"、和 "show" 三者最短。答案是 
//"pest" ，因为它是三个单词中在 words 里最靠前的那个。
// 
//
// 示例 3： 
//
// 
//输入：licensePlate = "Ah71752", words = ["suggest","letter","of","husband","easy"
//,"education","drug","prevent","writer","old"]
//输出："husband"
// 
//
// 示例 4： 
//
// 
//输入：licensePlate = "OgEu755", words = ["enough","these","play","wide","wonder",
//"box","arrive","money","tax","thus"]
//输出："enough"
// 
//
// 示例 5： 
//
// 
//输入：licensePlate = "iMSlpe4", words = ["claim","consumer","student","camera","p
//ublic","never","wonder","simple","thought","use"]
//输出："simple"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= licensePlate.length <= 7 
// licensePlate 由数字、大小写字母或空格 ' ' 组成 
// 1 <= words.length <= 1000 
// 1 <= words[i].length <= 15 
// words[i] 由小写英文字母组成 
// 
// Related Topics 数组 哈希表 字符串 
// 👍 72 👎 0

  
package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class ShortestCompletingWord{
      public static void main(String[] args) {
           Solution solution = new ShortestCompletingWord().new Solution();
          solution.shortestCompletingWord("1s3 456", new String[]{"looks","pest","stew","show"});
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          private final int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};

          public String shortestCompletingWord(String licensePlate, String[] words) {


              /**
               * 全球站高赞解法
               */

              long charProduct = getCharProduct(licensePlate.toLowerCase());
              String shortest = "aaaaaaaaaaaaaaaaaaaa"; // 16 a's
              for(String word : words)
                  if (word.length() < shortest.length() && getCharProduct(word) % charProduct == 0)
                      shortest = word;
              return shortest;













              /**
               * 数组代替map实现
               */
//        int[] charMap = new int[26];
//        for (Character c : licensePlate.toLowerCase().toCharArray()) {
//            if (Character.isLetter(c)) {
//                charMap[c - 'a']++;
//            }
//        }
//
//
//        int minLength = Integer.MAX_VALUE;
//        String res = null;
//        for (String word : words) {
//            int[] targetMap = new int[26];
//            for (char c : word.toCharArray()) {
//                targetMap[c - 'a']++;
//            }
//            boolean flag = true;
//            for (int i = 0; i < charMap.length; i++) {
//                if (charMap[i] != 0 && charMap[i] > targetMap[i]) {
//                    flag = false;
//                    break;
//                }
//            }
//            if (flag && minLength > word.length()) {
//                minLength = word.length();
//                res = word;
//            }
//        }
//
//        return res;














        /**
         * 自己的思路，用map去存每个key，然后比较
         * 其实我一开始想到用数组去弄得，但是感觉时间复杂度有点高，实现复杂就没弄，其实实现也不复杂，
         * 我现在有个很大的问题，稍微难一点的东西就有点不想去实现，需要改掉这个坏习惯
         */
//        Map<Character, Integer> map = new HashMap<>();
//
//        for (char c : licensePlate.toLowerCase().toCharArray()) {
//            if (Character.isDigit(c) || c == ' ') {
//                continue;
//            }
//            map.put(c, map.getOrDefault(c, 0) + 1);
//        }
//
//
//
//        int minLength = Integer.MAX_VALUE;
//        String res = null;
//
//        for (String word : words) {
//            Map<Character, Integer> newMap = new HashMap<>();
//            for (char c : word.toCharArray()) {
//                newMap.put(c, newMap.getOrDefault(c, 0) + 1);
//            }
//
//            boolean flag = true;
//            for (Character key : map.keySet()) {
//                if (!newMap.containsKey(key) || newMap.get(key) < map.get(key)) {
//                    flag = false;
//                    break;
//                }
//            }
//            if (flag && minLength > word.length()) {
//                minLength = word.length();
//                res = word;
//            }
//        }
//
//        return res;









    }

          private long getCharProduct(String plate) {
              long product = 1L;
              for (char c : plate.toCharArray()) {
                  int index = c - 'a';
                  if (0 <= index && index <= 25)
                      product *= primes[index];
              }
              return product;
          }


}
//leetcode submit region end(Prohibit modification and deletion)

  }