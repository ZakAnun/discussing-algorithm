package template.leetcode.editor.cn;

//Given a string s, find the longest palindromic subsequence's length in s. 
//
// A subsequence is a sequence that can be derived from another sequence by dele
//ting some or no elements without changing the order of the remaining elements. 
//
// 
// Example 1: 
//
// 
//Input: s = "bbbab"
//Output: 4
//Explanation: One possible longest palindromic subsequence is "bbbb".
// 
//
// Example 2: 
//
// 
//Input: s = "cbbd"
//Output: 2
//Explanation: One possible longest palindromic subsequence is "bb".
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consists only of lowercase English letters. 
// 
// Related Topics 字符串 动态规划 
// 👍 572 👎 0

public class LongestPalindromicSubsequence{

    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubsequence().new Solution();

        System.out.println("bbbab 最长回文子序列长度 == " + solution.longestPalindromeSubSeq("bbbab"));
        System.out.println("cbbd 最长回文子序列长度 == " + solution.longestPalindromeSubSeq("cbbd"));
        System.out.println("bbabb 最长回文子序列长度 == " + solution.longestPalindromeSubSeq("bbabb"));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestPalindromeSubSeq(String s) {
        int length = s.length();
        int[][] dp = new int[length][length];

        for (int i = length - 1; i >= 0; i--) {
            dp[1][1] = 1;
            char ci = s.charAt(i);
            for (int j = i + 1; j < length; j++) {
                char cj = s.charAt(j);
                if (ci == cj) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][length - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}