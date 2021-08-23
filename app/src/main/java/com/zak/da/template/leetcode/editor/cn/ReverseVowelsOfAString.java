package com.zak.da.template.leetcode.editor.cn;

//Given a string s, reverse only all the vowels in the string and return it. 
//
// The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both cases
//. 
//
// 
// Example 1: 
// Input: s = "hello"
//Output: "holle"
// Example 2: 
// Input: s = "leetcode"
//Output: "leotcede"
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 3 * 105 
// s consist of printable ASCII characters. 
// 
// Related Topics 双指针 字符串 
// 👍 205 👎 0

public class ReverseVowelsOfAString{

    public static void main(String[] args) {
        Solution solution = new ReverseVowelsOfAString().new Solution();

        System.out.println("反转字符串元音字母，hello == " + solution.reverseVowels("hello"));
        System.out.println("反转字符串元音字母，leetcode == " + solution.reverseVowels("leetcode"));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int length = arr.length;
        int left = 0;
        int right = length - 1;

        while (left < right) {
            while (left < length && isNotVowel(arr[left])) {
                left++;
            }
            while (right > 0 && isNotVowel(arr[right])) {
                right--;
            }
            if (left < right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }

        return new String(arr);
    }

    private boolean isNotVowel(char c) {
        return "aeiouAEIOU".indexOf(c) < 0;
    }

    private void swap(char[] arr, int left, int right) {
        char temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}