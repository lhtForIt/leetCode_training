//题号：剑指 Offer 05
//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。 
//
// 
//
// 示例 1： 
//
// 输入：s = "We are happy."
//输出："We%20are%20happy." 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 10000 
// 👍 68 👎 0

  
  package leetcode.editor.cn;
  public class TiHuanKongGeLcof{
      public static void main(String[] args) {
           Solution solution = new TiHuanKongGeLcof().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String replaceSpace(String s) {

        //foreach比普通的for(int i=0)这种循环占用内存小
        StringBuilder sb = new StringBuilder();
        for (char c:s.toCharArray()) {
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }

        return sb.toString();

        /**
         * 在循环里char只有一个字符，不能替换成%20这种，那就扩大字符集的大小，
         * 为支持极端情况（全是' '的时候），直接把结果数组扩大成原来的三倍，
         * 在进行操作
         */
//        int length = s.length();
//        char[] array = new char[length * 3];
//        int size = 0;
//        for (int i = 0; i < length; i++) {
//            char c = s.charAt(i);
//            if (c == ' ') {
//                array[size++] = '%';
//                array[size++] = '2';
//                array[size++] = '0';
//            } else {
//                array[size++] = c;
//            }
//        }
//
//        String newStr = new String(array, 0, size);
//        return newStr;





    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }