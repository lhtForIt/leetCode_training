//题号：1576
//给你一个仅包含小写英文字母和 '?' 字符的字符串 s，请你将所有的 '?' 转换为若干小写字母，使最终的字符串不包含任何 连续重复 的字符。 
//
// 注意：你 不能 修改非 '?' 字符。 
//
// 题目测试用例保证 除 '?' 字符 之外，不存在连续重复的字符。 
//
// 在完成所有转换（可能无需转换）后返回最终的字符串。如果有多个解决方案，请返回其中任何一个。可以证明，在给定的约束条件下，答案总是存在的。 
//
// 
//
// 示例 1： 
//
// 输入：s = "?zs"
//输出："azs"
//解释：该示例共有 25 种解决方案，从 "azs" 到 "yzs" 都是符合题目要求的。只有 "z" 是无效的修改，因为字符串 "zzs" 中有连续重复的两
//个 'z' 。 
//
// 示例 2： 
//
// 输入：s = "ubv?w"
//输出："ubvaw"
//解释：该示例共有 24 种解决方案，只有替换成 "v" 和 "w" 不符合题目要求。因为 "ubvvw" 和 "ubvww" 都包含连续重复的字符。
// 
//
// 示例 3： 
//
// 输入：s = "j?qg??b"
//输出："jaqgacb"
// 
//
// 示例 4： 
//
// 输入：s = "??yw?ipkj?"
//输出："acywaipkja"
// 
//
// 
//
// 提示： 
//
// 
// 
// 1 <= s.length <= 100 
// 
// 
// s 仅包含小写英文字母和 '?' 字符 
// 
// 
// Related Topics 字符串 
// 👍 77 👎 0

  
package leetcode.editor.cn;
public class ReplaceAllSToAvoidConsecutiveRepeatingCharacters{
      public static void main(String[] args) {
           Solution solution = new ReplaceAllSToAvoidConsecutiveRepeatingCharacters().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          public String modifyString(String s) {

              /**
               * 全球站高赞解法
               *
               * 思路就是遍历，然后用a,b,c三个数去试就行。因为只有两个数前后，所以最多用两个字母，那三个字母一定可以，
               * 所以根本不需要用到26个字母。
               *
               */
              char[] arr = s.toCharArray();
              int n = arr.length;
              for (int i = 0; i < n; i++) {
                  if (arr[i] == '?') {
                      for (char c = 'a'; c <= 'c'; c++) {
                          if (i > 0 && arr[i-1] == c) continue;
                          if (i + 1 < n && arr[i + 1] == c) continue;
                          arr[i] = c;
                          break;
                      }
                  }
              }
              return String.valueOf(arr);



              /**
               * 自己的解法
               */
//              if (s.equals("?")) {
//                  return "a";
//              }
//
//              char[] chars = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
//              char[] chs = s.toCharArray();
//              for (int i = 0; i < chs.length; i++) {
//                  if (chs[i] == '?') {
//                      if (i == 0) {
//                          if (i + 1 < s.length()) {
//                              if (chs[i + 1] != '?') {
//                                  for (char c : chars) {
//                                      if (c != chs[i + 1]) {
//                                          chs[i] = c;
//                                          continue;
//                                      }
//                                  }
//                              } else {
//                                  chs[i] = 'a';
//                              }
//                          }
//                      } else if (i == chs.length - 1) {
//                          if (i - 1 >= 0) {
//                              if (chs[i - 1] != '?') {
//                                  for (char c : chars) {
//                                      if (c != chs[i - 1]) {
//                                          chs[i] = c;
//                                          continue;
//                                      }
//                                  }
//                              } else {
//                                  chs[i] = 'a';
//                              }
//                          }
//                      } else {
//                          if (chs[i + 1] == '?') {
//                              for (char c : chars) {
//                                  if (c != chs[i - 1]) {
//                                      chs[i] = c;
//                                      continue;
//                                  }
//                              }
//                          } else {
//                              for (char c : chars) {
//                                  if (c != chs[i - 1] && c != chs[i + 1]) {
//                                      chs[i] = c;
//                                      continue;
//                                  }
//                              }
//                          }
//                      }
//                  }
//
//              }
//
//              return new String(chs);
          }
}
//leetcode submit region end(Prohibit modification and deletion)

  }