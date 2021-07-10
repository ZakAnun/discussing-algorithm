package template.leetcode.editor.cn;

//Design a time-based key-value data structure that can store multiple values fo
//r the same key at different time stamps and retrieve the key's value at a certai
//n timestamp. 
//
// Implement the TimeMap class: 
//
// 
// TimeMap() Initializes the object of the data structure. 
// void set(String key, String value, int timestamp) Stores the key key with the
// value value at the given time timestamp. 
// String get(String key, int timestamp) Returns a value such that set was calle
//d previously, with timestamp_prev <= timestamp. If there are multiple such value
//s, it returns the value associated with the largest timestamp_prev. If there are
// no values, it returns "". 
// 
//
// 
// Example 1: 
//
// 
//Input
//["TimeMap", "set", "get", "get", "set", "get", "get"]
//[[], ["foo", "bar", 1], ["foo", 1], ["foo", 3], ["foo", "bar2", 4], ["foo", 4]
//, ["foo", 5]]
//Output
//[null, null, "bar", "bar", null, "bar2", "bar2"]
//
//Explanation
//TimeMap timeMap = new TimeMap();
//timeMap.set("foo", "bar", 1);  // store the key "foo" and value "bar" along wi
//th timestamp = 1.
//timeMap.get("foo", 1);         // return "bar"
//timeMap.get("foo", 3);         // return "bar", since there is no value corres
//ponding to foo at timestamp 3 and timestamp 2, then the only value is at timesta
//mp 1 is "bar".
//timeMap.set("foo", "bar2", 4); // store the key "foo" and value "ba2r" along w
//ith timestamp = 4.
//timeMap.get("foo", 4);         // return "bar2"
//timeMap.get("foo", 5);         // return "bar2"
// 
//
// 
// Constraints: 
//
// 
// 1 <= key.length, value.length <= 100 
// key and value consist of lowercase English letters and digits. 
// 1 <= timestamp <= 107 
// All the timestamps timestamp of set are strictly increasing. 
// At most 2 * 105 calls will be made to set and get. 
// 
// Related Topics 设计 哈希表 字符串 二分查找 
// 👍 125 👎 0

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeBasedKeyValueStore{

    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();

        System.out.println("set(\"foo\", \"bar\", 1)");
        timeMap.set("foo", "bar", 1);
        System.out.println("get(\"foo\", 1) = " + timeMap.get("foo", 1));
        System.out.println("get(\"foot\", 3) = " + timeMap.get("foo", 3));
        System.out.println("set(\"foo\", \"bar2\", 4)");
        timeMap.set("foo", "bar2", 4);
        System.out.println("get(\"foo\", 4) = " + timeMap.get("foo", 4));
        System.out.println("get(\"foo\", 5) = " + timeMap.get("foo", 5));

        System.out.println("-----");

        System.out.println("set(\"love\", \"high\", 10)");
        timeMap.set("love", "high", 10);
        timeMap.set("love", "low", 20);
        System.out.println("set(\"love\", \"low\", 20)");
        System.out.println("get(\"love\", 5) = " + timeMap.get("love", 5));
        System.out.println("get(\"love\", 10) = " + timeMap.get("love", 10));
        System.out.println("get(\"love\", 15) = " + timeMap.get("love", 15));
        System.out.println("get(\"love\", 20) = " + timeMap.get("love", 20));
        System.out.println("get(\"love\", 25) = " + timeMap.get("love", 25));
    }

//leetcode submit region begin(Prohibit modification and deletion)
static class TimeMap {

    static class Pair implements Comparable<Pair> {

        int timestamp;
        String value;

        Pair(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }

        public int hashCode() {
            return timestamp + value.hashCode();
        }

        public boolean equals(Object obj) {
            if (obj instanceof Pair) {
                Pair pair2 = (Pair) obj;
                return this.timestamp == pair2.timestamp && this.value.equals(pair2.value);
            }
            return false;
        }

        @Override
        public int compareTo(Pair pair2) {
            if (this.timestamp != pair2.timestamp) {
                return this.timestamp - pair2.timestamp;
            } else {
                return this.value.compareTo(pair2.value);
            }
        }
    }

    Map<String, List<Pair>> map;

    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<Pair> pairs = map.getOrDefault(key, new ArrayList<>());
        pairs.add(new Pair(timestamp, value));
        map.put(key, pairs);
    }
    
    public String get(String key, int timestamp) {
        List<Pair> pairs = map.getOrDefault(key, new ArrayList<>());
        // 使用一个大于所有 value 的字符串，以确保在 pairs 中含有 timestamp 的情况下也返回大于 timestamp 的位置
        Pair pair = new Pair(timestamp, String.valueOf((char) 127));
        int i = binarySearch(pairs, pair);
        if (i > 0) {
            return pairs.get(i - 1).value;
        }
        return "";
    }

    private int binarySearch(List<Pair> pairs, Pair pair) {
        int low = 0;
        int high = pairs.size() - 1;

        if (high < 0 || pairs.get(high).compareTo(pair) <= 0) {
            return high + 1;
        }
        while (low < high) {
            int mid = (high - low) / 2 + low;
            Pair midPair = pairs.get(mid);
            if (midPair.compareTo(pair) <= 0) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
//leetcode submit region end(Prohibit modification and deletion)

}