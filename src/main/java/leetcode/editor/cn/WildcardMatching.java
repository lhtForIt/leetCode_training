//给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。 
//
// '?' 可以匹配任何单个字符。
//'*' 可以匹配任意字符串（包括空字符串）。
// 
//
// 两个字符串完全匹配才算匹配成功。 
//
// 说明: 
//
// 
// s 可能为空，且只包含从 a-z 的小写字母。 
// p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。 
// 
//
// 示例 1: 
//
// 输入:
//s = "aa"
//p = "a"
//输出: false
//解释: "a" 无法匹配 "aa" 整个字符串。 
//
// 示例 2: 
//
// 输入:
//s = "aa"
//p = "*"
//输出: true
//解释: '*' 可以匹配任意字符串。
// 
//
// 示例 3: 
//
// 输入:
//s = "cb"
//p = "?a"
//输出: false
//解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
// 
//
// 示例 4: 
//
// 输入:
//s = "adceb"
//p = "*a*b"
//输出: true
//解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
// 
//
// 示例 5: 
//
// 输入:
//s = "acdcb"
//p = "a*c?b"
//输出: false 
// Related Topics 贪心 递归 字符串 动态规划 
// 👍 754 👎 0

package leetcode.editor.cn;
public class WildcardMatching {
    public static void main(String[] args) {
        Solution solution = new WildcardMatching().new Solution();
        System.out.println(solution.isMatch("", "****"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isMatch(String s, String p) {

        /**
         * 双指针法
         *
         * 这里的难点其实就是对*的匹配，因此在遇到*时，直接用两个指针将当前位置记住，并将匹配串j的指针后移，
         * 然后下次遇到不匹配的情况时查看前面是否有*，如果有，就依次移动字符串i的指针。
         *
         *
         */

        int i = 0, j = 0, match = 0, startIdx = -1;

        while (i < s.length()) {
            if (j < p.length() && ((p.charAt(j) == '?') || s.charAt(i) == p.charAt(j))) {
                i++;
                j++;
            } else if (j < p.length() && p.charAt(j) == '*') {
                startIdx = j;
                match = i;
                j++;
            } else if (startIdx != -1) {
                j = startIdx + 1;
                i = ++match;
            } else {
                return false;
            }
        }

        while (j < p.length() && p.charAt(j) == '*') j++;

        return j == p.length();


        /**
         * 动态规划
         *
         * 法一
         *
         */

//        boolean[][] match=new boolean[s.length()+1][p.length()+1];
//        match[s.length()][p.length()]=true;
//        for(int i=p.length()-1;i>=0;i--){
//            if(p.charAt(i)!='*')
//                break;
//            else
//                match[s.length()][i]=true;
//        }
//        for(int i=s.length()-1;i>=0;i--){
//            for(int j=p.length()-1;j>=0;j--){
//                if(s.charAt(i)==p.charAt(j)||p.charAt(j)=='?')
//                    match[i][j]=match[i+1][j+1];
//                else if(p.charAt(j)=='*')
//                    match[i][j]=match[i+1][j]||match[i][j+1];
//                else
//                    match[i][j]=false;
//            }
//        }
//        return match[0][0];


        /**
         * 动态规划
         *
         * 法二
         *
         */

//        if(s==null || p==null) return false;
//        int s_len = s.length();
//        int p_len = p.length();
//
//        boolean[][] d = new boolean[s_len+1][p_len+1];
//        d[0][0] = true;
//
//        for (int i = 0; i < p_len; i++) {
//            if ( p.charAt(i) == '*') d[0][i+1] = d[0][i];
//        }
//
//        for (int i = 0; i < s_len; i++) {
//            for (int j = 0; j < p_len; j++) {
//                if(p.charAt(j) == '?') d[i+1][j+1] = d[i][j];
//                if(p.charAt(j) == s.charAt(i)) d[i+1][j+1] = d[i][j];
//                if(p.charAt(j) == '*') d[i+1][j+1] = d[i+1][j] || d[i][j+1];
//            }
//        }
//
//        return d[s_len][p_len];



//        int i = 0, j = 0, match = 0, starIdx = -1;
//        while (i < s.length()){
//            // 移动i,j指针
//            if (j < p.length()  && (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j))){
//                i++;
//                j++;
//            } else if (j < p.length() && p.charAt(j) == '*'){
//              //当遇到*,只移动j指针
//                starIdx = j;
//                match = i;
//                j++;
//            } else if (starIdx != -1){
//              //当碰到最近一个字符是*，即以前碰到过*时，前进字符串i指针
//                j = starIdx + 1;
//                match++;
//                i = match;
//            } else{
//                //最前最后都不是*,且字符串不匹配，返回false
//                return false;
//            }
//
//        }
//
//        //检查剩下带*的字符串
//        //这个是预防""和"*******"这种比较
//        while (j < p.length() && p.charAt(j) == '*') j++;
//
//        return j == p.length();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}