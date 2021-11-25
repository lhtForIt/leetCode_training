//给你一个字符串 s ，其中包含字母顺序打乱的用英文单词表示的若干数字（0-9）。按 升序 返回原始的数字。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "owoztneoer"
//输出："012"
// 
//
// 示例 2： 
//
// 
//输入：s = "fviefuro"
//输出："45"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 105 
// s[i] 为 ["e","g","f","i","h","o","n","s","r","u","t","w","v","x","z"] 这些字符之一 
// s 保证是一个符合题目要求的字符串 
// 
// Related Topics 哈希表 数学 字符串 
// 👍 132 👎 0

package leetcode.editor.cn;
public class ReconstructOriginalDigitsFromEnglish {
    public static void main(String[] args) {
        Solution solution = new ReconstructOriginalDigitsFromEnglish().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        //因为只是字母顺序被打乱，但是一定会有有这个单词的，不会有缺少的情况，所以找到每个单词唯一的字母就能很好计算

        /**
         * zero
         * one
         * two
         * three
         * four
         * five
         * six
         * seven
         * eight
         * nine
         */
    public String originalDigits(String s) {

        int[] count = new int[10];
        for (char c : s.toCharArray()) {
            if (c=='z') count[0]++;
            if (c=='w') count[2]++;
            if (c=='x') count[6]++;
            if (c=='s') count[7]++;//7-6
            if (c=='g') count[8]++;
            if (c=='o') count[1]++;//1-0-2-4
            if (c=='h') count[3]++;//3-8
            if (c=='u') count[4]++;
            if (c=='f') count[5]++;//5-4
            if (c=='i') count[9]++;//9-5-6-8
        }

        count[7] = count[7] - count[6];
        count[1] = count[1] - count[0] - count[2]-count[4];
        count[3] = count[3] - count[8];
        count[5] = count[5] - count[4];
        count[9] = count[9] - count[5] - count[6] - count[8];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j < count[i]; j++) {
                sb.append(i);
            }
        }

        return sb.toString();








//        int[] count = new int[10];
//        for (int i = 0; i < s.length(); i++){
//            char c = s.charAt(i);
//            if (c == 'z') count[0]++;
//            if (c == 'w') count[2]++;
//            if (c == 'x') count[6]++;
//            if (c == 's') count[7]++; //7-6
//            if (c == 'g') count[8]++;
//            if (c == 'u') count[4]++;
//            if (c == 'f') count[5]++; //5-4
//            if (c == 'h') count[3]++; //3-8
//            if (c == 'i') count[9]++; //9-8-5-6
//            if (c == 'o') count[1]++; //1-0-2-4
//        }
//        count[7] -= count[6];
//        count[5] -= count[4];
//        count[3] -= count[8];
//        count[9] = count[9] - count[8] - count[5] - count[6];
//        count[1] = count[1] - count[0] - count[2] - count[4];
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i <= 9; i++){
//            //count[i]代表这个数字出现了几次，如果0出现两次就是00，这时候count[i]是2
//            for (int j = 0; j < count[i]; j++){
//                sb.append(i);
//            }
//        }
//        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}