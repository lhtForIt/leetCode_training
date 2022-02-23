//题号：127
//https://leetcode-cn.com/problems/word-ladder/description/
//字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列： 
//
// 
// 序列中第一个单词是 beginWord 。 
// 序列中最后一个单词是 endWord 。 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典 wordList 中的单词。 
// 
//
// 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，找到从 beginWord 到 endWord 的 最短转换序列 中
//的 单词数目 。如果不存在这样的转换序列，返回 0。 
// 
//
// 示例 1： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","lo
//g","cog"]
//输出：5
//解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
// 
//
// 示例 2： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","lo
//g"]
//输出：0
//解释：endWord "cog" 不在字典中，所以无法进行转换。 
//
// 
//
// 提示： 
//
// 
// 1 <= beginWord.length <= 10 
// endWord.length == beginWord.length 
// 1 <= wordList.length <= 5000 
// wordList[i].length == beginWord.length 
// beginWord、endWord 和 wordList[i] 由小写英文字母组成 
// beginWord != endWord 
// wordList 中的所有字符串 互不相同 
// 
// Related Topics 广度优先搜索 
// 👍 705 👎 0

  
package leetcode.editor.cn;


import java.util.*;

public class WordLadder{
      public static void main(String[] args) {
           Solution solution = new WordLadder().new Solution();
          solution.ladderLength("hit", "cog", Arrays.asList(new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    int minLength = Integer.MAX_VALUE;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {


        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();

        beginSet.add(beginWord);
        endSet.add(endWord);

        int step = 1;

        while (!beginSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }


            Set<String> set = new HashSet<>();
            for (String word : beginSet) {
                char[] chars = word.toCharArray();
                for (int k = 0; k < chars.length; k++) {
                    char old = chars[k];
                    for (char i = 'a'; i <= 'z'; i++) {
                        if (old == i) {
                            continue;
                        }
                        chars[k] = i;
                        String str = new String(chars);
                        if (endSet.contains(str)) {
                            return step + 1;
                        }
                        if (wordSet.contains(str)) {
                            set.add(str);
                            wordSet.remove(str);
                        }
                    }
                    chars[k] = old;
                }
            }
            beginSet = set;
            step++;
        }

        return 0;


        /**
         * note at 2022-02-23
         *
         * 大部分逻辑的单向BFS是一致的，在用set替代queue的时候需要注意一下
         *
         *  因为是用set模拟的queue所以需要用一个新的set去装数据然后将原来的set替换掉，
         *  否则会一直重复以前的遍历过程导致超时
         *
         *
         *
         */

//        Set<String> wordSet = new HashSet<>();
//        for (String word:wordList) wordSet.add(word);
//
//        if (beginWord.length() != endWord.length() || !wordSet.contains(endWord)) return 0;
//
//        Set<String> beginSet = new HashSet<>();
//        Set<String> endSet = new HashSet<>();
//
//        beginSet.add(beginWord);
//        endSet.add(endWord);
//
//        int step = 1;
//        //始终保证最小的进行遍历
//        while (!beginSet.isEmpty()) {
//
//            if (endSet.size() < beginSet.size()) {
//                Set<String> temp = beginSet;
//                beginSet = endSet;
//                endSet = temp;
//            }
//
//            //这里因为是用set模拟的queue所以需要用一个新的set去装数据然后将原来的set替换掉，否则会一直重复以前的遍历过程
//            //导致超时
//            Set<String> set = new HashSet<>();
//            for (String s : beginSet) {
//                char[] chars = s.toCharArray();
//                for (int i = 0; i < s.length(); i++) {
//                    char t = chars[i];
//                    for (char j = 'a'; j <= 'z'; j++) {
//                        if (j==chars[i]) continue;
//                        chars[i] = j;
//                        String target = new String(chars);
//                        if (endSet.contains(target)) return step + 1;
//                        if (wordSet.contains(target)) {
//                            wordSet.remove(target);
//                            set.add(target);
//                        }
//                    }
//                    chars[i] = t;
//                }
//            }
//
//            beginSet = set;
//            step++;
//        }
//
//        return 0;






        /**
         * dfs 超时，
         * 这个题其实和基因那道题很类似，区别就是数据规模大了很多，
         * 因此单纯用DFS直接遍历会超时
         *
         * dfs思路是找到所有可能，然后比较其中最小的，
         * 当时数据规模很大的时候，且递归树分支极不平衡的情况下，
         * 遍历所有可能是十分耗时的操作，
         * 极端例子：一个二叉树，左子树10000个节点，右子树3个节点，当找最小子树节点时，
         * dfs，会遍历完两个子树才能得到结果，而bfs只要到第三层就能知道结果，效率差别巨大。
         */
//        Set<String> visited = new HashSet<>();
//        dfs(0, beginWord, endWord, wordList,visited);
//
//        return minLength == Integer.MAX_VALUE ? 0 : minLength;

        /**
         * 单向BFS，
         */
//        Set<String> wordSet = new HashSet<>(wordList);
//        if (!wordList.contains(endWord)) {
//            return 0;
//        }
//        Deque<String> queue = new LinkedList<>();
////        Set<String> visitedSet = new HashSet<>();
//        queue.offer(beginWord);
////        visitedSet.add(beginWord);
//        int len = 1;
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                String str = queue.poll();
//                char[] chs = str.toCharArray();
//                for (int k = 0; k < chs.length; k++) {
//                    char old = chs[k];
//                    for (char j = 'a'; j <= 'z'; j++) {
//                        if (j == chs[k]) {
//                            continue;
//                        }
//                        chs[k] = j;
//                        String target = new String(chs);
//                        if (target.equals(endWord)) {
//                            return len + 1;
//                        }
//                        //参考全球站高赞法三解法
////                        if (!visitedSet.contains(target) && wordSet.contains(target)) {
//                        if (wordSet.contains(target)) {
//                            wordSet.remove(target);
//                            queue.offer(target);
////                            visitedSet.add(target);
//                        }
//                    }
//                    chs[k] = old;
//                }
//            }
//            len++;
//        }
//        return 0;


        /**
         * 双端BFS
         * 为了寻求更快的速度，用Set代替了queue
         * 这里可以直接用wordSet保存访问记录，减少一个visitedSet变量，且wordSet会变小
         */
//        Set<String> wordSet = new HashSet<>(wordList);
//        if (beginWord.length()!=endWord.length()||!wordList.contains(endWord)) return 0;
//        Set<String> beginSet = new HashSet<>();
//        Set<String> endSet = new HashSet<>();
//        beginSet.add(beginWord);
//        endSet.add(endWord);
//        int len = 1;
//        //这里endSet不可能为空的，一开始endSet size为1，后面只有beginSet.size()>endSet才会交换，所以endSet一定是>=1的
//        while (!beginSet.isEmpty()) {
//            if (beginSet.size() > endSet.size()) {
//                Set<String> set = beginSet;
//                beginSet = endSet;
//                endSet = set;
//            }
//            //这个set替换代替了queue.poll()的过程
//            Set<String> temp = new HashSet<>();
//            //这儿比最小基因序列的修改是最小基因因为数据量较小，所以直接可以wordList循环套BeginSet循环，但是这里(数据量大)会不适用，因此优化方案是
//            //去掉wordList遍历，而直接用beginSet去和26个字符转换，然后找打符合条件的，当wordList大于26个元素时，这种方法会比上面快
//            for (String word : beginSet) {
//                char[] chs = word.toCharArray();
//                for (int i = 0; i < chs.length; i++) {
//                    char old = chs[i];
//                    for (char c = 'a'; c <= 'z'; c++) {
//                        if (chs[i] == c) continue;
//                        chs[i] = c;
//                        String target = new String(chs);
//                        //两端都有这个元素即返回
//                        if (endSet.contains(target)) return len + 1;
//                        if (wordSet.contains(target)) {
//                            wordSet.remove(target);
//                            temp.add(target);
//                        }
//                    }
//                    chs[i]=old;
//                }
//            }
//            beginSet = temp;
//            len++;
//        }
//        return 0;

        /**
         * 全球站高赞双向BFS
         * 看着和一般的BFS不一样，没有用queue
         *
         * 纠正个误区，bfs不一定要用queue
         *
         */

//        if (!wordList.contains(endWord)) {
//            return 0;
//        }
//        Set<String> wordSet = new HashSet<>(wordList);
//        Set<String> beginSet = new HashSet<>();
//        Set<String> endSet = new HashSet<>();
//        //这里以1为初始值的原因，因为hit->hio这种结果是2而不是1，因此初始值需要是1
//        int len = 1;
//        HashSet<String> visited = new HashSet<>();
//        beginSet.add(beginWord);
//        endSet.add(endWord);
//        wordList.remove(beginWord);
//        wordList.remove(endWord);
//        //endSet一直不为空？
//        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
//            //始终让beginSet最小
//            if (beginSet.size() > endSet.size()) {
//                Set<String> set = beginSet;
//                beginSet = endSet;
//                endSet = set;
//            }
//            Set<String> temp = new HashSet<>();
//            for (String word : beginSet) {
//                char[] chs = word.toCharArray();
//                for (int i = 0; i < chs.length; i++) {
//                    for (char c = 'a'; c <= 'z'; c++) {
//                        //当前字符相等就没必要转换了
//                        if (c == chs[i]) {
//                            continue;
//                        }
//                        char old = chs[i];
//                        chs[i] = c;
//                        String target = new String(chs);
//                        if (endSet.contains(target)) {
//                            return len + 1;
//                        }
//                        if (!visited.contains(target) && wordSet.contains(target)) {
//                            temp.add(target);
//                            visited.add(target);
//                        }
//                        chs[i] = old;
//                    }
//                }
//            }
//            beginSet = temp;
//            len++;
//        }
//        return 0;

        /**
         * 全球站法二
         */
//        if (beginWord == null || endWord == null || beginWord.length() != endWord.length()||!wordList.contains(endWord)) return 0;
//
//        Set<String> reached = new HashSet<>();
//        Set<String> wordDict = new HashSet<>(wordList);
//        reached.add(beginWord);
//        wordDict.add(endWord);
//        int distance = 1;
//        while (!reached.contains(endWord)) {
//            Set<String> toAdd = new HashSet<>();
//            for (String each : reached) {
//                for (int i = 0; i < each.length(); i++) {
//                    char[] chars = each.toCharArray();
//                    for (char ch = 'a'; ch <= 'z'; ch++) {
//                        chars[i] = ch;
//                        String word = new String(chars);
//                        if (wordDict.contains(word)) {
//                            toAdd.add(word);
//                            wordDict.remove(word);
//                        }
//                    }
//                }
//            }
//            distance++;
//            if (toAdd.size() == 0) return 0;
//            reached = toAdd;
//        }
//        return distance;

        /**
         * 全球站法三 2,3都是BFS
         *
         * 这个虽然是BFS，但是思路和奇妙，常规都是用一个set记录访问，然后用
         * !visited.contains(target) && wordSet.contains(target)这个去判断，
         * 但是这个思路是每次碰到包含的元素直接移出wordSet，这样wordSet变小，
         * 且少访问一个visitedSet，因为java的set.contain()是近似O(1)，如果有hash冲突
         * 其实还是有消耗的
         *
         *
         */
//        if (!wordList.contains(endWord)) return 0;
//        HashSet<String> set = new HashSet<>(wordList);
//        Queue<String> q = new LinkedList<>();
//        int length = 0;
//        q.add(beginWord);
//        while (!q.isEmpty()) {
//            int size = q.size();
//            for (int i = 0; i < size; i++) {
//                String w = q.poll();
//                if (w.equals(endWord)) return length + 1;
//                wordMatch(w, set, q);
//            }
//            length++;
//        }
//        return 0;
    }
          private void wordMatch(String w, Set<String> set, Queue<String> q) {
              for (int i = 0; i < w.length(); i++) {
                  char[] word = w.toCharArray();
                  for (int j = 0; j < 26; j++) {
                      char c = (char) ('a' + j);
                      if (word[i] == c) continue;
                      word[i] = c;
                      String s = String.valueOf(word);
                      if (set.contains(s)) {
                          set.remove(s);
                          q.offer(s);
                      }
                  }
              }
          }

          private void dfs(int level, String beginWord, String endWord, List<String> wordList, Set<String> visited) {
              if (beginWord.equals(endWord)) {
                  minLength = Math.min(minLength, level+1);
                  return;
              }

              for (String str : wordList) {

                  int diff = 0;
                  for (int i = 0; i < str.length(); i++) {
                      //与单词库里每一个对比
                      if (beginWord.charAt(i) != str.charAt(i)) {
                          if (++diff > 1) break;
                      }
                  }

                  if (diff == 1 && !visited.contains(str)) {
                      visited.add(str);
                      dfs(level + 1, str, endWord, wordList, visited);
                      visited.remove(str);
                  }

              }


          }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }