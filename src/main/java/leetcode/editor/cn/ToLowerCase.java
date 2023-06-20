//实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入: "Hello"
//输出: "hello" 
//
// 示例 2： 
//
// 
//输入: "here"
//输出: "here" 
//
// 示例 3： 
//
// 
//输入: "LOVELY"
//输出: "lovely"
// 
// Related Topics 字符串 
// 👍 146 👎 0

package leetcode.editor.cn;
public class ToLowerCase {
    public static void main(String[] args) {
        Solution solution = new ToLowerCase().new Solution();
        solution.toLowerCase("Hello");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public String toLowerCase(String str) {

            //toCharArray是新创建一个char数组，然后将数据copy过来，对原来的数据是没有任何影响的
            //A的ascii码是65,Z是90，a是97，所以A变成a只需要+32即可。
            char[] chars = str.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] <= 90 && chars[i] >= 65) {
//                    chars[i] += 32;
                    //位运算会更快
                    chars[i] |= 32;
                }
            }
            return new String(chars);
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}