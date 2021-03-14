//题号：74
//https://leetcode-cn.com/problems/search-a-2d-matrix/
//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -104 <= matrix[i][j], target <= 104 
// 
// Related Topics 数组 二分查找 
// 👍 325 👎 0


package leetcode.editor.cn;

public class SearchA2dMatrix {
    public static void main(String[] args) {
        Solution solution = new SearchA2dMatrix().new Solution();
        solution.searchMatrix(new int[][]{{1,1}}, 0);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {

//            int m = matrix.length;
//            int n = matrix[0].length;
//            int left = 0, right = m * n - 1;
//            while (left < right) {
//                int mid = left + (right - left) / 2;
//                int matrix1 = matrix[mid / n][mid % n];
//                if (matrix1 == target) {
//                    return true;
//                } else if (matrix1 > target) {
//                    right = mid;
//                } else {
//                    left = mid + 1;
//                }
//            }
//
//            return matrix[right / n][right % n] == target;




            /**
             * 直接在二位数组上做二分查找
             *
             * n * m矩阵转换为array =>矩阵[x] [y] => a [x * m + y]
             *
             * m代表第二维的个数
             *
             * 数组转换为n * m矩阵=> a [x] =>矩阵[x / m] [x％m];
             *
             * x/m算出是在第几组，x%m算出是这一组的第几个
             *
             * 时间复杂度O(log(m*n)),空间复杂度O(1)
             *
             */
            int n = matrix.length;
            int m = matrix[0].length;
            int l = 0, r = m * n - 1;
            while (l < r) {
                int mid = (l + r - 1) >> 1;
//                int mid = l + (r - l) / 2;
                //这儿相当于用数组a[mid]和target比较
                if (matrix[mid / m][mid % m] < target) {
                    l = mid + 1;
                } else {
                    //最后是right%n，要保证right在数组范围内，如果元素只有两个，mid-1可能会变成-1导致下标越界，因此right=mid
                    r = mid;
                }
            }
            return matrix[r / m][r % m] == target;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}