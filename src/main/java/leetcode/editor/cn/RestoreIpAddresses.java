//有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。 
//
// 
// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 
//和 "192.168@1.1" 是 无效 IP 地址。 
// 
//
// 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你不能重新排序
//或删除 s 中的任何数字。你可以按 任何 顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "25525511135"
//输出：["255.255.11.135","255.255.111.35"]
// 
//
// 示例 2： 
//
// 
//输入：s = "0000"
//输出：["0.0.0.0"]
// 
//
// 示例 3： 
//
// 
//输入：s = "1111"
//输出：["1.1.1.1"]
// 
//
// 示例 4： 
//
// 
//输入：s = "010010"
//输出：["0.10.0.10","0.100.1.0"]
// 
//
// 示例 5： 
//
// 
//输入：s = "101023"
//输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 20 
// s 仅由数字组成 
// 
// Related Topics 字符串 回溯 
// 👍 733 👎 0

package leetcode.editor.cn;

import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {
    public static void main(String[] args) {
        Solution solution = new RestoreIpAddresses().new Solution();
        solution.restoreIpAddresses("25525511135");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public List<String> restoreIpAddresses(String s) {


            List<String> result = new ArrayList<>();
            myDfs(s, result, "", 0, 0);
            return result;









//        List<String> ret = new ArrayList<>();
//
//        StringBuffer ip = new StringBuffer();
//        for(int a = 1 ; a < 4 ; ++ a)
//            for(int b = 1 ; b < 4 ; ++ b)
//                for(int c = 1 ; c < 4 ; ++ c)
//                    for(int d = 1 ; d < 4 ; ++ d)
//                    {
//                        if(a + b + c + d == s.length() )
//                        {
//                            int n1 = Integer.parseInt(s.substring(0, a));
//                            int n2 = Integer.parseInt(s.substring(a, a+b));
//                            int n3 = Integer.parseInt(s.substring(a+b, a+b+c));
//                            int n4 = Integer.parseInt(s.substring(a+b+c));
//                            if(n1 <= 255 && n2 <= 255 && n3 <= 255 && n4 <= 255)
//                            {
//                                ip.append(n1).append('.').append(n2)
//                                        .append('.').append(n3).append('.').append(n4);
//                                if(ip.length() == s.length() + 3) ret.add(ip.toString());
//                                ip.delete(0, ip.length());
//                            }
//                        }
//                    }
//        return ret;


//        List<String> solutions = new ArrayList<String>();
//        restoreIp(s, solutions, 0, "", 0);
//        return solutions;


//        List<String> res = new ArrayList<>();
//        dfs(s, res, "", 0, 0);
//        return res;
        }

        private void myDfs(String s, List<String> result, String reStr, int subIndex, int sec) {
            if (s.length() - subIndex > 3 * (4 - sec)) return;
            if (sec == 4 && s.length() == subIndex) {
                result.add(reStr);
                return;
            }

            for (int i = 1; i <= 3; i++) {
                //在不够12位的时候，需要判断下标是否越界
                if (subIndex+i>s.length()) return;
                int indx = subIndex + i;
                String str = s.substring(subIndex, indx);
                if (str.length()>1&&str.startsWith("0")||i==3&&Integer.valueOf(str)>255) continue;
                myDfs(s, result, sec == 0 ? str : reStr + "." + str, indx, sec + 1);
            }

        }

        private void restoreIp(String ip, List<String> solutions, int idx, String restored, int count) {
            if (count > 4) return;
            if (count == 4 && idx == ip.length()) solutions.add(restored);

            for (int i=1; i<4; i++) {
                if (idx+i > ip.length()) break;
                String s = ip.substring(idx,idx+i);
                if ((s.startsWith("0") && s.length()>1) || (i==3 && Integer.parseInt(s) >= 256)) continue;
                restoreIp(ip, solutions, idx+i, restored+s+(count==3?"" : "."), count+1);
            }
        }

        private void dfs(String s, List<String> res, String restored, int pos, int sec) {


            if (s.length() - pos > 3 * (4 - sec)) return;
            if (sec == 4 && pos == s.length()) {
                res.add(restored);
                return;
            }

            for (int i = 1; i <= 3; i++) {
                if (pos + i > s.length()) return;
                String part = s.substring(pos, pos + i);
                if (part.length() > 1 && part.startsWith("0") || i == 3 && Integer.valueOf(part) >= 256) continue;
                dfs(s, res, sec == 0 ? part : restored + "." + part, pos + i, sec + 1);
            }
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

}