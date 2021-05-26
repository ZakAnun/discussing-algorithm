package daily;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 每日一题: 1190. 反转每对括号间的子串
 *
 * 给出一个字符串 s（仅含有小写英文字母和括号）。
 * 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
 * 注意，您的结果中 不应 包含任何括号。
 *
 * 示例 1:
 * 输入：s = "(abcd)"
 * 输出："dcba"
 *
 * 示例 2:
 * 输入：s = "(u(love)i)"
 * 输出："iloveu"
 *
 * 示例 3:
 * 输入：s = "(ed(et(oc))el)"
 * 输出："leetcode"
 *
 * 示例 4:
 * 输入：s = "a(bcdefghijkl(mno)p)q"
 * 输出："apmnolkjihgfedcbq"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-substrings-between-each-pair-of-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Day20210521 {

    public static void main(String[] args) {
        System.out.println("1190. 反转每对括号间的子串: ");
        System.out.println("示例 1 结果串 = " + reverseParentheses("(abcd)"));
        System.out.println("示例 2 结果串 = " + reverseParentheses("(u(love)i)"));
        System.out.println("示例 3 结果串 = " + reverseParentheses("(ed(et(oc))el)"));
        System.out.println("示例 4 结果串 = " + reverseParentheses("a(bcdefghijkl(mno)p)q"));
    }

    public static String reverseParentheses(String s) {
        Deque<String> stack = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char item = s.charAt(i);
            if (item == '(') {
                stack.push(sb.toString());
                sb.setLength(0);
            } else if (item == ')') {
                sb.reverse();
                sb.insert(0, stack.pop());
            } else {
                sb.append(item);
            }
        }
        return sb.toString();
    }
}
