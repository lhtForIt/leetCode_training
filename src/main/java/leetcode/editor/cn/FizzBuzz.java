//写一个程序，输出从 1 到 n 数字的字符串表示。 
//
// 1. 如果 n 是3的倍数，输出“Fizz”； 
//
// 2. 如果 n 是5的倍数，输出“Buzz”； 
//
// 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。 
//
// 示例： 
//
// n = 15,
//
//返回:
//[
//    "1",
//    "2",
//    "Fizz",
//    "4",
//    "Buzz",
//    "Fizz",
//    "7",
//    "8",
//    "Fizz",
//    "Buzz",
//    "11",
//    "Fizz",
//    "13",
//    "14",
//    "FizzBuzz"
//]
// 
// 👍 81 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FizzBuzz {
    public static void main(String[] args) {
        Solution solution = new FizzBuzz().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        public List<String> fizzBuzz(int n) {

            LinkedList result = new LinkedList();
            for (int i = 1; i <= n; i++) {
                if (i % 3 == 0 && i % 5 == 0) {
                    result.add("FizzBuzz");
                } else if (i % 3 == 0) {
                    result.add("Fizz");
                } else if (i % 5 == 0) {
                    result.add("Buzz");
                } else {
                    result.add(String.valueOf(i));
                }
            }

            return result;
        }

        /**
         * 少量映射直接通过分支语句判断
         */
//        public List<String> fizzBuzz(int n) {
//
//            LinkedList result = new LinkedList();
//            for (int i = 1; i <= n; i++) {
//                String temp = "";
//                if (i % 3 == 0) {
//                    temp+="Fizz";
//                }
//                if (i % 5 == 0) {
//                    temp+="Buzz";
//                }
//                if (temp.equals("")) {
//                    temp+=String.valueOf(i);
//                }
//                result.add(temp);
//            }
//
//            return result;
//        }

        /**
         * 如果有很多映射则使用map映射集
         */

//        public List<String> fizzBuzz(int n) {
//
//            LinkedList result = new LinkedList();
//
//            Map<Integer, String> contentMap = new HashMap<>();
//            contentMap.put(3, "Fizz");
//            contentMap.put(5, "Buzz");
//
//            for (int i = 1; i <= n; i++) {
//                String temp = "";
//                for (Integer key : contentMap.keySet()) {
//                    if (i % key == 0) {
//                        if (contentMap.get(key) != null) {
//                            temp += contentMap.get(key);
//                        }
//                    }
//                }
//                if (temp.equals("")) {
//                    temp += String.valueOf(i);
//                }
//                result.add(temp);
//            }
//
//            return result;
//        }
}
//leetcode submit region end(Prohibit modification and deletion)

}