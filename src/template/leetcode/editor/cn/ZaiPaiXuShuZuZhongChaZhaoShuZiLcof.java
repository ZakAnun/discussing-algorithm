package template.leetcode.editor.cn;

//English description is not available for the problem. Please switch to Chinese
//. Related Topics 数组 二分查找 
// 👍 182 👎 0

public class ZaiPaiXuShuZuZhongChaZhaoShuZiLcof{

    public static void main(String[] args) {
        Solution solution = new ZaiPaiXuShuZuZhongChaZhaoShuZiLcof().new Solution();

        int[] demo = new int[]{5, 7, 7, 8, 8, 10};

        System.out.println("nums 为 [5, 7, 7, 8, 8, 10]，target == 8，结果 == " + solution.search(demo, 8));
        System.out.println("nums 为 [5, 7, 7, 8, 8, 10]，target == 6，结果 == " + solution.search(demo, 6));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        int length = nums.length;
        int leftIndex = binSearch(nums, target, true);
        int rightIndex = binSearch(nums, target, false) - 1;

        if (leftIndex <= rightIndex &&
                leftIndex >= 0 &&
                rightIndex < length &&
                nums[leftIndex] == target &&
                nums[rightIndex] == target) {
            return rightIndex - leftIndex + 1;
        }

        return 0;
    }

    private int binSearch(int[] nums, int target, boolean lower) {
        int result = nums.length;
        int left = 0;
        int right = result - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                result = mid;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}