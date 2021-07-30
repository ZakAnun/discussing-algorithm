package template.leetcode.editor.cn;

//Given a string columnTitle that represents the column title as appear in an Ex
//cel sheet, return its corresponding column number. 
//
// For example: 
//
// 
//A -> 1
//B -> 2
//C -> 3
//...
//Z -> 26
//AA -> 27
//AB -> 28 
//...
// 
//
// 
// Example 1: 
//
// 
//Input: columnTitle = "A"
//Output: 1
// 
//
// Example 2: 
//
// 
//Input: columnTitle = "AB"
//Output: 28
// 
//
// Example 3: 
//
// 
//Input: columnTitle = "ZY"
//Output: 701
// 
//
// Example 4: 
//
// 
//Input: columnTitle = "FXSHRXW"
//Output: 2147483647
// 
//
// 
// Constraints: 
//
// 
// 1 <= columnTitle.length <= 7 
// columnTitle consists only of uppercase English letters. 
// columnTitle is in the range ["A", "FXSHRXW"]. 
// 
// Related Topics 数学 字符串 
// 👍 272 👎 0

public class ExcelSheetColumnNumber{

    public static void main(String[] args) {
        Solution solution = new ExcelSheetColumnNumber().new Solution();

        System.out.println("\"A\" == " + solution.titleToNumber("A"));
        System.out.println("\"AB\" == " + solution.titleToNumber("AB"));
        System.out.println("\"ZY\" == " + solution.titleToNumber("ZY"));
        System.out.println("\"FXSHRXW\" == " + solution.titleToNumber("FXSHRXW"));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int titleToNumber(String columnTitle) {
        int length = columnTitle.length();
        int result = 0;
        int multi = 1;

        for (int i = length - 1; i >= 0; i--) {
            int item = columnTitle.charAt(i) - 'A' + 1;
            result += item * multi;
            multi *= 26;
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}