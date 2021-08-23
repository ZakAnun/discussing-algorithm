package com.zak.da.template.leetcode.editor.cn;

//Given a string s, sort it in decreasing order based on the frequency of charac
//ters, and return the sorted string. 
//
// 
// Example 1: 
//
// 
//Input: s = "tree"
//Output: "eert"
//Explanation: 'e' appears twice while 'r' and 't' both appear once.
//So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid a
//nswer.
// 
//
// Example 2: 
//
// 
//Input: s = "cccaaa"
//Output: "aaaccc"
//Explanation: Both 'c' and 'a' appear three times, so "aaaccc" is also a valid 
//answer.
//Note that "cacaca" is incorrect, as the same characters must be together.
// 
//
// Example 3: 
//
// 
//Input: s = "Aabb"
//Output: "bbAa"
//Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
//Note that 'A' and 'a' are treated as two different characters.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 5 * 105 
// s consists of English letters and digits. 
// 
// Related Topics 哈希表 字符串 桶排序 计数 排序 堆（优先队列） 
// 👍 309 👎 0

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortCharactersByFrequency{

    public static void main(String[] args) {
        Solution solution = new SortCharactersByFrequency().new Solution();

        System.out.println("tree -> " + solution.frequencySort("com/zak/da/tree"));
        System.out.println("cccaaa -> " + solution.frequencySort("cccaaa"));
        System.out.println("Aabb -> " + solution.frequencySort("Aabb"));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int length = s.length();
        for (int i = 0; i < length; i++) {
            Character c = s.charAt(i);
            int value = map.getOrDefault(c, 0) + 1;
            map.put(c, value);
        }

        List<Character> list = new ArrayList<>(map.keySet());
        list.sort((a, b) -> map.get(b) - map.get(a));

        StringBuilder sb = new StringBuilder();
        for (Character c : list) {
            int count = map.get(c);
            for (int i = 0; i < count; i++) {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}