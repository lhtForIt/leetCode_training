package leetcode.editor.cn;

/**
 * @author lianght1
 * @date 2021/2/19
 */
public class RecurCodeTemplate {

    static int MAX_LEVEL = Integer.MAX_VALUE;

    /***
     * 递归：
     * 递归我们可以想象成盗梦空间里的多层梦境，
     * 每下到下一层梦境时除了参数有改变以外，其他
     * 环境，人物都是全新的。
     * 这其实也是函数的特性
     *
     */
    public static void recur(int level, int param) {
        //terminator 递归终止条件(出口)
        if (level > MAX_LEVEL) {
            //process result 进程结果
            return;
        }


        //process current logic 进程当前逻辑
        process(level, param);

        //drill down 进入下一层递归
        recur(level + 1, param);

        //restore current status 重置当前状态


    }

    private static void process(int level, int param) {
    }


}
