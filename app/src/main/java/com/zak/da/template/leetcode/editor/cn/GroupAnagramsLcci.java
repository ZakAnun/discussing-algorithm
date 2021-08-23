package com.zak.da.template.leetcode.editor.cn;

//Write a method to sort an array of strings so that all the anagrams are in the
// same group. 
//
// Note: This problem is slightly different from the original one the book. 
//
// Example: 
//
// 
//Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
//Output:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// Notes: 
//
// 
// All inputs will be in lowercase. 
// The order of your output does not matter. 
// 
// Related Topics 哈希表 字符串 排序 
// 👍 77 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagramsLcci{

    public static void main(String[] args) {
        Solution solution = new GroupAnagramsLcci().new Solution();

        String[] demo = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};

        System.out.println("demo [\"eat\", \"tea\", \"tan\", \"ate\", \"nat\", \"bat\"] 变位数组集合如下");

        List<List<String>> result = solution.groupAnagrams(demo);

        int resultSize = result.size();
        for (int index = 0; index < resultSize; index++) {
            System.out.print("第" + (index + 1) + "组: ");
            List<String> group = result.get(index);
            for (String str : group) {
                System.out.print("\"" + str + "\"" + " ");
            }
            System.out.println();
        }
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String key = new String(charArr);
            List<String> value = map.getOrDefault(key, new ArrayList<>());
            value.add(str);

            map.put(key, value);
        }

        return new ArrayList<>(map.values());
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}