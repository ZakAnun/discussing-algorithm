---
layout: default
title: discussing-algorithm
---

# discussing-algorithm

算法刷题记录与讨论总结，题目主要来自 [LeetCode 中国站](https://leetcode-cn.com/)，按 [labuladong 的刷题思路](https://github.com/labuladong/fucking-algorithm) 进行练习。

完整讨论见 GitHub Issues，本页为 Issue 内容索引与题目汇总。

---

## Issue 目录

- [#1 树](https://github.com/ZakAnun/discussing-algorithm/issues/1) — 23 条记录，53 道题 (open)
- [#2 每日一题](https://github.com/ZakAnun/discussing-algorithm/issues/2) — 58 条记录，61 道题 (open)
- [#3 2021.09](https://github.com/ZakAnun/discussing-algorithm/issues/3) — 4 条记录，4 道题 (open)

**合计：** 3 个 Issue，85 条刷题记录，约 118 道题。

---

## [#1 树](https://github.com/ZakAnun/discussing-algorithm/issues/1)

| 日期 | 题目 | 备注 |
| --- | --- | --- |
| 2021.03.17 | [144.前序遍历](https://leetcode-cn.com/problems/binary-tree-preorder-traversal/)<br>[94.中序遍历](https://leetcode-cn.com/problems/binary-tree-inorder-traversal/)<br>[145.后序遍历](https://leetcode-cn.com/problems/binary-tree-postorder-traversal/) | 遍历二叉树最基本的三种方式：144.前序遍历、94.中序遍历、145.后序遍历 三种遍历的差别在与先拿到哪个节点，这在代码中能清晰得知（从前一直区分不了这... |
| 2021.03.19 | [102.二叉树的层序遍历](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/)<br>[剑指 Offer 32 - II. 从上到下打印二叉树 II](https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/)<br>[637. 二叉树的层平均值](https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/)<br>[107.二叉树的层序遍历](https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/) | 今天做了一下二叉树的层序遍历，看题目还是直接去题解看答案然后懂了 =-= 102.二叉树的层序遍历要求从二叉树的根节点看是，逐层遍历出数据，看一眼觉得跟前... |
| 2021.03.20 | [103.二叉树的锯齿形层序遍历](https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/)<br>[剑指 Offer 32 - III. 从上到下打印二叉树 III](https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/) | 今天看到层序遍历还有个变形就是103.二叉树的锯齿形层序遍历，首先当然是看一下什么是锯齿形层序遍历，题意为第一层从左往右输出，第二层从右往左输出，在层序遍... |
| 2021.03.23 | [987.二叉树的垂序遍历](https://leetcode-cn.com/problems/vertical-order-traversal-of-a-binary-tree/) | 987.二叉树的垂序遍历题目中垂序遍历的定义是从最左边的列到最右边的列，看到题目第一个思路是首先肯定是需要遍历一边二叉树，但是后面的思路空白... 直接看... |
| 2021.03.26 | [105.从前序与中序遍历序列构造二叉树](https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)<br>[剑指 Offer 07. 重建二叉树](https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/)<br>[106.从中序与后序遍历序列构造二叉树](https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)<br>[889.根据前序和后序遍历构造二叉树](https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/) | 前天开始做一些根据遍历结果还原二叉树的题目，此类问题之前也有做过但是硬背了几遍再回看还是毫无头绪。缺乏思考推导的能力。一棵树遍历后能构造成一个集合，那么根... |
| 2021.03.30 | [606.根据二叉树创建字符串](https://leetcode-cn.com/problems/construct-string-from-binary-tree/)<br>[897. 递增顺序查找树](https://leetcode-cn.com/problems/increasing-order-search-tree/) | 刷了大概一周多的二叉树，感觉上算是熟悉了基本思路，所以先尝试挑树的遍历中简单难度的题 代码链接 606.根据二叉树创建字符串 题中有提示说以前序遍历进行构... |
| 2021.03.31 | [559.N 叉树的最大深度](https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/)<br>[429. N 叉树的层序遍历](https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/)<br>[题解-方法2](https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/solution/ncha-shu-de-ceng-xu-bian-li-by-leetcode/)<br>[589. N 叉树的前序遍历](https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/)<br>[590. N 叉树的后序遍历](https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/) | 树 + 遍历，这个筛选条件，简单题里有涉及到 N 叉树的题，之前直接被他的名字劝退了，但是仔细看看题目，直接按层序遍历的思路，可以得出答案。但是先记录一下... |
| 2021.04.08 | [1008. 前序遍历构造二叉搜索树](https://leetcode-cn.com/problems/construct-binary-search-tree-from-preorder-traversal/)<br>[971. 翻转二叉树以匹配先序遍历](https://leetcode-cn.com/problems/flip-binary-tree-to-match-preorder-traversal/) | 最近几天就刷了几道题，都属于中等难度的，发现中等难度的题目都跟一些基础解法强相关，做的这几道题的核心解法几乎都可以从之前做过的题目中得到答案 1008. ... |
| 2021.04.09 | [173. 二叉搜索树迭代器](https://leetcode-cn.com/problems/binary-search-tree-iterator/)<br>[114. 二叉树展开为链表](https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/)<br>[1028. 从先序遍历还原二叉树](https://leetcode-cn.com/problems/recover-a-tree-from-preorder-traversal/)<br>[面试题 04.09. 二叉搜索树序列](https://leetcode-cn.com/problems/bst-sequences-lcci/)<br>[1130. 叶值的最小代价生成树](https://leetcode-cn.com/problems/minimum-cost-tree-from-leaf-values/) | 173. 二叉搜索树迭代器 属于二叉搜索树基本概念的考察，根据题意，需要设立哨兵，在构造迭代器的时候拿到二叉搜索树的中序遍历序列，其他方法只需要按要求实现... |
| 2021.04.11 | [面试题 04.02. 最小高度树](https://leetcode-cn.com/problems/minimum-height-tree-lcci/)<br>[剑指 Offer 27. 二叉树的镜像](https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/)<br>[226. 翻转二叉树](https://leetcode-cn.com/problems/invert-binary-tree/)<br>[剑指 Offer 55 - I. 二叉树的深度](https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/)<br>[104. 二叉树的最大深度](https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/)<br>[剑指 Offer 55 - II. 平衡二叉树](https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/) | 开始以 树 为筛选条件进行刷题，难度从简单到困难 面试题 04.02. 最小高度树 这道题，题意是让我们根据一个升序序列构造出一个高度最小的二叉搜索树（因... |
| 2021.04.12 | [617. 合并二叉树](https://leetcode-cn.com/problems/merge-two-binary-trees/) | 617. 合并二叉树 按照题意，是希望将相同位置的节点值叠加后形成新的节点，如果节点只在某一个树上存在，则直接取该树的节点值作为结果树该节点的值，使用递归... |
| 2021.04.13 | [938. 二叉搜索树的范围和](https://leetcode-cn.com/problems/range-sum-of-bst/) | 938. 二叉搜索树的范围和 因为做了今天的每日一题，也是二叉搜索树类型，在中序遍历的过程中，取到节点值然后判断节点你是否处于给定的范围内，如果是则累加结... |
| 2021.04.14 | [700. 二叉搜索树中的搜索](https://leetcode-cn.com/problems/search-in-a-binary-search-tree/)<br>[108. 将有序数组转换为二叉搜索树](https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/) | 还是简单题节奏，都能自己做出来 代码链接 700. 二叉搜索树中的搜索 这题在中序遍历的过程中，判断节点值是否与目标值相等，相等就将该节点返回即可 108... |
| 2021.04.15 | [剑指 Offer 54. 二叉搜索树的第k大节点](https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/)<br>[637. 二叉树的层平均值](https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/) | 剑指 Offer 54. 二叉搜索树的第k大节点 根据题意可以转化为求升序序列中，第 k 大个元素，做题的时候，我先拿到了中序遍历序列，然后遍历该序列，得... |
| 2021.04.29 | [剑指 Offer 68 - II. 二叉树的最近公共祖先](https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/) | 半个月没好好刷算法了，今天看了这个简单的题目都想半天，没思路，在这种情况下也没有想将满足题目要求的条件分类尝试解决，还是没能形成解决问题的思路 剑指 Of... |
| 2021.05.06 | [剑指 Offer 68 - II. 二叉树的最近公共祖先](https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/)<br>[1022. 从根到叶的二进制数之和](https://leetcode-cn.com/problems/sum-of-root-to-leaf-binary-numbers/) | 剑指 Offer 68 - II. 二叉树的最近公共祖先 最近公共祖先的定义是给定树中的两个节点，距离两个节点距离最近的公共父节点（如果一个树只有一个节点... |
| 2021.05.08 | [965. 单值二叉树](https://leetcode-cn.com/problems/univalued-binary-tree/)<br>[257. 二叉树的所有路径](https://leetcode-cn.com/problems/binary-tree-paths/) | 965. 单值二叉树 根据单值二叉树的定义，只要有一个节点值跟其他节点值不一样，就不算是单值二叉树，那在前序遍历的过程中，传入根节点的值，如果发现有节点值... |
| 2021.05.10 | [235. 二叉搜索树的最近公共祖先](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/) | 235. 二叉搜索树的最近公共祖先 本题中的树是二叉搜索树，因此可以利用其特性，节点的左子树的值都会小于节点值，右子树的值都会大于节点值，然后切换节点进行... |
| 2021.05.10 | [面试题 17.12. BiNode](https://leetcode-cn.com/problems/binode-lcci/) | 面试题 17.12. BiNode 与之前有一道通过中序遍历构造只有右子树的题目类型，然后就按照思路先进行中序遍历，然后根据中序遍历结果生成结果树，可以通... |
| 2021.05.13 | [530. 二叉搜索树的最小绝对差](https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/solution/530-er-cha-sou-suo-shu-de-zui-xiao-jue-d-76ch/)<br>[563. 二叉树的坡度](https://leetcode-cn.com/problems/binary-tree-tilt/submissions/) | 530. 二叉搜索树的最小绝对差 记录前一个节点，中序遍历过程中如果前节点为空则将当前节点赋值，如果前节点不为空则比较两个节点值差的绝对值然后与最小值进行... |
| 2021.05.16 | [剑指 Offer 28. 对称的二叉树](https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/) | 剑指 Offer 28. 对称的二叉树 根据题意，以根节点为中线，左右两边的树节点个数对应，已经值对应，那每次递归都传入节点都左、右子节点，然后进行判断，... |
| 2021.05.24 | [543. 二叉树的直径](https://leetcode-cn.com/problems/diameter-of-binary-tree/) | 543. 二叉树的直径 声明结果变量，递归获取二叉树的高度，每次获取的过程中，记录左、右子树的高度 + 1 的值作为结果值（以最大为准），递归结束，得出结... |
| 2021.08.01 | [面试题 04.04. 检查平衡性](https://leetcode-cn.com/problems/check-balance-lcci/)<br>[404. 左叶子之和](https://leetcode-cn.com/problems/sum-of-left-leaves/) | 面试题 04.04. 检查平衡性 结合求二叉树高度的方法，分别获取左子树和右子树的深度，然后对比这两个值的差值，如果小于 2 表示平衡，返回当前树的高度，... |

[查看完整讨论 →](https://github.com/ZakAnun/discussing-algorithm/issues/1)

---

## [#2 每日一题](https://github.com/ZakAnun/discussing-algorithm/issues/2)

> 记录一下每日一题（为了拿到力扣全家桶周边(^^)）

| 日期 | 题目 | 备注 |
| --- | --- | --- |
| 2021.04.10 | [263. 丑数](https://leetcode-cn.com/problems/ugly-number/) | 263. 丑数 题目文字很简陋，和/或读半天没读明白，大概是给出了丑数的定义，然后让我们判断入参是否为丑数 首先: 判断边界条件，<= 0 的数肯定不为丑... |
| 2021.04.11 | [264. 丑数 II](https://leetcode-cn.com/problems/ugly-number-ii/) | 264. 丑数 II 题意是让我们找到从 1 开始，第 n 个丑数 一开始我想的是从 1 到 n 遍历，然后判断每个树是否为丑数，如果是则将它加入到结果集... |
| 2021.04.12 | [179. 最大数](https://leetcode-cn.com/problems/largest-number/) | 179. 最大数 题意是让我们将给定的数组中的数字进行排列，形成一个最大的数 先思考，要想得到最大的数，就比较全部数字中 % 10 后的最大值，放在前面，... |
| 2021.04.13 | [783. 二叉搜索树节点最小距离](https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/) | 783. 二叉搜索树节点最小距离 二叉搜索树，返回树中任意两个不同节点值之间的最小差值 一拿到二叉搜索树，需要先反应它中序遍历序列的特点是一个升序序列，想... |
| 2021.04.14 | [208. 实现 Trie (前缀树)](https://leetcode-cn.com/problems/implement-trie-prefix-tree/) | 208. 实现 Trie (前缀树) 构造类型题目，具体要求去题目里看吧 一开始看到这个题，还以为是要构造一个树，但是题意是想要查找字符串，然后我直接选用... |
| 2021.04.15 | [213. 打家劫舍 II](https://leetcode-cn.com/problems/house-robber-ii/submissions/) | 213. 打家劫舍 II 代码链接 |
| 2021.04.20 | [28. 实现 strStr()](https://leetcode-cn.com/problems/implement-strstr/) | 28. 实现 strStr() 题意很明确，在 java 中可以直接使用 String.indexOf() 来解决这道题，然后想了一下为什么这个方法的时间... |
| 2021.04.30 | [137. 只出现一次的数字 II](https://leetcode-cn.com/problems/single-number-ii/) | 137. 只出现一次的数字 II 使用 hasdMap 记录遍历的数字和出现的次数，比较容易实现 代码链接 |
| 2021.05.06 | [1720. 解码异或后的数组](https://leetcode-cn.com/problems/decode-xored-array/) | 1720. 解码异或后的数组 简单类型的题目，关键在于找到 arr[i + 1] = arr[i] ^ encoded[i]; 这个关系，然后一次遍历得出... |
| 2021.05.07 | [1486. 数组异或操作](https://leetcode-cn.com/problems/xor-operation-in-an-array/) | 1486. 数组异或操作 题目提供了计算公式，开始使用暴力解法，先将数组构建出来，然后再对数据进行遍历进行逐位异或的计算操作，但是在写第二个循环的时候发现... |
| 2021.05.08 | [1723. 完成所有工作的最短时间](https://leetcode-cn.com/problems/find-minimum-time-to-finish-all-jobs/) | 1723. 完成所有工作的最短时间 之前富途面试的时候被问到过这个题，先白嫖积分.... 代码链接 |
| 2021.05.09 | [1482. 制作 m 束花所需的最少天数](https://leetcode-cn.com/problems/minimum-number-of-days-to-make-m-bouquets/solution/zhi-zuo-m-shu-hua-suo-xu-de-zui-shao-tia-mxci/) | 1482. 制作 m 束花所需的最少天数 开始的解题思路是对原数组的每个 item 进行递减，直到为 0，在过程中找到符合 m 的循环次数，然后将结果返回... |
| 2021.05.10 | [872. 叶子相似的树](https://leetcode-cn.com/problems/leaf-similar-trees/) | 872. 叶子相似的树 叶子相似的定义是两个树的叶子按从左到右的顺序排列后一致，说明两个树为叶子相似的二叉树。 那采用深度优先的方式拿到每棵树的叶子结点集... |
| 2021.05.11 | [1734. 解码异或后的排列](https://leetcode-cn.com/problems/decode-xored-permutation/) | 1734. 解码异或后的排列 这个题目之前做过简单版的（1720. 解码异或后的数组），所以知道要找到结果数组的第一个元素，但是推理能力不够，要是下回遇到... |
| 2021.05.13 | [1310. 子数组异或查询](https://leetcode-cn.com/problems/xor-queries-of-a-subarray/) | （串了一天....） 1310. 子数组异或查询 二维数组表示异或的范围，那么只需要遍历取，然后每次进行异或计算即可 代码链接 |
| 2021.05.14 | [12. 整数转罗马数字](https://leetcode-cn.com/problems/integer-to-roman/) | 12. 整数转罗马数字 需要罗列出全部的条件，然后对传入数字进行按罗马数字对应的整数做减法运算，每减一次就拼接上对应的罗马数字直到结束 代码链接 |
| 2021.05.15 | [13. 罗马数字转整数](https://leetcode-cn.com/problems/roman-to-integer/) | 13. 罗马数字转整数 这题主要还是得发现与 4、9 的罗马数 IV、IX 与其他按从小到大的罗马数的区别，这种情况需要判断的点是后一个是否比前一个大，如... |
| 2021.05.16 | [421. 数组中两个数的最大异或值](https://leetcode-cn.com/problems/maximum-xor-of-two-numbers-in-an-array/solution/shu-zu-zhong-liang-ge-shu-de-zui-da-yi-h-n9m9/)<br>[题解](https://leetcode-cn.com/problems/maximum-xor-of-two-numbers-in-an-array/solution/shu-zu-zhong-liang-ge-shu-de-zui-da-yi-h-n9m9/) | 421. 数组中两个数的最大异或值 这题暴力方法是以 O(n^2) 的时间复杂度完成判断，题解没看到明白...（TODO） 代码链接 |
| 2021.05.18 | [1442. 形成两个异或相等数组的三元组数目](https://leetcode-cn.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor) | 1442. 形成两个异或相等数组的三元组数目 代码链接 |
| 2021.05.19 | [1738. 找出第 K 大的异或坐标值](https://leetcode-cn.com/problems/find-kth-largest-xor-coordinate-value/) | 1738. 找出第 K 大的异或坐标值 代码链接 |
| 2021.05.20 | [692. 前K个高频单词](https://leetcode-cn.com/problems/top-k-frequent-words/) | 692. 前K个高频单词 - 首先将每个单词以及其出现的次数存到哈希表里（可以使用 getOrDefault(key, defaultVal) 减少是否包... |
| 2021.06.09 | [两数之和](https://leetcode-cn.com/problems/two-sum/) | 之前一段时间忙得一批，闲下来就用了一下朋友介绍给我的刷题插件，方便得飞起，代码模版、题目信息都可以在 ide（我用的 Android Studio）里配置... |
| 2021.07.02 | [1833. 雪糕的最大数量](https://leetcode-cn.com/problems/maximum-ice-cream-bars/) | 1833. 雪糕的最大数量 先对 costs 排序，因为要想在给定的价钱里买到最多的雪糕，就得选便宜的，然后再遍历，递减 coins，每减一次结果数就加一... |
| 2021.07.03 | [451. 根据字符出现频率排序](https://leetcode-cn.com/problems/sort-characters-by-frequency/) | 451. 根据字符出现频率排序 利用 HashMap 协助将字符整理起来，key 为字符，value 为出现次数，然后将 key 整理为集合用作排序，通过... |
| 2021.07.04 | [645. 错误的集合](https://leetcode-cn.com/problems/set-mismatch/) | 645. 错误的集合 先对入参进行排序，完了需要记录一下上一个的值，因为要从 1 开始对比，所以 last 值初始化为 0，然后开始比较。 1、如果当前的... |
| 2021.07.05 | [101. 对称二叉树](https://leetcode-cn.com/problems/symmetric-tree/) | 101. 对称二叉树 判断对称的条件 - 根节点的左子节点与根节点的右子节点的值相等 - 二级节点后，左节点的左子节点需要与同层的右节点的右子节点值相同（... |
| 2021.07.06 | [146. LRU 缓存机制](https://leetcode-cn.com/problems/lru-cache/) | 146. LRU 缓存机制 Java 中实现这样的 API 为 LinkedList 手动简单书写代码的思路如下： 实现 LRU 缓存的核心是（双向链表 ... |
| 2021.07.07 | [1711. 大餐计数](https://leetcode-cn.com/problems/count-good-meals/) | 1711. 大餐计数 按照题意，我本来想着是嵌套循环，然后按位加，再求符合 2 的幂的结果的次数，最后得出结果，但首先没有考虑到时间复杂度，其次没有想到用... |
| 2021.07.08 | [930. 和相同的二元子数组](https://leetcode-cn.com/problems/binary-subarrays-with-sum/) | 930. 和相同的二元子数组 首次接触滑动窗口的题目，看题解看得有点蒙，代码好理解一些，判断如果比指定大的话，右边界就停止滑动，左边界开始滑动 （不熟悉，... |
| 2021.07.09 | [面试题 17.10. 主要元素](https://leetcode-cn.com/problems/find-majority-element-lcci/) | 面试题 17.10. 主要元素 这道题我的思路是先将数组排序，然后记录每次变化经历了多少个元素，并记录出现次数大于数组一般长度时的数组元素，在 leet-... |
| 2021.07.11 | [981. 基于时间的键值存储](https://leetcode-cn.com/problems/time-based-key-value-store/) | 981. 基于时间的键值存储 // 待补充 代码链接 |
| 2021.07.16 | [剑指 Offer 53 - I. 在排序数组中查找数字 I](https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/) | 剑指 Offer 53 - I. 在排序数组中查找数字 I 暴力解法是一次遍历数组，然后判断每个元素与 target 值是否一致，一致则记录次数，遍历结束... |
| 2021.07.17 | [剑指 Offer 42. 连续子数组的最大和](https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/) | 剑指 Offer 42. 连续子数组的最大和 经典求最值的问题，动态解决，官方题解里的视频说得很清晰，dp[i] 表示前 i 个元素的和，那么 dp[i]... |
| 2021.07.19 | [面试题 10.02. 变位词组](https://leetcode-cn.com/problems/group-anagrams-lcci/)<br>[1838. 最高频元素的频数](https://leetcode-cn.com/problems/frequency-of-the-most-frequent-element/) | 面试题 10.02. 变位词组 这个题的关键在于区分出变位词，需要将变位词都放在一起，一种思路就是将每个字符串都转换成字符数组，然后对这个字符数组进行排序... |
| 2021.07.20 | [1877. 数组中最大数对和的最小值](https://leetcode-cn.com/problems/minimize-maximum-pair-sum-in-array/) | 1877. 数组中最大数对和的最小值 这个是第一次可以跟题解的思路一致的题目.... 开始看这个题目的时候，有点不能理解数对和，多看几次发现，如果要满足题... |
| 2021.07.21 | [剑指 Offer 52. 两个链表的第一个公共节点](https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/) | 剑指 Offer 52. 两个链表的第一个公共节点 比较难想，这个题我就想出来处理头节点有一个为 null，就不会有相交的情况，原来的思路是在记录两个链表... |
| 2021.07.22 | [138. 复制带随机指针的链表](https://leetcode-cn.com/problems/copy-list-with-random-pointer/) | 138. 复制带随机指针的链表 //待补充 代码链接 |
| 2021.07.23 | [1893. 检查是否区域内所有整数都被覆盖](https://leetcode-cn.com/problems/check-if-all-the-integers-in-a-range-are-covered/) | 1893. 检查是否区域内所有整数都被覆盖 代码链接 |
| 2021.07.24 | [1736. 替换隐藏数字得到的最晚时间](https://leetcode-cn.com/problems/latest-time-by-replacing-hidden-digits/) | 1736. 替换隐藏数字得到的最晚时间 简单替换字符 代码链接 |
| 2021.07.26 | [9. 回文数](https://leetcode-cn.com/problems/palindrome-number/) | 9. 回文数 转成字符串可以写出来，通过计算还得看题解... 代码链接 |
| 2021.07.28 | [863. 二叉树中所有距离为 K 的结点](https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree/) | 863. 二叉树中所有距离为 K 的结点 一时间并没有思路，感觉算是个二叉树比较综合的题型，题解使用深度优先 + 哈希表 - 哈希表用于存储节点的父节点 ... |
| 2021.08.09 | [112. 路径总和](https://leetcode-cn.com/problems/path-sum/) | 112. 路径总和 代码链接 |
| 2021.08.10 | [413. 等差数列划分](https://leetcode-cn.com/problems/arithmetic-slices/) | 413. 等差数列划分 代码链接 |
| 2021.08.11 | [446. 等差数列划分 II - 子序列](https://leetcode-cn.com/problems/arithmetic-slices-ii-subsequence/) | 446. 等差数列划分 II - 子序列 代码链接 |
| 2021.08.12 | [516. 最长回文子序列](https://leetcode-cn.com/problems/longest-palindromic-subsequence/) | 516. 最长回文子序列 代码链接 |
| 2021.08.13 | [233. 数字 1 的个数](https://leetcode-cn.com/problems/number-of-digit-one/) | 233. 数字 1 的个数 代码链接 |
| 2021.08.16 | [166. 分数到小数](https://leetcode-cn.com/problems/fraction-to-recurring-decimal/) | 166. 分数到小数 代码链接 |
| 2021.08.17 | [551. 学生出勤记录 I](https://leetcode-cn.com/problems/student-attendance-record-i/) | 551. 学生出勤记录 I 代码链接 |
| 2021.08.19 | [345. 反转字符串中的元音字母](https://leetcode-cn.com/problems/reverse-vowels-of-a-string/) | 345. 反转字符串中的元音字母 反转字符串中的元音字母，分为几个步骤执行 1、需要判断字母是否为元音字母，那判断元音字母可以使用 HashSet 存储然... |
| 2021.08.20 | [450. 删除二叉搜索树中的节点](https://leetcode-cn.com/problems/delete-node-in-a-bst/) | 450. 删除二叉搜索树中的节点 这是昨天面试的算法题，很遗憾没有做出来，就跟前面好多题目一样，虽然有基本思路，但是因为没有将整个问题进行分解，所以当时我... |
| 2021.08.21 | [443. 压缩字符串](https://leetcode-cn.com/problems/string-compression/) | 443. 压缩字符串 因为题目要求是需要常量级别的的空间算法，我用 StringBuilder 虽然可以压缩成功，就是嵌套循环，然后记录不一样的字符的下标... |
| 2021.08.22 | [剑指 Offer II 002. 二进制加法](https://leetcode-cn.com/problems/JFETK5/) | 老是点错关闭了 issue... 剑指 Offer II 002. 二进制加法 今天 leetcode 的每日一题，是我不太想做的类型，然后我选了二叉树，... |
| 2021.08.23 | [1646. 获取生成数组中的最大值](https://leetcode-cn.com/problems/get-maximum-in-generated-array/) | 1646. 获取生成数组中的最大值 一开始还想着去凑题目中给出的两个关系式，以完成数组元素的赋值，但下标的处理很繁琐（缺乏对题目理解并分析的经验） 其实题... |
| 2021.08.24 | [912. 排序数组](https://leetcode-cn.com/problems/sort-an-array/) | 912. 排序数组 数组的排序，先了解的快排的实现，其实 Arrays.sort 这个方法里包含了冒泡、快排等实现，在工程使用上比较合理 快排的思路 1、... |
| 2021.08.24 | [881. 救生艇](https://leetcode-cn.com/problems/boats-to-save-people/) | 881. 救生艇 代码链接 |
| 2021.08.29 | [1588. 所有奇数长度子数组的和](https://leetcode-cn.com/problems/sum-of-all-odd-length-subarrays/) | 1588. 所有奇数长度子数组的和 代码链接 |
| 2021.08.30 | [528. 按权重随机选择](https://leetcode-cn.com/problems/random-pick-with-weight/) | 528. 按权重随机选择 随机选择题目，开始的时候把题目的意思理解错了，~~还以为是下标 i 出现的概率是 i / 整个数组的和，所以在思考上也出现了偏差... |
| 2021.08.31 | [1109. 航班预订统计](https://leetcode-cn.com/problems/corporate-flight-bookings/)<br>[题解](https://leetcode-cn.com/problems/corporate-flight-bookings/solution/hang-ban-yu-ding-tong-ji-by-leetcode-sol-5pv8/) | 1109. 航班预订统计 这道题目的暴力算法之前有做过，但是具体哪道题有点忘记了，暴力算法思路是遍历二元数组，然后根据每个二元数组的数据，给结果数组的 i... |

[查看完整讨论 →](https://github.com/ZakAnun/discussing-algorithm/issues/2)

---

## [#3 2021.09](https://github.com/ZakAnun/discussing-algorithm/issues/3)

| 日期 | 题目 | 备注 |
| --- | --- | --- |
| 2021.09.01 | [165. 比较版本号](https://leetcode-cn.com/problems/compare-version-numbers/) | 165. 比较版本号 能够想出来的方法就是以 . 为分隔符对两个版本号字符串进行划分（注意在 Java 中调用 split 时，. 需要使用 \\. 进行... |
| 2021.09.03 | [面试题 17.14. 最小K个数](https://leetcode-cn.com/problems/smallest-k-lcci/) | 面试题 17.14. 最小K个数 本题只需先排序，然后再遍历 k 次即可找出 k 个数，关键在于排序的实现（可以看看快排和堆排），但我觉得这个题本身是考虑... |
| 2021.09.08 | [剑指 Offer II 052. 展平二叉搜索树](https://leetcode-cn.com/problems/NYBBNL/) | 剑指 Offer II 052. 展平二叉搜索树 今天的题目难度是困难，就挑了一个简单的二叉树来练习一下，这个题是根据中序遍历的序列构建一个只有右子节点的... |
| 2021.09.10 | [1894. 找到需要补充粉笔的学生编号](https://leetcode-cn.com/problems/find-the-student-that-will-replace-the-chalk/) | 1894. 找到需要补充粉笔的学生编号 开始的思路有点乱，想着先遍历一边数组，k 减去数组的每个 item，但这样的话无法确定什么时候停止减法的操作，其实... |

[查看完整讨论 →](https://github.com/ZakAnun/discussing-algorithm/issues/3)

---


## 相关链接

- [GitHub 仓库](https://github.com/ZakAnun/discussing-algorithm)
- [Issues 讨论区](https://github.com/ZakAnun/discussing-algorithm/issues)
- [LeetCode 中国站](https://leetcode-cn.com/)
- [labuladong 算法小抄](https://github.com/labuladong/fucking-algorithm)
