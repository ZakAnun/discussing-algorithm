package com.zak.da.daily;

import java.util.ArrayList;
import java.util.List;

/**
 * 每日一题: 208. 实现 Trie (前缀树)
 *
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
 *
 * 请你实现 Trie 类：
 *
 * Trie() 初始化前缀树对象。
 * void insert(String word) 向前缀树中插入字符串 word 。
 * boolean search(String word) 如果字符串 word 在前缀树中，
 *      返回 true（即，在检索之前已经插入）；否则，返回 false 。
 * boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，
 *      返回 true ；否则，返回 false 。
 */
public class Day20210414 {

    public static void main(String[] args) {
        System.out.println("208. 实现 Trie (前缀树)");

        Trie trie = new Trie();
        trie.insert("apple");
        System.out.print("insert apple");
        boolean searchApple = trie.search("apple");   // 返回 True
        System.out.print(", search apple = " + searchApple);
        boolean searchApp = trie.search("app");     // 返回 False
        System.out.print(", search app = " + searchApp);
        boolean startsWithApp = trie.startsWith("app");       // 返回 True
        System.out.print(", startsWith app = " + startsWithApp);
        trie.insert("app");
        System.out.print(", insert app");
        boolean searchAppAfterInsert = trie.search("app");     // 返回 True
        System.out.print(", search app = " + searchAppAfterInsert);
        System.out.println();
    }

    static class Trie {

        private List<String> result;

        /** Initialize your data structure here. */
        public Trie() {
            result = new ArrayList<>();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            result.add(word);
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            for (String item : result) {
                if (item.equals(word)) {
                    return true;
                }
            }
            return false;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            for (String item: result) {
                if (item.startsWith(prefix)) {
                    return true;
                }
            }
            return false;
        }
    }
}
