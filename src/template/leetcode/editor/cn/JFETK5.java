package template.leetcode.editor.cn;

/**
<p>English description is not available for the problem. Please switch to Chinese.</p>
<div><div>Related Topics</div><div><li>位运算</li><li>数学</li><li>字符串</li><li>模拟</li></div></div><br><div><li>👍 2</li><li>👎 0</li></div>
*/
public class JFETK5{

    public static void main(String[] args) {
        Solution solution = new JFETK5().new Solution();

        System.out.println("二进制 11 + 10 == " + solution.addBinary("11", "10"));
        System.out.println("二进制 1010 + 1011 == " + solution.addBinary("1010", "1011"));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int aLen = a.length() - 1;
        int bLen = b.length() - 1;

        int sum = 0;
        int carry = 0;

        while (aLen >= 0 || bLen >= 0) {
            int aDigit = aLen >= 0 ? a.charAt(aLen--) - '0': 0;
            int bDigit = bLen >= 0 ? b.charAt(bLen--) - '0': 0;

            sum = aDigit + bDigit + carry;
            carry = sum >= 2 ? 1 : 0;
            sum = sum >= 2 ? sum - 2 : sum;

            sb.append(sum);
        }

        if (carry >= 1) {
            sb.append(1);
        }

        return sb.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}