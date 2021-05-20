package daily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 每日一题: 692. 前K个高频单词
 *
 * 给一非空的单词列表，返回前 k 个出现次数最多的单词。
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 *
 * 示例 1：
 * 输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * 输出: ["i", "love"]
 * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
 *     注意，按字母顺序 "i" 在 "love" 之前。
 *
 * 示例 2：
 * 输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * 输出: ["the", "is", "sunny", "day"]
 * 解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
 *     出现次数依次为 4, 3, 2 和 1 次。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Day20210520 {

    public static void main(String[] args) {
        System.out.println("692. 前K个高频单词");
        String[] demoOne = new String[] {"i", "love", "leetcode", "i", "love", "coding"};
        String[] demoTwo = new String[] {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};

        System.out.println("示例 1 前 2 个高频单词为: ");
        List<String> resultOne = topKFrequent(demoOne, 2);
        for (String item : resultOne) {
            System.out.print(item + " ");
        }
        System.out.println();
        System.out.println("示例 2 前 4 个高频单词为: ");
        List<String> resultTwo = topKFrequent(demoTwo, 4);
        for (String item : resultTwo) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String item : words) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }
        List<String> result = new ArrayList<>();
        Set<Map.Entry<String, Integer>> kvSet = map.entrySet();
        for (Map.Entry<String, Integer> item : kvSet) {
            result.add(item.getKey());
        }
        result.sort((o1, o2) -> map.get(o1).equals(map.get(o2)) ? o1.compareTo(o2) : map.get(o2) - map.get(o1));

        return result.subList(0, k);
    }
}
