//题号：126
//https://leetcode-cn.com/problems/word-ladder-ii/description/
//给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换
//需遵循如下规则： 
//
// 
// 每次转换只能改变一个字母。 
// 转换后得到的单词必须是字典中的单词。 
// 
//
// 说明: 
//
// 
// 如果不存在这样的转换序列，返回一个空列表。 
// 所有单词具有相同的长度。 
// 所有单词只由小写字母组成。 
// 字典中不存在重复的单词。 
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。 
// 
//
// 示例 1: 
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出:
//[
//  ["hit","hot","dot","dog","cog"],
//  ["hit","hot","lot","log","cog"]
//]
// 
//
// 示例 2: 
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: []
//
//解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。 
// Related Topics 广度优先搜索 数组 字符串 回溯算法 
// 👍 398 👎 0

  
package leetcode.editor.cn;

import java.util.*;

public class WordLadderIi{
      public static void main(String[] args) {
           Solution solution = new WordLadderIi().new Solution();
          solution.findLadders("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        /**
         * 这个题比上一个题只求路径最大值又复杂了点，因此不能单单用BFS，还需要结合DFS一起使用，因为DFS在知道
         * 起点和终点的情况下寻路是最快的。
         *
         * 在进行BFS时我们将当前节点和它下一层节点关系存储起来，
         *
         * 这道题DFS+剪枝能做么？
         *
         */

        /**
         * BFS+DFS
         *
         *
         */
//        List<List<String>> res = new ArrayList<>();
//        if (!wordList.contains(endWord)) {
//            return res;
//        }
//        HashSet<String> dict = new HashSet<>(wordList);
//
//        HashMap<String, ArrayList<String>> nodeNeighbors = new HashMap<>();// Neighbors for every node
//        HashMap<String, Integer> distance = new HashMap<>();// Distance of every node from the start node
//
//        ArrayList<String> solution = new ArrayList<>();
//
//        dict.add(beginWord);
//        bfd(beginWord,endWord,dict,nodeNeighbors,distance);
//        dfs(beginWord,endWord,dict,nodeNeighbors,distance,solution,res);
//
//        return res;

        /**
         * 双向BFS+dfs
         */
//        List<List<String>> res = new ArrayList<>();
//        HashSet<String> dict = new HashSet<>(wordList);
//        if(!dict.contains(endWord)){
//            return res;
//        }
//        HashSet<String> set1 = new HashSet<>();
//        HashSet<String> set2 = new HashSet<>();
//
//        set1.add(beginWord);
//        set2.add(endWord);
//        HashMap<String, List<String>> map = new HashMap<>();
//        bfs1(map, set1, set2, dict, false);
//
//        List<String> path = new ArrayList<>();
//        path.add(beginWord);
//        dfs1(res, path, map, beginWord, endWord);
//        return res;

        /**
         * 全球站另一种双向BFS+DFS
         * 效率十分快
         */

//        Set<String> dict = new HashSet<>(wordList);
//        List<List<String>> res = new ArrayList<>();
//        if (!dict.contains(endWord)) {
//            return res;
//        }
//        Map<String, List<String>> map = bfs2(beginWord, endWord, dict);
//        List<String> path = new ArrayList<>();
//        path.add(beginWord);
//        dfs2(beginWord, endWord, map, res, path);
//        return res;

//        Set<String> wordSet = new HashSet<>(wordList);
//        List<List<String>> res = new ArrayList<>();
//        if (!wordSet.contains(endWord)) {
//            return res;
//        }
//
//        Map<String, List<String>> nodeMap = myBfs(beginWord, endWord, wordSet);
//        //一开始起始点是不包含的，因此要将起始字符串放进去
//        List<String> path = new ArrayList<>();
//        path.add(beginWord);
//        myDfs(beginWord, endWord, nodeMap, path, res);
//
//
//        return res;


        Set<String> wordSet = new HashSet<>(wordList);
        List<List<String>> res = new ArrayList<>();
        if (!wordSet.contains(endWord)) {
            return res;
        }

        Map<String, List<String>> nodeMap = bfsTemp(beginWord, endWord, wordSet);


        List<String> subRes = new ArrayList<>();
        subRes.add(beginWord);
        dfsTemp(beginWord, endWord, nodeMap, res, subRes);

        return res;

    }

          private void dfsTemp(String beginWord, String endWord, Map<String, List<String>> nodeMap, List<List<String>> res, List<String> subRes) {
              if (beginWord.equals(endWord)) {
                  res.add(new ArrayList<>(subRes));
                  return;
              }

              if (!nodeMap.containsKey(beginWord)) {
                  return;
              }

              for (String str : nodeMap.get(beginWord)) {
                  subRes.add(str);
                  dfsTemp(str, endWord, nodeMap, res, subRes);
                  subRes.remove(subRes.size() - 1);
              }
          }

          private Map<String, List<String>> bfsTemp(String beginWord, String endWord, Set<String> wordSet) {
              Set<String> beginSet = new HashSet<>();
              Set<String> endSet = new HashSet<>();
              Set<String> visitedSet = new HashSet<>();
              Map<String, List<String>> nodeMap = new HashMap<>();
              beginSet.add(beginWord);
              endSet.add(endWord);
              boolean done = false;
              boolean reverse = false;
              while (!beginSet.isEmpty() && !done) {
                  if (beginSet.size() > endSet.size()) {
                      Set<String> set = beginSet;
                      beginSet = endSet;
                      endSet = set;
                      reverse = !reverse;
                  }
                  Set<String> tempSet = new HashSet<>();
                  for (String str : beginSet) {
                      visitedSet.add(str);
                      char[] chars = str.toCharArray();
                      for (int i = 0; i < chars.length; i++) {
                          char old = chars[i];
                          for (char c = 'a'; c <= 'z'; c++) {
                              if (chars[i] == c) {
                                  continue;
                              }
                              chars[i] = c;
                              String target = new String(chars);
                              if (endSet.contains(target)) {
                                  done = true;
                              }
                              if (!visitedSet.contains(target) && !beginSet.contains(target) && wordSet.contains(target)) {
                                  tempSet.add(target);
                                  String node = reverse ? target : str;
                                  String next = reverse ? str : target;
                                  if (!nodeMap.containsKey(node)) {
                                      nodeMap.put(node, new ArrayList<>());
                                  }
                                  nodeMap.get(node).add(next);
                              }
                          }
                          chars[i] = old;
                      }
                  }
                  beginSet = tempSet;
              }

              return nodeMap;





          }


          private void myDfs(String beginWord, String endWord, Map<String, List<String>> nodeMap, List<String> path, List<List<String>> res) {

              if (beginWord.equals(endWord)) {
                  res.add(new ArrayList<>(path));
                  return;
              }

              //map可能不包含beginWord
              if (!nodeMap.containsKey(beginWord)) {
                  return;
              }

              for (String str : nodeMap.get(beginWord)) {
                  path.add(str);
                  myDfs(str, endWord, nodeMap, path, res);
                  path.remove(path.size() - 1);
              }

          }

          private Map<String, List<String>> myBfs(String beginWord, String endWord, Set<String> wordSet) {

              Set<String> beginSet = new HashSet<>();
              Set<String> endSet = new HashSet<>();
              beginSet.add(beginWord);
              endSet.add(endWord);

              boolean done = false;
              boolean revert = false;
              Map<String, List<String>> nodeMap = new HashMap<>();
              Set<String> visitSet = new HashSet<>();
              while (!beginSet.isEmpty() && !done) {
                  if (beginSet.size() > endSet.size()) {
                      Set<String> temp = beginSet;
                      beginSet = endSet;
                      endSet = temp;
                      revert = !revert;
                  }
                  Set<String> set = new HashSet<>();
                  for (String str : beginSet) {
                      visitSet.add(str);
                      char[] chars = str.toCharArray();
                      for (int i=0;i<str.length();i++) {
                          char old = chars[i];
                          for (char c = 'a'; c <= 'z'; c++) {
                              if (chars[i] == c) {
                                  continue;
                              }
                              chars[i] = c;
                              String target = new String(chars);
                              if (endSet.contains(target)) {
                                  done = true;
                              }
                              //这里不能remove，因为字典里面每个词可能会用到多次
                              //beginSet代表不能往回走
                              if (!visitSet.contains(target) && !beginSet.contains(target) && wordSet.contains(target)) {
                                  String node = revert ? target : str;
                                  String next = revert ? str : target;
                                  if (!nodeMap.containsKey(node)) {
                                      nodeMap.put(node, new ArrayList<>());
                                  }
                                  nodeMap.get(node).add(next);
                                  set.add(target);
                              }

                          }
                          chars[i] = old;
                      }
                  }
                  beginSet = set;
              }

              return nodeMap;

          }

          public void dfs2(String beginWord, String endWord, Map<String, List<String>> map, List<List<String>> res, List<String> path) {
              if (beginWord.equals(endWord)) {
                  res.add(new ArrayList<>(path));
              }
              if (!map.containsKey(beginWord)) {
                  return;
              }
              for (String next : map.get(beginWord)) {
                  path.add(next);
                  dfs2(next, endWord, map, res, path);
                  path.remove(path.size() - 1);
              }
          }


          public Map<String, List<String>> bfs2(String beginWord, String endWord, Set<String> dict) {
              Map<String, List<String>> map = new HashMap<>();
              Set<String> start = new HashSet<>();
              start.add(beginWord);
              Set<String> end = new HashSet<>();
              Set<String> visited = new HashSet<>();
              end.add(endWord);
              boolean found = false;
              //代表两端是否进行了互换,如果进行了交换，
              //如果一开始是begin方向，从A->B,进行转换之后就是从B->A，
              //方向会变，因此在转向之后key和value值顺序也要变,map的key和value需要进行互换
              boolean isBackward = false;
              while (!start.isEmpty() && !found) {
                  if (start.size() > end.size()) {
                      Set<String> temp = start;
                      start = end;
                      end = temp;
                      isBackward = !isBackward;
                  }
                  Set<String> set = new HashSet<>();
                  for (String cur : start) {
                      visited.add(cur);
                      for (String next : getNext(cur, dict)) {
                          if (visited.contains(next) || start.contains(next)) {
                              continue;
                          }
                          if (end.contains(next)) {
                              found = true;
                          }
                          set.add(next);
                          String parent = isBackward ? next : cur;
                          String child = isBackward ? cur : next;
                          if (!map.containsKey(parent)) {
                              map.put(parent, new ArrayList<>());
                          }
                          map.get(parent).add(child);
                      }
                  }
                  start = set;
              }
              return map;

          }


          private List<String> getNext(String cur, Set<String> dict) {
              List<String> res = new ArrayList<>();
              char[] chars = cur.toCharArray();
              for (int i = 0; i < chars.length; i++) {
                  char old = chars[i];
                  for (char c = 'a'; c <= 'z'; c++) {
                      if (c == old) {
                          continue;
                      }
                      chars[i] = c;
                      String next = new String(chars);
                      if (dict.contains(next)) {
                          res.add(next);
                      }
                  }
                  chars[i] = old;
              }
              return res;
          }



          private void dfs1(List<List<String>> res, List<String> path, HashMap<String, List<String>> map, String start, String end){
              if(start.equals(end)){
                  res.add(new ArrayList<>(path));
                  return;
              }

              if(!map.containsKey(start)){
                  return;
              }

              for(String next : map.get(start)){
                  path.add(next);
                  dfs1(res, path, map, next, end);
                  path.remove(path.size() - 1);
              }
          }

          private void bfs1(HashMap<String, List<String>> map, HashSet<String> set1, HashSet<String> set2, HashSet<String> dict, boolean flip){
              if(set1.isEmpty()){
                  return;
              }
              if(set1.size() > set2.size()){
                  bfs1(map, set2, set1, dict, !flip);
                  return;
              }
              boolean done = false;
              dict.removeAll(set1);
              dict.removeAll(set2);
              HashSet<String> next = new HashSet<>();
              for(String str : set1){
                  char[] chs = str.toCharArray();
                  for(int i = 0; i < chs.length; i++){
                      char temp = chs[i];
                      for(char ch = 'a'; ch <= 'z'; ch++){
                          if(chs[i] != ch){
                              chs[i] = ch;
                              String word = new String(chs);
                              String key = flip ? word : str;
                              String val = flip ? str : word;
                              List<String> list = map.get(key) == null ? new ArrayList<>() : map.get(key);
                              if(set2.contains(word)){
                                  done = true;
                                  list.add(val);
                                  map.put(key, list);
                              }
                              if(!done && dict.contains(word)){
                                  next.add(word);
                                  list.add(val);
                                  map.put(key, list);
                              }
                          }
                      }
                      chs[i] = temp;
                  }
              }
              if(!done){
                  bfs1(map, set2, next, dict, !flip);
              }
          }

          private void bfd(String beginWord, String endWord, Set<String> dict, HashMap<String, ArrayList<String>> nodeNeighbors, HashMap<String, Integer> distance) {
              for (String str : dict) {
                  nodeNeighbors.put(str, new ArrayList<>());
              }

              Deque<String> queue = new LinkedList<>();
              queue.offer(beginWord);
              distance.put(beginWord, 0);

              while (!queue.isEmpty()) {

                  int count = queue.size();
                  boolean foundEnd = false;

                  for (int i = 0; i < count; i++) {
                      String cur = queue.poll();
                      int curDistance = distance.get(cur);
                      ArrayList<String> neighbors = getNeighbors(cur, dict);


                      for (String neighbor : neighbors) {
                          nodeNeighbors.get(cur).add(neighbor);
                          if (!distance.containsKey(neighbor)) {// Check if visited
                              distance.put(neighbor, curDistance + 1);
                              if (endWord.equals(neighbor))// Found the shortest path
                                  foundEnd = true;
                              else
                                  queue.offer(neighbor);
                          }
                      }
                  }
                  if (foundEnd)
                      break;

              }

          }

          private ArrayList<String> getNeighbors(String node, Set<String> dict) {

              ArrayList<String> res = new ArrayList<>();
              char chs[] = node.toCharArray();

              for (char ch ='a'; ch <= 'z'; ch++) {
                  for (int i = 0; i < chs.length; i++) {
                      if (chs[i] == ch) continue;
                      char old_ch = chs[i];
                      chs[i] = ch;
                      if (dict.contains(String.valueOf(chs))) {
                          res.add(String.valueOf(chs));
                      }
                      chs[i] = old_ch;
                  }

              }
              return res;





          }

          // DFS: output all paths with the shortest distance.
          private void dfs(String cur, String end, Set<String> dict, HashMap<String, ArrayList<String>> nodeNeighbors, HashMap<String, Integer> distance, ArrayList<String> solution, List<List<String>> res) {
              solution.add(cur);
              if (end.equals(cur)) {
                  res.add(new ArrayList<>(solution));
              } else {
                  for (String next : nodeNeighbors.get(cur)) {
                      if (distance.get(next) == distance.get(cur) + 1) {
                          dfs(next, end, dict, nodeNeighbors, distance, solution, res);
                      }
                  }
              }
              solution.remove(solution.size() - 1);
          }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }