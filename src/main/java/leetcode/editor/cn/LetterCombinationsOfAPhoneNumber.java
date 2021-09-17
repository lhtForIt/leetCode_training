//题号：17
//https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 深度优先搜索 递归 字符串 回溯算法 
// 👍 1201 👎 0

  
package leetcode.editor.cn;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import java.util.*;
import java.util.logging.Level;

public class LetterCombinationsOfAPhoneNumber{
      public static void main(String[] args) {
           Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
          solution.letterCombinations("23");
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    //0,1为空的原因是因为电话号码是从2-9，0，1没有mapping关系
    private final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {

        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }


        Map<Character, String> strMap = new HashMap<>();
        strMap.put('2', "abc");
        strMap.put('3', "def");
        strMap.put('4', "ghi");
        strMap.put('5', "jkl");
        strMap.put('6', "mno");
        strMap.put('7', "pqrs");
        strMap.put('8', "tuv");
        strMap.put('9', "wxyz");

        recuv(res, digits, strMap, 0, "");

        return res;












        /**
         * 图标为hashMap在做hash映射的时候有时间消耗，所以自己用数组实现的话会比用Map快
         */
//        List<String> res = new ArrayList<>();
//        if (digits == null || digits.length() == 0) {
//            return res;
//        }
//
//        String[] numArray = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
//
//        recurArray(0, res, digits, numArray, new StringBuilder());
//
//        return res;






        /**
         * 递归用Map存储
         * 时间复杂度：O(3^m * 4^n)，其中 mm 是输入中对应 33 个字母的数字个数（包括数字 22、33、44、55、66、88），nn 是输入中对应 44 个字母的数字个数（包括数字 77、99），m+nm+n 是输入数字的总个数。
         * 空间复杂度：O(m+n)
         */
//        List<String> res = new ArrayList<>();
//        if (digits == null || digits.length() == 0) {
//            return res;
//        }
//        Map<Character, String> numMap = new HashMap<>();
//        numMap.put('2', "abc");
//        numMap.put('3', "def");
//        numMap.put('4', "ghi");
//        numMap.put('5', "jkl");
//        numMap.put('6', "mno");
//        numMap.put('7', "pqrs");
//        numMap.put('8', "tuv");
//        numMap.put('9', "wxyz");
//        //这里的递归层数表示操作第几个字符
//        recur(0, numMap, res, digits, new StringBuilder());
//        //用string的话可以不用重置状态
////        testRecur(0, numMap, res, digits, "");
//
//
//        return res;


        /**
         * 用队列
         */
//        LinkedList<String> ans = new LinkedList<>();
//        if(digits.isEmpty()) return ans;
//        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
//        ans.add("");
//        while(ans.peek().length()!=digits.length()){
//            String remove = ans.remove();
//            String map = mapping[digits.charAt(remove.length())-'0'];
//            for(char c: map.toCharArray()){
//                ans.addLast(remove+c);
//            }
//        }
//        return ans;

        /**
         * 递归用数组存储
         */

//        List<String> res = new ArrayList<>();
//        if (digits == null || digits.length() == 0) {
//            return res;
//        }
//
//        recure(0, digits, res,new StringBuilder());
//        return res;



    }

          /**
           * 这里for(i)循环和foreach循环都可以，需要注意的一点是，str的改变如果是在外面需要在后续重置状态，否则会出问题,因为会将str的状态带到下一层去
           */
          private void recuv(List<String> res, String digits, Map<Character, String> strMap, int level, String str) {

              if (level == digits.length()) {
                  res.add(str);
                  return;
              }

              for (char cs : strMap.get(digits.charAt(level)).toCharArray()) {
                  recuv(res, digits, strMap, level + 1, str + cs);
              }

          }

          private void testRecur(int level, Map<Character, String> numMap, List<String> res, String digits, String s) {
              if (level == digits.length()) {
                  res.add(s);
                  return;
              }

              String str = numMap.get(digits.charAt(level));
              for (int i = 0; i < str.length(); i++) {
                  //这儿能直接下探而不需要重置状态是因为string这个类型虽然是引用类型，
                  //但是和int这种基础类型是一样的,在函数里面改变值不会影响原来的数值,如果是其他引用类型则
                  //需要重置原来的状态
                  testRecur(level + 1, numMap, res, digits, s + str.charAt(i));
              }

          }

          private void recurArray(int level, List<String> res, String digits, String[] numArray, StringBuilder s) {


              if (level == digits.length()) {
                  res.add(s.toString());
                  return;
              }

              String str = numArray[digits.charAt(level) - '0'];

              for (int i = 0; i < str.length(); i++) {
                  s.append(str.charAt(i));
                  recurArray(level + 1, res, digits, numArray, s);
                  s.deleteCharAt(s.length() - 1);
              }











          }


          private void recure(int level, String digits, List<String> res, StringBuilder s) {

              if (level == digits.length()) {
                  res.add(s.toString());
                  return;
              }


              //查看当前数字对应的是第几个str
              String str = KEYS[digits.charAt(level) - '0'];
              for (int i = 0; i < str.length(); i++) {
                  s.append(str.charAt(i));
                  recure(level + 1, digits, res, s);
                  s.deleteCharAt(s.length() - 1);
              }
          }

          private void recur(int level, Map<Character, String> numMap, List<String> res, String digits, StringBuilder s) {

              if (level == digits.length()) {
                  res.add(s.toString());
                  return;
              }

              String str = numMap.get(digits.charAt(level));

              for (int i = 0; i < str.length(); i++) {
                  s.append(str.charAt(i));
                  recur(level + 1, numMap, res, digits, s);
                  s.deleteCharAt(s.length() - 1);
              }

          }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }