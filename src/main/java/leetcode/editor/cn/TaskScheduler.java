//题号：621
//给你一个用字符数组 tasks 表示的 CPU 需要执行的任务列表。其中每个字母表示一种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个
//单位时间内执行完。在任何一个单位时间，CPU 可以完成一个任务，或者处于待命状态。 
//
// 然而，两个 相同种类 的任务之间必须有长度为整数 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。 
//
// 你需要计算完成所有任务所需要的 最短时间 。 
//
// 
//
// 示例 1： 
//
// 
//输入：tasks = ["A","A","A","B","B","B"], n = 2
//输出：8
//解释：A -> B -> (待命) -> A -> B -> (待命) -> A -> B
//     在本示例中，两个相同类型任务之间必须间隔长度为 n = 2 的冷却时间，而执行一个任务只需要一个单位时间，所以中间出现了（待命）状态。 
//
// 示例 2： 
//
// 
//输入：tasks = ["A","A","A","B","B","B"], n = 0
//输出：6
//解释：在这种情况下，任何大小为 6 的排列都可以满足要求，因为 n = 0
//["A","A","A","B","B","B"]
//["A","B","A","B","A","B"]
//["B","B","B","A","A","A"]
//...
//诸如此类
// 
//
// 示例 3： 
//
// 
//输入：tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
//输出：16
//解释：一种可能的解决方案是：
//     A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> (待命) -> (待命) -> A -> (待
//命) -> (待命) -> A
// 
//
// 
//
// 提示： 
//
// 
// 1 <= task.length <= 104 
// tasks[i] 是大写英文字母 
// n 的取值范围为 [0, 100] 
// 
// Related Topics 贪心算法 队列 数组 
// 👍 649 👎 0

  
package leetcode.editor.cn;

import java.util.*;

public class TaskScheduler{
      public static void main(String[] args) {
           Solution solution = new TaskScheduler().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int leastInterval(char[] tasks, int n) {
        /**
         * 全球站高赞解法：贪心？
         */
//        int[] counter = new int[26];
//        int max = 0;
//        int maxCount = 0;
//        for(char task : tasks) {
//            counter[task - 'A']++;
//            if(max == counter[task - 'A']) {
//                maxCount++;
//            }
//            else if(max < counter[task - 'A']) {
//                max = counter[task - 'A'];
//                maxCount = 1;
//            }
//        }
//
//        int partCount = max - 1;
//        int partLength = n - (maxCount - 1);
//        int emptySlots = partCount * partLength;
//        int availableTasks = tasks.length - max * maxCount;
//        int idles = Math.max(0, emptySlots - availableTasks);
//
//        return tasks.length + idles;

        /**
         * 法二：这个最快
         */

//        int[] c = new int[26];
//        for(char t : tasks){
//            c[t - 'A']++;
//        }
//        Arrays.sort(c);
//        int i = 25;
//        while(i >= 0 && c[i] == c[25]) i--;
//
//        return Math.max(tasks.length, (c[25] - 1) * (n + 1) + 25 - i);


        /**
         * 优先级队列
         */

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1); // map key is TaskName, and value is number of times to be executed.
        }
        PriorityQueue<Map.Entry<Character, Integer>> q = new PriorityQueue<>( //frequency sort
                (a,b) -> a.getValue() != b.getValue() ? b.getValue() - a.getValue() : a.getKey() - b.getKey());

        q.addAll(map.entrySet());

        int count = 0;
        while (!q.isEmpty()) {
            int k = n + 1;
            List<Map.Entry> tempList = new ArrayList<>();
            while (k > 0 && !q.isEmpty()) {
                Map.Entry<Character, Integer> top = q.poll(); // most frequency task
                top.setValue(top.getValue() - 1); // decrease frequency, meaning it got executed
                tempList.add(top); // collect task to add back to queue
                k--;
                count++; //successfully executed task
            }

            for (Map.Entry<Character, Integer> e : tempList) {
                if (e.getValue() > 0) q.add(e); // add valid tasks
            }

            if (q.isEmpty()) break;
            count = count + k; // if k > 0, then it means we need to be idle
        }
        return count;

    }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }