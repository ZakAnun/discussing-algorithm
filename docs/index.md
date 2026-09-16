---
layout: default
title: discussing-algorithm
---

# discussing-algorithm

算法刷题记录与讨论总结，题目主要来自 [LeetCode 中国站](https://leetcode-cn.com/)，按 [labuladong 的刷题思路](https://github.com/labuladong/fucking-algorithm) 进行练习。

本页完整归档 GitHub Issues 中的刷题笔记（含正文与全部评论）。

---

## 目录

- [#1 树](#issue-1-overview)
  - [正文](#issue-1-intro)
  - [正文 · 2021.03.17](#issue-1-2021-03-17)
  - [评论 · 2021.03.19](#issue-1-comment-1-2021-03-19)
  - [评论 · 2021.03.20](#issue-1-comment-1-2021-03-20)
  - [评论 · 2021.03.23](#issue-1-comment-2-2021-03-23)
  - [评论 · 2021.03.26](#issue-1-comment-3-2021-03-26)
  - [评论 · 2021.03.30](#issue-1-comment-4-2021-03-30)
  - [评论 · 2021.03.31](#issue-1-comment-5-2021-03-31)
  - [评论 · 2021.04.08](#issue-1-comment-6-2021-04-08)
  - [评论 · 2021.04.09](#issue-1-comment-7-2021-04-09)
  - [评论 · 2021.04.11](#issue-1-comment-8-2021-04-11)
  - [评论 · 2021.04.12](#issue-1-comment-9-2021-04-12)
  - [评论 · 2021.04.13](#issue-1-comment-10-2021-04-13)
  - [评论 · 2021.04.14](#issue-1-comment-11-2021-04-14)
  - [评论 · 2021.04.15](#issue-1-comment-12-2021-04-15)
  - [评论 · 2021.04.29](#issue-1-comment-13-2021-04-29)
  - [评论 · 2021.05.10](#issue-1-comment-13-2021-05-10)
  - [评论 · 2021.05.06](#issue-1-comment-14-2021-05-06)
  - [评论 · 2021.05.08](#issue-1-comment-15-2021-05-08)
  - [评论 · 2021.05.10](#issue-1-comment-16-2021-05-10)
  - [评论 · 2021.05.13](#issue-1-comment-17-2021-05-13)
  - [评论 · 2021.05.16](#issue-1-comment-18-2021-05-16)
  - [评论 · 2021.05.24](#issue-1-comment-19-2021-05-24)
  - [评论 · 2021.08.01](#issue-1-comment-20-2021-08-01)

- [#2 每日一题](#issue-2-overview)
  - [正文](#issue-2-intro)
  - [评论 · 2021.04.10](#issue-2-comment-1-2021-04-10)
  - [评论 · 2021.04.11](#issue-2-comment-2-2021-04-11)
  - [评论 · 2021.04.12](#issue-2-comment-3-2021-04-12)
  - [评论 · 2021.04.13](#issue-2-comment-4-2021-04-13)
  - [评论 · 2021.04.14](#issue-2-comment-5-2021-04-14)
  - [评论 · 2021.04.15](#issue-2-comment-6-2021-04-15)
  - [评论 · 2021.04.20](#issue-2-comment-7-2021-04-20)
  - [评论 · 2021.04.30](#issue-2-comment-8-2021-04-30)
  - [评论 · 2021.05.06](#issue-2-comment-9-2021-05-06)
  - [评论 · 2021.05.07](#issue-2-comment-10-2021-05-07)
  - [评论 · 2021.05.08](#issue-2-comment-11-2021-05-08)
  - [评论 · 2021.05.09](#issue-2-comment-12-2021-05-09)
  - [评论 · 2021.05.10](#issue-2-comment-13-2021-05-10)
  - [评论 · 2021.05.11](#issue-2-comment-14-2021-05-11)
  - [评论 · 2021.05.13](#issue-2-comment-15-2021-05-13)
  - [评论 · 2021.05.14](#issue-2-comment-16-2021-05-14)
  - [评论 · 2021.05.15](#issue-2-comment-17-2021-05-15)
  - [评论 · 2021.05.16](#issue-2-comment-17-2021-05-16)
  - [评论 · 2021.05.18](#issue-2-comment-18-2021-05-18)
  - [评论 · 2021.05.19](#issue-2-comment-19-2021-05-19)
  - [评论 · 2021.05.20](#issue-2-comment-20-2021-05-20)
  - [评论 · 2021.06.09](#issue-2-comment-21-2021-06-09)
  - [评论 · 2021.07.02](#issue-2-comment-22-2021-07-02)
  - [评论 · 2021.07.03](#issue-2-comment-23-2021-07-03)
  - [评论 · 2021.07.04](#issue-2-comment-24-2021-07-04)
  - [评论 · 2021.07.05](#issue-2-comment-25-2021-07-05)
  - [评论 · 2021.07.06](#issue-2-comment-26-2021-07-06)
  - [评论 · 2021.07.07](#issue-2-comment-27-2021-07-07)
  - [评论 · 2021.07.08](#issue-2-comment-28-2021-07-08)
  - [评论 · 2021.07.09](#issue-2-comment-29-2021-07-09)
  - [评论 · 2021.07.11](#issue-2-comment-30-2021-07-11)
  - [评论 · 2021.07.16](#issue-2-comment-31-2021-07-16)
  - [评论 · 2021.07.17](#issue-2-comment-32-2021-07-17)
  - [评论 · 2021.07.19](#issue-2-comment-33-2021-07-19)
  - [评论 · 2021.07.20](#issue-2-comment-34-2021-07-20)
  - [评论 · 2021.07.21](#issue-2-comment-35-2021-07-21)
  - [评论 · 2021.07.22](#issue-2-comment-36-2021-07-22)
  - [评论 · 2021.07.23](#issue-2-comment-37-2021-07-23)
  - [评论 · 2021.07.24](#issue-2-comment-38-2021-07-24)
  - [评论 · 2021.07.26](#issue-2-comment-39-2021-07-26)
  - [评论 · 2021.07.28](#issue-2-comment-40-2021-07-28)
  - [评论 · 2021.08.09](#issue-2-comment-41-2021-08-09)
  - [评论 · 2021.08.10](#issue-2-comment-42-2021-08-10)
  - [评论 · 2021.08.11](#issue-2-comment-43-2021-08-11)
  - [评论 · 2021.08.12](#issue-2-comment-44-2021-08-12)
  - [评论 · 2021.08.13](#issue-2-comment-45-2021-08-13)
  - [评论 · 2021.08.16](#issue-2-comment-46-2021-08-16)
  - [评论 · 2021.08.17](#issue-2-comment-47-2021-08-17)
  - [评论 · 2021.08.19](#issue-2-comment-48-2021-08-19)
  - [评论 · 2021.08.20](#issue-2-comment-49-2021-08-20)
  - [评论 · 2021.08.21](#issue-2-comment-50-2021-08-21)
  - [评论 · 2021.08.22](#issue-2-comment-51-2021-08-22)
  - [评论 · 2021.08.23](#issue-2-comment-52-2021-08-23)
  - [评论 · 2021.08.24](#issue-2-comment-53-2021-08-24)
  - [评论 · 2021.08.24](#issue-2-comment-54-2021-08-24)
  - [评论 · 2021.08.29](#issue-2-comment-55-2021-08-29)
  - [评论 · 2021.08.30](#issue-2-comment-56-2021-08-30)
  - [评论 · 2021.08.31](#issue-2-comment-57-2021-08-31)

- [#3 2021.09](#issue-3-overview)
  - [正文 · 2021.09.01](#issue-3-2021-09-01)
  - [评论 · 2021.09.03](#issue-3-comment-1-2021-09-03)
  - [评论 · 2021.09.08](#issue-3-comment-2-2021-09-08)
  - [评论 · 2021.09.10](#issue-3-comment-3-2021-09-10)

**合计：** 3 个 Issue，87 个章节，约 122 道题。

---

## [#1 树](https://github.com/ZakAnun/discussing-algorithm/issues/1)

<a id="issue-1-overview"></a>

[在 GitHub 查看原 Issue →](https://github.com/ZakAnun/discussing-algorithm/issues/1)

#### 正文

<a id="issue-1-intro"></a>

**代码放得比较简陋，点击链接去到的地方，通过题目来搜索就可以定位到对应的代码块**

#### 正文 · 2021.03.17

<a id="issue-1-2021-03-17"></a>

遍历二叉树最基本的三种方式：[144.前序遍历](https://leetcode-cn.com/problems/binary-tree-preorder-traversal/)、[94.中序遍历](https://leetcode-cn.com/problems/binary-tree-inorder-traversal/)、[145.后序遍历](https://leetcode-cn.com/problems/binary-tree-postorder-traversal/)

三种遍历的差别在与先拿到哪个节点，这在代码中能清晰得知（从前一直区分不了这三种遍历，想了一下原因在于当年不知道咋的总结出来的口诀，是错的.....若是通过代码记忆，效果应该会好一些）

```
public void binTreeTraversal(TreeNode treeNode) {
    if (treeNode == null) {
        return;
    }

    // 前序遍历拿值
    binTreeTraversal(treeNode.getLeft())
    // 中序遍历拿值
    binTreeTraversal(treeNode.getRight())
    // 后序遍历拿值
}
```

先将基本的遍历方式记住，然后再实践其他树的题目。[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/tree/BinTreeTraversal.java)

#### 评论 · 2021.03.19

<a id="issue-1-comment-1-2021-03-19"></a>

今天做了一下二叉树的层序遍历，看题目还是直接去题解看答案然后懂了 =-=

[102.二叉树的层序遍历](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/)要求从二叉树的根节点看是，逐层遍历出数据，看一眼觉得跟前面三种遍历关系不大，一点头绪没有。
力扣的官方题解中给出的思路是引入了一个队列来帮助区分层级（还有详细的证明过程....痛苦面具）
再仔细看代码，竟跟前序遍历的框架有点相像，但这里并不是递归，又因为是以层为优先，内层循环的作用是帮助我们拿到当前层的全部元素并将下一层的元素入队，得益于队列先进先出的特点，就可以按自顶相下的顺序拿到每个节点了。
类似层序遍历的题目:
 [剑指 Offer 32 - II. 从上到下打印二叉树 II](https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/)
[637. 二叉树的层平均值](https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/)**（2021.04.15）**


有了层序遍历的基础，那么自底向上的[107.二叉树的层序遍历](https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/)也就可以得出结论了，其实就是输出结果顺序的不同。

这个也可以记一下 ～_～。[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/tree/BinTreeTraversal.java)

#### 评论 · 2021.03.20

<a id="issue-1-comment-1-2021-03-20"></a>

今天看到层序遍历还有个变形就是[103.二叉树的锯齿形层序遍历](https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/)，首先当然是看一下什么是锯齿形层序遍历，题意为第一层从左往右输出，第二层从右往左输出，在层序遍历的基础上我们只需要确定每层所对应的输出顺序即可，我是定义了一个 int 值（奇数层为从左往右，偶数层从右往左）再在层序遍历的基础上添加这个逻辑就能得到答案。代码链接还是上面那个 ……^_^（果然记住了，基础就可以不用看题解就能应对变种题目）
类似的锯齿形（之字形）的题目: [剑指 Offer 32 - III. 从上到下打印二叉树 III](https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/)

#### 评论 · 2021.03.23

<a id="issue-1-comment-2-2021-03-23"></a>

[987.二叉树的垂序遍历](https://leetcode-cn.com/problems/vertical-order-traversal-of-a-binary-tree/)题目中垂序遍历的定义是从最左边的列到最右边的列，看到题目第一个思路是首先肯定是需要遍历一边二叉树，但是后面的思路空白...

直接看题解，题解中思路明确提出可以定义根结点的坐标值为 (0, 0)，那么左子树的坐标为 (-1, 1)，右子树的坐标为 (1, 1)。
拿到每个节点的左边关系，就可以将节点排序，然后按序输出，所以需要定义一下节点坐标的实体类以便排序。
最后是遍历节点坐标集合时的判断，这里的条件是看 x 坐标是否有变化（因为需要的是按列输出）。
如果 x 左边变化了就重新添加一个集合，之后的数据就加入到新集合中，遍历节点坐标集合完毕后，就能得出最终结果。

总结一下垂序遍历的思路，先遍历树，拿到每个节点的坐标，然后对坐标进行排序，排序结果即为最终结果。

这里面有个 Java Comparable 的小知识，重写 compareTo() 可以帮助我们完成比较的操作，很方便。[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/tree/BinTreeTraversal.java)

#### 评论 · 2021.03.26

<a id="issue-1-comment-3-2021-03-26"></a>

前天开始做一些根据遍历结果还原二叉树的题目，此类问题之前也有做过但是硬背了几遍再回看还是毫无头绪。缺乏思考推导的能力。一棵树遍历后能构造成一个集合，那么根据这个集合还原树，自然是没有问题的。

从前面前序遍历、中序遍历、后序遍历中可以得出以下结论:
前序遍历结果集: [根节点, [左子树前序遍历结果集], [右子树前序遍历结果集]]
中序遍历结果集: [[左子树中序遍历结果集], 根节点, [右子树中序遍历结果集]]
后序遍历结果集: [[左子树后序遍历结果集], [右子树后序遍历结果集], 根节点]

有了上面的基础结论，然后再挑战构造二叉树（[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/tree/BinTreeCreation.java)）: 
[105.从前序与中序遍历序列构造二叉树](https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)
[剑指 Offer 07. 重建二叉树](https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/)**（2021.04.01）**
如果要构建一棵树的话，首先应该是要找到其根节点，然后找该节点的子树，这种情况下采用递归的思路会比较直观，因为前序遍历结果集的第一个结果是树的根节点，那么通过它就可以定位到根节点在中序遍历结果集中的下标，那就可以知道根节点的左子树结果集和右子树结果集分别对应的下标（前序遍历和中序遍历结果集长度一样），那再分别对左子树和右子树进行递归，最终就可以还原成本来的树。 （隔了几天重做，发现坐标还是拿不准，错把子树的大小当成坐标使用了，**需要注意每次递归的边界条件由除根节点之外的其他数据的下标确定**）

[106.从中序与后序遍历序列构造二叉树](https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)
递归的思路跟 105 相似，也是根据中序遍历序列拿到根节点以及左子树、右子树的大小进行递归，代码实现的样子也可以很类似，需要注意的点是由于后序遍历的根节点是在最后，所以每次递归时都需将后序遍历右边界前移一位（跟前序遍历将左边界前移一位一个概念）

[889.根据前序和后序遍历构造二叉树](https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/)
前面两道题的解题思路都是以中序遍历结果为标准，得到子树，本题中，前序遍历和后序遍历看似不能直观地以某一个序列作为寻找子树的标准，这个时候就需要寻找两个序列的关联，从前面的基础结论中可以发现他俩的根节点会出现在固定的位置，那就将这个点作为寻找子树的标准，以前序遍历第二个元素（假设为左子树根节点）为标准寻找在后序遍历中该节点的位置，这样可以得到子树的总节点数，那自然就可以得到右子树的节点范围，此时只需要进行递归即可还原成本来的树（强行翻译了一波官方题解...）。另外，递归解法还用到了 Arrays 的 api，copyOfRange，这个方法用于拷贝一个数字，入参 2、3 表示原数组的起始和结束范围（代码中可以看到他是 end - start 用作新数组长度）

从上面三题可以得出结论，构建一棵树，我们首先要找到树的根节点，然后考虑构建该节点的左子树和右子树，而子树的构建又是一个树的构建，所以此类解法使用递归更加便于我们总结解题的方向。
细节上，我在实际解题的过程中，对于子树范围取值会比较模糊，总是会错几次才能修改过来，后续尝试先打个草稿再去执行。

#### 评论 · 2021.03.30

<a id="issue-1-comment-4-2021-03-30"></a>

刷了大概一周多的二叉树，感觉上算是熟悉了基本思路，所以先尝试挑树的遍历中简单难度的题 [代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/tree/BinTreePractice.java)

[606.根据二叉树创建字符串](https://leetcode-cn.com/problems/construct-string-from-binary-tree/) 题中有提示说以前序遍历进行构建，花了大概 15 分钟想... 但事实证明想没用，直接跑一下代码就知道问题出在哪里，区分清楚左子树为空，但右子树不为空的情况即可（因为这种情况需要加上一对 "()" )，leet-code 上的官方题解比较简洁(对比于我手打的)，开始还想着直接把官方题解拷一份，后来想了想，还是用手打版本，虽然看着多一些，但可能会稍微好理解一点..

[897. 递增顺序查找树](https://leetcode-cn.com/problems/increasing-order-search-tree/) 这个题一开始想着在递归的过程中把结果树构建好，但经过尝试后发现有点不合适，看了题解，了解到可以先进行中序遍历，然后根据中序遍历的结果进行结果树的构建。经过这题的挣扎，意识到几个点，感觉可以帮助我们去思考: 
1、一个问题如果不好解，可以尝试分解为几个子问题，然后将子问题都解决后，这问题自然就被解决了
2、涉及到构建树的题型中，如果提供的是一个序列，那么可以递归实现，但如果提供的是树，那么就先尝试转换成序列后再下一步思考（找根节点，找左右子树）
3、因为开始就一直用递归的方式去处理问题，本题自然也就往递归的方向靠，虽然能够解出来，但 leet-code 上的耗时差异相比于循环确实差了一大截，可以看下面的结果图（以循环的方式确实可以在性能上有一定的提升）
<img src="https://raw.githubusercontent.com/ZakAnun/discussing-algorithm/master/app/src/main/res/897.%E5%BE%AA%E7%8E%AF%E8%A7%A3%E6%B3%95%E5%92%8C%E9%80%92%E5%BD%92%E8%A7%A3%E6%B3%95%E7%9A%84%E5%8C%BA%E5%88%AB.png" width="auto" height="320px"/>
目前来看，还是先以能够将题目解答出来（就是暴力算法）为目标，熟悉的解决算法问题的思路后，再考虑往提升算法性能上面靠拢吧...

#### 评论 · 2021.03.31

<a id="issue-1-comment-5-2021-03-31"></a>

树 + 遍历，这个筛选条件，简单题里有涉及到 N 叉树的题，之前直接被他的名字劝退了，但是仔细看看题目，直接按层序遍历的思路，可以得出答案。但是先记录一下 N 叉树的定义吧。

N 叉树定义为一个节点可以对应多个子节点，可能文字说明不好理解，但一看他的实体类就懂了 [实体类链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/tree/TreeNode.kt) [代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/tree/TreeTraversal.java)

[559.N 叉树的最大深度](https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/) 这个题目，我第一反应是将层序遍历的代码填上去，然后运行，直接通过了，但是能打败的人并不多（但是直接能做出来也是很有成就感的呀^_^）。完了，看了一下题解，题解中主要的递归思路是先对节点的每一个子树进行访问拿到每个子树的深度，然后记录在一个集合中，最后取最大的结果再加上根节点这一层，就能得到结果了。而层序遍历的思路恰恰是先访问每一层的节点，每层节点访问完毕后，层数加一。感觉这里刚好了解到深度优先遍历（递归实现思路）和广度优先遍历（层序遍历实现思路）的实现方式。显然这题使用深度优先的方式会比较合适。没事多看看回忆回忆，不然就忘了...

[429. N 叉树的层序遍历](https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/) 做完 559，初识 N 叉树也不是非常不可理解的情况后，再尝试一下它的层序遍历，看会不会有什么不同，结果是跟二叉树的层序遍历的流程类似，只不过每层需要入队的元素从原先的左、右子节点更换成了子节点集合而已，也是直接通关。看了题解，基本实现也是这种方式，虽然题解中有个简化版的，看了一下是节省了一个 for 循环: [题解-方法2](https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/solution/ncha-shu-de-ceng-xu-bian-li-by-leetcode/)

[589. N 叉树的前序遍历](https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/) 跟二叉树前序遍历递归的思路一致，加个循环对子树进行递归即可

[590. N 叉树的后序遍历](https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/) 跟二叉树后序遍历递归的思路一致，同样使用循环对子树进行递归即可

#### 评论 · 2021.04.08

<a id="issue-1-comment-6-2021-04-08"></a>

最近几天就刷了几道题，都属于中等难度的，发现中等难度的题目都跟一些基础解法强相关，做的这几道题的核心解法几乎都可以从之前做过的题目中得到答案

[1008. 前序遍历构造二叉搜索树](https://leetcode-cn.com/problems/construct-binary-search-tree-from-preorder-traversal/) 这道题的关键点在于二叉搜索树的中序遍历序列，是一个升序序列，我们可以将前序遍历序列排序后就能得出中序遍历序列，那这道题就可以看作是根据前序遍历和中序遍历构造二叉树，解法是一样的。[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/tree/BinTreeCreation.java)

[971. 翻转二叉树以匹配先序遍历](https://leetcode-cn.com/problems/flip-binary-tree-to-match-preorder-traversal/) 这道题直观上挺复杂，开始的思路是想遍历一遍二叉树，然后跟预期的前序遍历做比较，但是在写代码的过程中发现可以在每次递归的过程中就可以通过节点的值与预期先序遍历序列的值做比较。看了题解后（还是得看题解，因为知道了前面的一步之后，没有思路了...）意识到在没有相同值的前提下，如果前序遍历树的过程中，首先判断树的节点是否与预期一致，不一致则直接记录 -1，然后再判断其左子树的值是否一致，如果一致的话就按正常流程执行遍历，否则，就只有先走该节点的右子树，再走左子树（因为翻转），并且把这个节点记录到结果集合中，然后继续执行递归。[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/tree/BinTreeTraversal.java)

#### 评论 · 2021.04.09

<a id="issue-1-comment-7-2021-04-09"></a>

[173. 二叉搜索树迭代器](https://leetcode-cn.com/problems/binary-search-tree-iterator/) 属于二叉搜索树基本概念的考察，根据题意，需要设立哨兵，在构造迭代器的时候拿到二叉搜索树的中序遍历序列，其他方法只需要按要求实现即可（需要注意边界值的情况） [代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/tree/BSTIterator.java)

2021.04.10

[114. 二叉树展开为链表](https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/) 解题思路相对简单，就是通过前序遍历拿到结果序列，然后对这个结果序列进行二叉树的构建即可

**总结一下: **今天看了一下，题库的筛选里 - 树 - 遍历的筛选做的差不多，剩下的

[1028. 从先序遍历还原二叉树](https://leetcode-cn.com/problems/recover-a-tree-from-preorder-traversal/)
// TODO: 题解

[面试题 04.09. 二叉搜索树序列](https://leetcode-cn.com/problems/bst-sequences-lcci/)
// TODO: 题解

[1130. 叶值的最小代价生成树](https://leetcode-cn.com/problems/minimum-cost-tree-from-leaf-values/) 
// TODO: 题解

（其他要充钱的题目，暂时不做...）

上面三道题看完之后能想到的解题方式都是想将题目尽可能地转换成前面刷过的题目去解决，但最终发现都差点意思（做不出来），看了题解后跟前面的方式也有区别，所以决定换个筛选条件，扩充一下解题方式，然后再来做这些题目（ :-( ）

#### 评论 · 2021.04.11

<a id="issue-1-comment-8-2021-04-11"></a>

开始以 树 为筛选条件进行刷题，难度从简单到困难

[面试题 04.02. 最小高度树](https://leetcode-cn.com/problems/minimum-height-tree-lcci/) 
这道题，题意是让我们根据一个升序序列构造出一个高度最小的二叉搜索树（因为刚刚看完二叉搜索树序列的题目，要求列出全部的序列，就往难了想）其实这道题难度为简单的原因是只需要构造出一个满足条件的二叉树即可，那么根据二叉搜索树中序遍历的特性，自然就想起了构造的递归方式，通过定位中点，得到根节点，中点以前的内容递归构造左子树，中点以后的内容递归构造右子树，结束条件自然是开始下标不能大于结束下标
 [代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/tree/BinTreeCreation.java)

[剑指 Offer 27. 二叉树的镜像](https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/)
[226. 翻转二叉树](https://leetcode-cn.com/problems/invert-binary-tree/)**（2021.04.12）**
题中镜像的定义为节点的左右子树互换，那么很直接就能想到将树进行遍历，然后在过程中将结果树构建出来，前序遍历刚好能完成这个过程，此处依然以递归的方式进行解题
 [代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/tree/BinTreeCreation.java)

[剑指 Offer 55 - I. 二叉树的深度](https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/)
[104. 二叉树的最大深度](https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/)**（2021.04.13）**
二叉树的深度，才用 BFS（就是二叉树的垂序遍历，顺便记录一下拿到每层节点的次数） 和 DFS（三种基本遍历都属于深度优先） 都比较好实现，开始的思路是使用栈将每个节点存储起来，然后依次弹出，但是卡在了次数记录这个问题（没有想到再用一个栈记录层级），后面看了题解就知道了这种解法，虽然时间复杂度挺高但是也记录一下，另外再记录一下递归的解法（比较简单）
[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/tree/BinTreeTraversal.java)

[剑指 Offer 55 - II. 平衡二叉树](https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/)
平衡二叉树的定义是左右子树的高度差不超过 1，由前面一题二叉树的深度我们可以通过拿到二叉树深度的方式来判断每个子树的高度差，在左、右子树的高度差绝对值小于 2 的话，就可以进入下一次递归（就是走找到最大深度的遍历）否则返回 -1，然后在判断每次拿到的左子树结果值和右子树结果值，如果是 -1 则直接返回，再在主方法中判断拿到的结果是否 == -1，== -1 表示不是平衡二叉树
[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/tree/BinTreeTraversal.java)

#### 评论 · 2021.04.12

<a id="issue-1-comment-9-2021-04-12"></a>

[617. 合并二叉树](https://leetcode-cn.com/problems/merge-two-binary-trees/) 按照题意，是希望将相同位置的节点值叠加后形成新的节点，如果节点只在某一个树上存在，则直接取该树的节点值作为结果树该节点的值，使用递归的方式可以很轻松完成 [代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/tree/BinTreeCreation.java)

#### 评论 · 2021.04.13

<a id="issue-1-comment-10-2021-04-13"></a>

[938. 二叉搜索树的范围和](https://leetcode-cn.com/problems/range-sum-of-bst/)
因为做了今天的每日一题，也是二叉搜索树类型，在中序遍历的过程中，取到节点值然后判断节点你是否处于给定的范围内，如果是则累加结果，思路比较简单 [代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/tree/BinTreeTraversal.java)

#### 评论 · 2021.04.14

<a id="issue-1-comment-11-2021-04-14"></a>

还是简单题节奏，都能自己做出来 [代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/tree/BinTreeCreation.java)

[700. 二叉搜索树中的搜索](https://leetcode-cn.com/problems/search-in-a-binary-search-tree/)
这题在中序遍历的过程中，判断节点值是否与目标值相等，相等就将该节点返回即可

[108. 将有序数组转换为二叉搜索树](https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/)
简单类型的二叉搜索树构建，根据其中序遍历结果为升序序列，可以拿到根节点和左右子树（建树的简单版），就是取中点时是用开始下标 + 结束下标再除 2，这个细节需要注意

#### 评论 · 2021.04.15

<a id="issue-1-comment-12-2021-04-15"></a>

[剑指 Offer 54. 二叉搜索树的第k大节点](https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/)
根据题意可以转化为求升序序列中，第 k 大个元素，做题的时候，我先拿到了中序遍历序列，然后遍历该序列，得到第 k 大的数值，可以通过测试用例（依然性能不高）

看了精选题解，他的中序遍历是从右子树开始（降序序列），然后在中序遍历的过程中，对 k 值进行操作，当 k 值为 0 的时候，表示该节点的值为结果值，后续的遍历就可以不用继续进行

另外今天还做了一个[637. 二叉树的层平均值](https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/) 同时记录在层序遍历的笔记中，有些忘了，不能一下子写出来，但是有印象广度优先就用队列协助，深度优先就用递归实现

[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/tree/BinTreeTraversal.java)

#### 评论 · 2021.04.29

<a id="issue-1-comment-13-2021-04-29"></a>

半个月没好好刷算法了，今天看了这个简单的题目都想半天，没思路，在这种情况下也没有想将满足题目要求的条件分类尝试解决，还是没能形成解决问题的思路

[剑指 Offer 68 - II. 二叉树的最近公共祖先](https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/)
这道题，因为是需要找到最近公共祖先，需要先总结出满足条件的情况，才能有思路，其实都是遍历一棵树，只不过是在遍历的过程中找出符合题目要求的结果出来。
root 要想是 p、q 的公共祖先，需要满足以下条件
- p、q 在 root 的子树中，并且分列在 root 的异侧（分别在左右子树）
- p == root，且 q 在 root 的左 / 右子树中
- q == root，且 p 在 root 的左 / 右子树中
得到了这些条件，再通过后序遍历即可得出结果（这里需要注意的是，节点的比较，leet-code 上可以直接对比树节点，但在实际的代码上面还是得对比值） [代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/tree/BinTreeTraversal.java)

#### 评论 · 2021.05.10

<a id="issue-1-comment-13-2021-05-10"></a>

[235. 二叉搜索树的最近公共祖先](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/)
本题中的树是二叉搜索树，因此可以利用其特性，节点的左子树的值都会小于节点值，右子树的值都会大于节点值，然后切换节点进行遍历

[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/tree/BinTreeTraversal.java)

#### 评论 · 2021.05.06

<a id="issue-1-comment-14-2021-05-06"></a>

[剑指 Offer 68 - II. 二叉树的最近公共祖先](https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/)

最近公共祖先的定义是给定树中的两个节点，距离两个节点距离最近的公共父节点（如果一个树只有一个节点，那么该节点也被认为是它自己的祖先）
找树节点那肯定是要通过遍历，而处理这个题使用递归的方式需要梳理清晰几个终止条件
- 当节点为 null 时结束
- 当 root == p || root == q 返回 root
在递归的过程中会分别拿到左、右子树的公共节点 left、right，此时需要判断节点的合法性
- left、right的结果同时为 null，则为 null
- left、right 同时不为 null，说明 p、q 分列在 root 的异侧，所以是 root
- left 为 null，right 不为 null，p、q 都不在 root 的左子树中，返回 right
- left 不为 null， right 为 null，p、q 都不在 root 的右子树中，返回 left

[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/tree/BinTreeTraversal.java)

[1022. 从根到叶的二进制数之和](https://leetcode-cn.com/problems/sum-of-root-to-leaf-binary-numbers/)

一开始思考这个题目，想着用容器在递归（前序遍历）过程中将每个节点存起来，递归结束后，将容器中的值相加得出结果。但遇到的问题是容器的选择上，因为每个节点都只是一个值，然后还需要对某一个位置上重复拼接数据，这不太像简单题目的难度，哈哈....
既然树上的每个节点都是 0、1 组成的一串二进制数据，那每递进树的一个层级，该条链路上的值都会长大 2 倍（因为是二进制，左移一位），每次递归之前执行一次左移运算，得出当前链路的值，再将此值传递到下一次递归中
递归结束的条件: 节点为 null
计算出结果的条件: 递归的节点为叶子节点（root.left == null && root.right == null）
另外还有一个小细节，就是需要判断当前递归的节点值，如果是 0 则取左移动计算结果值进行传递，如果是 1 则将左移计算结果值 + 1 后再进行传递

[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/tree/BinTreeTraversal.java)

#### 评论 · 2021.05.08

<a id="issue-1-comment-15-2021-05-08"></a>

[965. 单值二叉树](https://leetcode-cn.com/problems/univalued-binary-tree/)
根据单值二叉树的定义，只要有一个节点值跟其他节点值不一样，就不算是单值二叉树，那在前序遍历的过程中，传入根节点的值，如果发现有节点值不一样的就不是单值二叉树

[257. 二叉树的所有路径](https://leetcode-cn.com/problems/binary-tree-paths/)
之前做题有遇到类似的场景，拼接从根节点到叶子节点的路径，这题的实现就是传入每次拼接的结果进行转换，非常巧妙

[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/tree/BinTreeTraversal.java)

#### 评论 · 2021.05.10

<a id="issue-1-comment-16-2021-05-10"></a>

[面试题 17.12. BiNode](https://leetcode-cn.com/problems/binode-lcci/)
与之前有一道通过中序遍历构造只有右子树的题目类型，然后就按照思路先进行中序遍历，然后根据中序遍历结果生成结果树，可以通过测试用例但是时间复杂度比较高（进行了递归后还有一次遍历）
看了题解也是在中序遍历的过程中进行结果树的构建，声明一个头部节点（head）用于拼接结果树和一个记录上个遍历节点（pre）用于替换，pre == null 说明是第一个节点，此时给 pre 赋值然后将它拼到 head 的右子树中，pre != null，就执行替换操作 pre.right = root; pre = root; 直到中序遍历结束

[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/tree/BinTreeCreation.java)

#### 评论 · 2021.05.13

<a id="issue-1-comment-17-2021-05-13"></a>

[530. 二叉搜索树的最小绝对差](https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/solution/530-er-cha-sou-suo-shu-de-zui-xiao-jue-d-76ch/)
记录前一个节点，中序遍历过程中如果前节点为空则将当前节点赋值，如果前节点不为空则比较两个节点值差的绝对值然后与最小值进行比较，最终得出结果

[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/tree/BinTreeTraversal.java)

[563. 二叉树的坡度](https://leetcode-cn.com/problems/binary-tree-tilt/submissions/)
根据坡度的定义，在每次递归的过程中累加左右子树的节点差值的绝对值，递归返回值为左节点值 + 右节点值 + 根节点值

[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/tree/BinTreeTraversal.java)

#### 评论 · 2021.05.16

<a id="issue-1-comment-18-2021-05-16"></a>

[剑指 Offer 28. 对称的二叉树](https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/)
根据题意，以根节点为中线，左右两边的树节点个数对应，已经值对应，那每次递归都传入节点都左、右子节点，然后进行判断，如果左右节点同时为空表示符合条件，如果有一个不为空或者值不想等则表示不符合条件。递归继续条件为将左节点的左子节点与右节点的右子节点比较，右节点的左子节点与左节点的右子节点比较，同时符合则表示符合对称的二叉树条件
[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/tree/BinTreeTraversal.java)

#### 评论 · 2021.05.24

<a id="issue-1-comment-19-2021-05-24"></a>

[543. 二叉树的直径](https://leetcode-cn.com/problems/diameter-of-binary-tree/)
声明结果变量，递归获取二叉树的高度，每次获取的过程中，记录左、右子树的高度 + 1 的值作为结果值（以最大为准），递归结束，得出结果

[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/template/leetcode/editor/cn/DiameterOfBinaryTree.java)

#### 评论 · 2021.08.01

<a id="issue-1-comment-20-2021-08-01"></a>

[面试题 04.04. 检查平衡性](https://leetcode-cn.com/problems/check-balance-lcci/)
结合求二叉树高度的方法，分别获取左子树和右子树的深度，然后对比这两个值的差值，如果小于 2 表示平衡，返回当前树的高度，否则表示不平衡，返回 -1

[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/template/leetcode/editor/cn/CheckBalanceLcci.java)

[404. 左叶子之和](https://leetcode-cn.com/problems/sum-of-left-leaves/)
常规递归遍历一遍二叉树，在递归方法中加入是否为左子树递归的标识，并记录左叶子的和

[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/template/leetcode/editor/cn/SumOfLeftLeaves.java)

---

## [#2 每日一题](https://github.com/ZakAnun/discussing-algorithm/issues/2)

<a id="issue-2-overview"></a>

[在 GitHub 查看原 Issue →](https://github.com/ZakAnun/discussing-algorithm/issues/2)

#### 正文

<a id="issue-2-intro"></a>

**记录一下每日一题（为了拿到力扣全家桶周边(^^)）**

#### 评论 · 2021.04.10

<a id="issue-2-comment-1-2021-04-10"></a>

[263. 丑数](https://leetcode-cn.com/problems/ugly-number/)
题目文字很简陋，和/或读半天没读明白，大概是给出了丑数的定义，然后让我们判断入参是否为丑数

首先: 判断边界条件，<= 0 的数肯定不为丑数
然后: 根据丑数的定义，推导出丑数 n = 2^a * 3^b * 5^c（这个推导从题解中得出，记一下...），有了这些基础，那我们的代码就好写了，只需要将入参的值依次除每个乘数直到将不再可以整除 2、3、5，最后得到的结果如果是 1，就符合丑数的定义

[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/daily/Day20210410.java)

这道题的关键在于需要得出丑数所对应的表达式，还有就是将入参 n 都不能整除三个定义的值，外循环用于判断能够满足包含样本值，内循环用于判断是否可以整除每一个值，最后运算的结果再与 1 作比较得出结果

#### 评论 · 2021.04.11

<a id="issue-2-comment-2-2021-04-11"></a>

[264. 丑数 II](https://leetcode-cn.com/problems/ugly-number-ii/)
题意是让我们找到从 1 开始，第 n 个丑数

一开始我想的是从 1 到 n 遍历，然后判断每个树是否为丑数，如果是则将它加入到结果集中，然后到 n 时，判断如果集合的大小已满足 n 个，则从集合中取值，否则就接着从 n 开始进行遍历 n - 结果集.size() 个数字，进入递归，虽然能通过部分用例，但明显不能涵盖全部结果，后来尝试分析了一下原因，就是结果集的大小是否已满足 n 个，这个条件范围不能准确获取到结果（因为如果递归的过程中，结果集的大小大于 n + 1，就不能简单地拿结果集中最后一个元素作为结果返回）

既然经过自己的思考后得出的结果并不正确，根本原因还是缺乏解决此类问题的正确思路，那直接看题解（……^ ^）

题解中，我选了动态规划进行理解，因为题目中是让我们找到第 n 个丑数（穷举，最值），跟 labuladong 动态规划解法的总结对应。先理解了一下，动态规划的解题步骤
1、确定最简单情况（base case）
2、根据每个简单问题的状态方程，推导出最终的状态方程
3、根据状态方程，将结果放到结果集 dp 中
4、根据题目要求，返回 dp 中的结果

d[1] = 1 // base case
本题关键是推导出 dp[i] = min(min(2* dp[a], 3 * dp[b]), 5*dp[c]) // a、b、c 分别指向可以以 2、3、5 为丑数的值
再判断将得出这个值的指针往后移一位
等到从 2 - n 遍历完后，dp[n] 就是结果

[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/daily/Day20210411.java)

接触到动态规划的题目，能明显体会到状态方程的推导比较困难... 不过基本流程都是一致的

#### 评论 · 2021.04.12

<a id="issue-2-comment-3-2021-04-12"></a>

[179. 最大数](https://leetcode-cn.com/problems/largest-number/)
题意是让我们将给定的数组中的数字进行排列，形成一个最大的数

先思考，要想得到最大的数，就比较全部数字中 % 10 后的最大值，放在前面，但是有些整除 10 的数又不好处理，想不出能覆盖的函数...

题解中的推导和证明，我感觉还是将这个题的解法记住会比较好一些... 但本题所有到的知识点可以延伸一下，在 Java 中涉及到数组比较的操作，可以使用 Arrays.sort(arr, Comparator)，Comparator 是一个比较器接口，可以实现比较的方法协助排序
另外（稍微看了一下源码）
1、Arrays.sort 的排序实现也是很有趣，它会在数组个数小于 7 的情况下使用冒泡排序方式，大于 7 才会使用快排，这样的设计可以降低最坏情况发生的概率
2、它比较之前，是通过拷贝的方式再生成一个相同的数组进行后续操作的，所以我们只传一个数组就可以比较（为我以前手写排序解了惑..）

[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/daily/Day20210412.java)

#### 评论 · 2021.04.13

<a id="issue-2-comment-4-2021-04-13"></a>

[783. 二叉搜索树节点最小距离](https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/)
二叉搜索树，返回树中任意两个不同节点值之间的最小差值

一拿到二叉搜索树，需要先反应它中序遍历序列的特点是一个升序序列，想要知道节点之间最小差值，比较对象是当前节点和它下一个将要遍历的节点，那么此时我们可以考虑转变一下，因为中序遍历先拿到的是左叶子节点，然后拿到该节点的根节点，那就可以用一个变量存前一个遍历的节点值与当前节点值进行比较（感觉总结得有些拗口，但是在代码中比较直观），另外因为需要的是最小差值，也定义一个结果变量，初始化为 Integer.MAX_VALUE，作为比较，整体思路还是比较清晰

[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/daily/Day20210413.java)

#### 评论 · 2021.04.14

<a id="issue-2-comment-5-2021-04-14"></a>

[208. 实现 Trie (前缀树)](https://leetcode-cn.com/problems/implement-trie-prefix-tree/)
构造类型题目，具体要求去题目里看吧

一开始看到这个题，还以为是要构造一个树，但是题意是想要查找字符串，然后我直接选用了 ArrayList 实现，虽然时间/空间复杂度打不过，但是可以通过测试
稍微看了一下官方的题解，好像每次 insert 后，之前的值都没有了，没有很深入研究（还是以能做出来为目标..）

[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/daily/Day20210414.java)

#### 评论 · 2021.04.15

<a id="issue-2-comment-6-2021-04-15"></a>

[213. 打家劫舍 II](https://leetcode-cn.com/problems/house-robber-ii/submissions/)

[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/daily/Day20210415.java)

#### 评论 · 2021.04.20

<a id="issue-2-comment-7-2021-04-20"></a>

[28. 实现 strStr()](https://leetcode-cn.com/problems/implement-strstr/)
题意很明确，在 java 中可以直接使用 String.indexOf() 来解决这道题，然后想了一下为什么这个方法的时间是 100%，稍微看了下 indexOf 的代码，里面的实现是将调用的字符串和比较的字符串转换成字符数组进行比较，所以也符合题目的期望

[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/daily/Day20210420.java)

#### 评论 · 2021.04.30

<a id="issue-2-comment-8-2021-04-30"></a>

[137. 只出现一次的数字 II](https://leetcode-cn.com/problems/single-number-ii/)
使用 hasdMap 记录遍历的数字和出现的次数，比较容易实现

[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/daily/Day20210430.java)

#### 评论 · 2021.05.06

<a id="issue-2-comment-9-2021-05-06"></a>

[1720. 解码异或后的数组](https://leetcode-cn.com/problems/decode-xored-array/)
简单类型的题目，关键在于找到 arr[i + 1] = arr[i] ^ encoded[i]; 这个关系，然后一次遍历得出结果

[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/daily/Day20210506.java)

#### 评论 · 2021.05.07

<a id="issue-2-comment-10-2021-05-07"></a>

[1486. 数组异或操作](https://leetcode-cn.com/problems/xor-operation-in-an-array/)
题目提供了计算公式，开始使用暴力解法，先将数组构建出来，然后再对数据进行遍历进行逐位异或的计算操作，但是在写第二个循环的时候发现既然只需要一个异或后的结果值，可以直接在第一次遍历中执行，先将 start 值记录，然后从数组的第二位开始遍历，逐个进行异或运算操作，得出结果值并返回

[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/daily/Day20210507.java)

#### 评论 · 2021.05.08

<a id="issue-2-comment-11-2021-05-08"></a>

[1723. 完成所有工作的最短时间](https://leetcode-cn.com/problems/find-minimum-time-to-finish-all-jobs/)
之前富途面试的时候被问到过这个题，先白嫖积分....

[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/daily/Day20210508.java)

#### 评论 · 2021.05.09

<a id="issue-2-comment-12-2021-05-09"></a>

[1482. 制作 m 束花所需的最少天数](https://leetcode-cn.com/problems/minimum-number-of-days-to-make-m-bouquets/solution/zhi-zuo-m-shu-hua-suo-xu-de-zui-shao-tia-mxci/)
开始的解题思路是对原数组的每个 item 进行递减，直到为 0，在过程中找到符合 m 的循环次数，然后将结果返回，但是只通过了示例 1 和 2，思考出现问题的原因是，在内层循环每次寻找相邻的 k 的值的逻辑不对（因为从 i+k 开始了），想半天也没想出来...

题解中将题目的核心指出，从花开时间的中位数开始计算是否可以找到符合要求的天数（其实还是不太懂）
但是了解到，如果有这种在一个数组中拿连续的位置进行判断就要加个变量来标记循环的次数以及还原条件

[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/daily/Day20210509.java)

#### 评论 · 2021.05.10

<a id="issue-2-comment-13-2021-05-10"></a>

[872. 叶子相似的树](https://leetcode-cn.com/problems/leaf-similar-trees/)
叶子相似的定义是两个树的叶子按从左到右的顺序排列后一致，说明两个树为叶子相似的二叉树。
那采用深度优先的方式拿到每棵树的叶子结点集合（前序遍历），再将两个叶子序列进行比较即可得到结果

从官方题解中可以看到，他在判断两个集合的元素是否一致的时候并没有重新写一个循环，而是直接调用了 List 的 equals 方法，然后想了一下应该是重写了这个方法，所以就简单追踪了一下....
ArrayList 是继承了 AbstractList，而 AbstractList 实现了 List，这是他们的直观关系，AbstractList 中重写了 List 的 equals 方法，可以看到里面的逻辑是
- 先判断两个集合的引用是否一致，是则认为是同一个集合，否则进入下一步
- 判断入参集合是否为 List 的实现，是则进入下一步，否则返回 false
- 拿到两个集合的 iterator，然后对集合中的元素逐个进行比较（集合中的 item 也是调用了 Object 的 equals 来判断是否一致），一旦有不一致的 item 返回 false，如果全部一致则返回 true

两个集合的比较逻辑还是比较巧妙，所以就把代码贴一下（其他的数据结果的 equals 方法应该也有对应的重写）
```
// this 是调用方集合，var1 是被比较的集合
ListIterator var2 = this.listIterator();
ListIterator var3 = ((List)var1).listIterator();

while(true) {
    if (var2.hasNext() && var3.hasNext()) {
        Object var4 = var2.next();
        Object var5 = var3.next();
        if (var4 == null) {
            if (var5 == null) {
                continue;
            }
        } else if (var4.equals(var5)) {
            continue;
        }

        return false;
    }

    return !var2.hasNext() && !var3.hasNext();
}
```

[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/daily/Day20210510.java)

#### 评论 · 2021.05.11

<a id="issue-2-comment-14-2021-05-11"></a>

[1734. 解码异或后的排列](https://leetcode-cn.com/problems/decode-xored-permutation/)
这个题目之前做过简单版的（1720. 解码异或后的数组），所以知道要找到结果数组的第一个元素，但是推理能力不够，要是下回遇到尽量想起来吧...
- 原始数组全部下标从 1 开始到 n 的逐位异或得出的结果记为 total
- 入参数组（解码数组），奇数位的逐位异或得出的结果记为 odd
- 原属数组的第一个元素 result[0] = total ^ odd
- 得到第一个元素的值后，根据公式 result[i + 1] = result[i] ^ encoded[i]; 逐位填充结果数组

[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/daily/Day20210511.java)

#### 评论 · 2021.05.13

<a id="issue-2-comment-15-2021-05-13"></a>

（串了一天....）
[1310. 子数组异或查询](https://leetcode-cn.com/problems/xor-queries-of-a-subarray/)
二维数组表示异或的范围，那么只需要遍历取，然后每次进行异或计算即可

[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/daily/Day20210513.java)

#### 评论 · 2021.05.14

<a id="issue-2-comment-16-2021-05-14"></a>

[12. 整数转罗马数字](https://leetcode-cn.com/problems/integer-to-roman/)
需要罗列出全部的条件，然后对传入数字进行按罗马数字对应的整数做减法运算，每减一次就拼接上对应的罗马数字直到结束

[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/daily/Day20210514.java)

#### 评论 · 2021.05.15

<a id="issue-2-comment-17-2021-05-15"></a>

[13. 罗马数字转整数](https://leetcode-cn.com/problems/roman-to-integer/)
这题主要还是得发现与 4、9 的罗马数 IV、IX 与其他按从小到大的罗马数的区别，这种情况需要判断的点是后一个是否比前一个大，如果是就需要减去前面的数，其他情况就正常加就行

[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/daily/Day20210515.java)

#### 评论 · 2021.05.16

<a id="issue-2-comment-17-2021-05-16"></a>

[421. 数组中两个数的最大异或值](https://leetcode-cn.com/problems/maximum-xor-of-two-numbers-in-an-array/solution/shu-zu-zhong-liang-ge-shu-de-zui-da-yi-h-n9m9/)
这题暴力方法是以 O(n^2) 的时间复杂度完成判断，[题解](https://leetcode-cn.com/problems/maximum-xor-of-two-numbers-in-an-array/solution/shu-zu-zhong-liang-ge-shu-de-zui-da-yi-h-n9m9/)没看到明白...（TODO）

[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/daily/Day20210516.java)

#### 评论 · 2021.05.18

<a id="issue-2-comment-18-2021-05-18"></a>

[1442. 形成两个异或相等数组的三元组数目](https://leetcode-cn.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor)

[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/daily/Day20210518.java)

#### 评论 · 2021.05.19

<a id="issue-2-comment-19-2021-05-19"></a>

[1738. 找出第 K 大的异或坐标值](https://leetcode-cn.com/problems/find-kth-largest-xor-coordinate-value/)

[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/daily/Day20210519.java)

#### 评论 · 2021.05.20

<a id="issue-2-comment-20-2021-05-20"></a>

[692. 前K个高频单词](https://leetcode-cn.com/problems/top-k-frequent-words/)
- 首先将每个单词以及其出现的次数存到哈希表里（可以使用 getOrDefault(key, defaultVal) 减少是否包含 key 的判断）
- 将出现的单词存到一个集合里
- 给这个集合添加一个比较器，符合条件当单词出现的次数相等则返回两个字符串的比较（str1.compareTo(str2)）否则按照出现次数大的单词降序（map.get(str2) - map.get(str1)）（str1、str2 分别为 compareTo 的入参）
- 返回集合从 0 到 k 到子集

[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/daily/Day20210520.java)

#### 评论 · 2021.06.09

<a id="issue-2-comment-21-2021-06-09"></a>

之前一段时间忙得一批，闲下来就用了一下朋友介绍给我的[刷题插件](https://github.com/shuzijun/leetcode-editor)，方便得飞起，代码模版、题目信息都可以在 ide（我用的 Android Studio）里配置，很方便，哈哈.......

还用[两数之和](https://leetcode-cn.com/problems/two-sum/)测试了一下（[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/template/leetcode/editor/cn/TwoSum.java)），就是题目是英文的看得有点费劲 =-=

#### 评论 · 2021.07.02

<a id="issue-2-comment-22-2021-07-02"></a>

[1833. 雪糕的最大数量](https://leetcode-cn.com/problems/maximum-ice-cream-bars/)

先对 costs 排序，因为要想在给定的价钱里买到最多的雪糕，就得选便宜的，然后再遍历，递减 coins，每减一次结果数就加一，直到归零，最后得出结论

[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/template/leetcode/editor/cn/MaximumIceCreamBars.java)

#### 评论 · 2021.07.03

<a id="issue-2-comment-23-2021-07-03"></a>

[451. 根据字符出现频率排序](https://leetcode-cn.com/problems/sort-characters-by-frequency/)

利用 HashMap 协助将字符整理起来，key 为字符，value 为出现次数，然后将 key 整理为集合用作排序，通过 List#sort() 传入比较器，(a, b) -> map.get(b) - map.get(a) 达到倒序效果，然后再遍历 list，通过每次拿到的字符，获取出现次数，再拼接对应次数到结果上，得出结果

[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/template/leetcode/editor/cn/SortCharactersByFrequency.java)

#### 评论 · 2021.07.04

<a id="issue-2-comment-24-2021-07-04"></a>

[645. 错误的集合](https://leetcode-cn.com/problems/set-mismatch/)

先对入参进行排序，完了需要记录一下上一个的值，因为要从 1 开始对比，所以 last 值初始化为 0，然后开始比较。
1、如果当前的值和上一个值相等，就认为出错了，记录这个值到结果数组的第一位
2、正常情况下当前值减去上一个值，大于 1 的话，就记录一下当前值的位置（上一个值 + 1）作为结果数组的第二位，但是最后一位数没有后面的数字协助判断，所以用 nums[length - 1] != length 成立则认为该位置错了要写入结果数组

[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/template/leetcode/editor/cn/SetMismatch.java)

#### 评论 · 2021.07.05

<a id="issue-2-comment-25-2021-07-05"></a>

[101. 对称二叉树](https://leetcode-cn.com/problems/symmetric-tree/)

判断对称的条件
- 根节点的左子节点与根节点的右子节点的值相等
- 二级节点后，左节点的左子节点需要与同层的右节点的右子节点值相同（右节点需要与左节点值相同），为空的话需要同时为空

深度优先（递归处理）
- 入参为左、右节点，首次两个均传根节点
- 两个节点同时为空，return true
- 两个节点一个为空，另一个不为空，return false
- 判断两个节点的值是否相等 && leftTree.left, rightTree.right && rightTree.left, leftTree.right，后面两个操作是进入递归

递归最终得出结果

广度优先（利用队列循环处理）
- 创建一个队列 queue（使用 LinkedList）
- 将根节点入队两次
- 开始循环，终止条件为 queue.isEmpty()
- 从队列中出队两个节点（左、右节点）进行比较
- 两个节点同时为空，continue
- 两个节点一个为空，另一个不为空，或者两个节点值不一致，return false
- 分别入队 leftTree.left、rightTree.right、rightTree.left、leftTree.right

循环结束得出结果

[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/template/leetcode/editor/cn/SymmetricTree.java)

#### 评论 · 2021.07.06

<a id="issue-2-comment-26-2021-07-06"></a>

[146. LRU 缓存机制](https://leetcode-cn.com/problems/lru-cache/)

Java 中实现这样的 API 为 LinkedList

手动简单书写代码的思路如下：
实现 LRU 缓存的核心是（双向链表 + 哈希表），双向链表用于更新最新使用的节点位置，哈希表用于快速获取数据
双向链表可以避免链表尾部遍历（get、put 操作为 O(1)）
哈希表在没有哈希冲突的情况下（get、put 操作为 O(1)）

注意点
- 需要判断当前的个数，达到最大值需要移除掉最后一个节点，为了避免链表尾部遍历，引入表头节点和表尾节点
- put 操作的时候记得要更新节点的值和缓存的节点

[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/template/leetcode/editor/cn/LruCache.java)

#### 评论 · 2021.07.07

<a id="issue-2-comment-27-2021-07-07"></a>

[1711. 大餐计数](https://leetcode-cn.com/problems/count-good-meals/)

按照题意，我本来想着是嵌套循环，然后按位加，再求符合 2 的幂的结果的次数，最后得出结果，但首先没有考虑到时间复杂度，其次没有想到用哈希表来暂存结果
```
/**
 * 计算一个数字为 2 的多少次幂可以使用递归实现
 */
public int log2(int val) {
  if (val == 1) {
    return 0;
  } else {
    return 1 + log2(val>>1);
  }
}
```

最后参考题解，内层每次都遍历 2 的幂的数组，其 item - 入参数组 item，如果在哈希表中有存值，就与结果相加 % 题目要求的值
每次内层遍历完后，再执行 put 操作

[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/template/leetcode/editor/cn/CountGoodMeals.java)

#### 评论 · 2021.07.08

<a id="issue-2-comment-28-2021-07-08"></a>

[930. 和相同的二元子数组](https://leetcode-cn.com/problems/binary-subarrays-with-sum/)

首次接触滑动窗口的题目，看题解看得有点蒙，代码好理解一些，判断如果比指定大的话，右边界就停止滑动，左边界开始滑动
**（不熟悉，要多看看）**

[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/template/leetcode/editor/cn/BinarySubarraysWithSum.java)

#### 评论 · 2021.07.09

<a id="issue-2-comment-29-2021-07-09"></a>

[面试题 17.10. 主要元素](https://leetcode-cn.com/problems/find-majority-element-lcci/)

这道题我的思路是先将数组排序，然后记录每次变化经历了多少个元素，并记录出现次数大于数组一般长度时的数组元素，在 leet-code 上面可以提交成功，所以我就在代码里记下来了
再看题解，发现这一个算法可以符合时间复杂度 O(n)，空间复杂度 O(1)，具体去看题解吧，里面有设计到主要元素的这个概念，记录候选主要元素和候选主要元素出现次数，这个次数 ++、-- 是根据是否跟这个备选元素一致相关，一致就 ++，否则 --，第一次遍历后会得出一个主要元素，然后判断这个主要元素的出现次数，是否大于原数组的长度的一半，是则返回这个元素，否则返回 -1

[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/template/leetcode/editor/cn/FindMajorityElementLcci.java)

#### 评论 · 2021.07.11

<a id="issue-2-comment-30-2021-07-11"></a>

[981. 基于时间的键值存储](https://leetcode-cn.com/problems/time-based-key-value-store/)

`// 待补充`

[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/template/leetcode/editor/cn/TimeBasedKeyValueStore.java)

#### 评论 · 2021.07.16

<a id="issue-2-comment-31-2021-07-16"></a>

[剑指 Offer 53 - I. 在排序数组中查找数字 I](https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/)
暴力解法是一次遍历数组，然后判断每个元素与 target 值是否一致，一致则记录次数，遍历结束得出结果，时间复杂度 O(n)

但是题中说明了传入的数组是已经排好序的升序序列，所以可以想到使用二分查找来解决这个问题，那关键是通过二分查找需要朝着什么呢？题中需要的是与 target 一样的元素出现的次数，可以转换为查找该元素首次出现的下标（leftIndex），和该元素最后一次的下标（rightIndex），然后通过 rightIndex - leftIndex + 1，就能得到结果，如果通过查找的下标不满足与 target 值一致或者超出数组范围，则返回 0（还需要注意避免二分查找 mid 值计算超出范围的处理方式 left + （right - left) / 2）

[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/template/leetcode/editor/cn/ZaiPaiXuShuZuZhongChaZhaoShuZiLcof.java)

#### 评论 · 2021.07.17

<a id="issue-2-comment-32-2021-07-17"></a>

[剑指 Offer 42. 连续子数组的最大和](https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/)
经典求最值的问题，动态解决，官方题解里的视频说得很清晰，dp[i] 表示前 i 个元素的和，那么 dp[i] 就就可以表示为 d[i - 1] + nums[i]，前 i - 1 个元素加上第 i 个元素，由此得到状态方程 dp[i] = dp[i - 1] + nums[i]，个人觉得这个题目是经典理解动态规划的题目了，哈哈

[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/template/leetcode/editor/cn/LianXuZiShuZuDeZuiDaHeLcof.java)

#### 评论 · 2021.07.19

<a id="issue-2-comment-33-2021-07-19"></a>

[面试题 10.02. 变位词组](https://leetcode-cn.com/problems/group-anagrams-lcci/)
这个题的关键在于区分出变位词，需要将变位词都放在一起，一种思路就是将每个字符串都转换成字符数组，然后对这个字符数组进行排序，作为哈希表的 key，哈希表的值就为原字符串组合成的集合。遍历后，即可得出结果

[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/template/leetcode/editor/cn/GroupAnagramsLcci.java)

---

[1838. 最高频元素的频数](https://leetcode-cn.com/problems/frequency-of-the-most-frequent-element/)
这个题，暴力算法先将数组排序，然后从最大值开始，k 与它相减，然后得出 > 0 的次数，再记录最大值，但是会超时
题解中提到的排序 + 滑动窗口，右移一位值增大了 (num[r] - num[r - 1]) * (r - l)，增量值跟 k 进行比较，计算次数，然后记录并比较出最大值，最后得出结果

[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/template/leetcode/editor/cn/FrequencyOfTheMostFrequentElement.java)

#### 评论 · 2021.07.20

<a id="issue-2-comment-34-2021-07-20"></a>

[1877. 数组中最大数对和的最小值](https://leetcode-cn.com/problems/minimize-maximum-pair-sum-in-array/)
这个是第一次可以跟题解的思路一致的题目....
开始看这个题目的时候，有点不能理解数对和，多看几次发现，如果要满足题目要求的数对的话，就可以通过将数组排序，然后取前后的数字相加然后取出最大值...实现出来就通过了（再看题解是差不多的代码 :(）

[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/template/leetcode/editor/cn/MinimizeMaximumPairSumInArray.java)

#### 评论 · 2021.07.21

<a id="issue-2-comment-35-2021-07-21"></a>

[剑指 Offer 52. 两个链表的第一个公共节点](https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/)
比较难想，这个题我就想出来处理头节点有一个为 null，就不会有相交的情况，原来的思路是在记录两个链表的头节点，然后先遍历链表 a，判断链表上的节点是否会跟链表 b 上的节点相一致，有则返回结果，没有就遍历链表 b，按照遍历链表 a 的方式走一遍，看是否有满足的节点，这个思路的问题是，相交的点前面的节点数是一样的，才成立
看了题解，处理这个问题，主要是希望判断两个链表中的节点是否一致，那就判断这两个链表的节点，如果一个为空了就从另一个开始（题解有详细证明...）

[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/template/leetcode/editor/cn/LiangGeLianBiaoDeDiYiGeGongGongJieDianLcof.java)

#### 评论 · 2021.07.22

<a id="issue-2-comment-36-2021-07-22"></a>

[138. 复制带随机指针的链表](https://leetcode-cn.com/problems/copy-list-with-random-pointer/)
`//待补充`

[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/template/leetcode/editor/cn/CopyListWithRandomPointer.java)

#### 评论 · 2021.07.23

<a id="issue-2-comment-37-2021-07-23"></a>

[1893. 检查是否区域内所有整数都被覆盖](https://leetcode-cn.com/problems/check-if-all-the-integers-in-a-range-are-covered/)

[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/template/leetcode/editor/cn/CheckIfAllTheIntegersInARangeAreCovered.java)

#### 评论 · 2021.07.24

<a id="issue-2-comment-38-2021-07-24"></a>

[1736. 替换隐藏数字得到的最晚时间](https://leetcode-cn.com/problems/latest-time-by-replacing-hidden-digits/)
简单替换字符

[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/template/leetcode/editor/cn/LatestTimeByReplacingHiddenDigits.java)

#### 评论 · 2021.07.26

<a id="issue-2-comment-39-2021-07-26"></a>

[9. 回文数](https://leetcode-cn.com/problems/palindrome-number/)
转成字符串可以写出来，通过计算还得看题解...

[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/template/leetcode/editor/cn/PalindromeNumber.java)

#### 评论 · 2021.07.28

<a id="issue-2-comment-40-2021-07-28"></a>

[863. 二叉树中所有距离为 K 的结点](https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree/)
一时间并没有思路，感觉算是个二叉树比较综合的题型，题解使用深度优先 + 哈希表
- 哈希表用于存储节点的父节点
- 深度优先，第一是建立节点与其父节点的关系，第二是从目标节点开始进行遍历，查找符合路径长度为 k 的节点并将值添加到结果列表中

[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/template/leetcode/editor/cn/AllNodesDistanceKInBinaryTree.java)

#### 评论 · 2021.08.09

<a id="issue-2-comment-41-2021-08-09"></a>

[112. 路径总和](https://leetcode-cn.com/problems/path-sum/)

[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/template/leetcode/editor/cn/PathSum.java)

#### 评论 · 2021.08.10

<a id="issue-2-comment-42-2021-08-10"></a>

[413. 等差数列划分](https://leetcode-cn.com/problems/arithmetic-slices/)

[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/template/leetcode/editor/cn/ArithmeticSlices.java)

#### 评论 · 2021.08.11

<a id="issue-2-comment-43-2021-08-11"></a>

[446. 等差数列划分 II - 子序列](https://leetcode-cn.com/problems/arithmetic-slices-ii-subsequence/)

[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/template/leetcode/editor/cn/ArithmeticSlicesIiSubsequence.java)

#### 评论 · 2021.08.12

<a id="issue-2-comment-44-2021-08-12"></a>

[516. 最长回文子序列](https://leetcode-cn.com/problems/longest-palindromic-subsequence/)

[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/template/leetcode/editor/cn/LongestPalindromicSubsequence.java)

#### 评论 · 2021.08.13

<a id="issue-2-comment-45-2021-08-13"></a>

[233. 数字 1 的个数](https://leetcode-cn.com/problems/number-of-digit-one/)

[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/template/leetcode/editor/cn/NumberOfDigitOne.java)

#### 评论 · 2021.08.16

<a id="issue-2-comment-46-2021-08-16"></a>

[166. 分数到小数](https://leetcode-cn.com/problems/fraction-to-recurring-decimal/)

[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/template/leetcode/editor/cn/FractionToRecurringDecimal.java)

#### 评论 · 2021.08.17

<a id="issue-2-comment-47-2021-08-17"></a>

[551. 学生出勤记录 I](https://leetcode-cn.com/problems/student-attendance-record-i/)

[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/template/leetcode/editor/cn/StudentAttendanceRecordI.java)

#### 评论 · 2021.08.19

<a id="issue-2-comment-48-2021-08-19"></a>

[345. 反转字符串中的元音字母](https://leetcode-cn.com/problems/reverse-vowels-of-a-string/)
反转字符串中的元音字母，分为几个步骤执行
1、需要判断字母是否为元音字母，那判断元音字母可以使用 HashSet 存储然后判断，但因为考虑到元音字母有限（包含大小写），所以可以通过字符串的 indexOf 方法判断字符是否在元音字母中（"aeiouAEIOU".indexOf(char) >= 0）
2、反转实际上是元素交换，所以需要首尾两个下标（left、right）分别开始，left 下标所指的字母为元音字母，则开始 end 下标的递减操作，直到 right 下标也是元音字母，然后将两个下标的字母进行交换
3、交换后，left 和 right 分别前进（+1、-1）

[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/template/leetcode/editor/cn/ReverseVowelsOfAString.java)

#### 评论 · 2021.08.20

<a id="issue-2-comment-49-2021-08-20"></a>

[450. 删除二叉搜索树中的节点](https://leetcode-cn.com/problems/delete-node-in-a-bst/)

这是昨天面试的算法题，很遗憾没有做出来，就跟前面好多题目一样，虽然有基本思路，但是因为没有将整个问题进行分解，所以当时我个人感觉是比较混乱，在这种情况下顺利地不能让面试官认可，哈哈

结合题解，我理解的题目有点偏差，我理解的删除节点入参是个节点，而不是节点值，然后当时想的是返回结果是一个 boolean 值，用来表示删除成功，接着思考如果要删除一个节点的话，需要将背删除节点缓存一份，但是如果将这个节点单独拿出来，那么会影响到二叉搜索树的性质（节点左子树要小于该节点，右子树要大于该节点）。当时我没想到只需要将值替换成用于维持这个性质的节点就行...所以卡得无从下手 =-=

整体思路
1、比较节点值与 key 的关系，大于则传入右子树递归，小于则传入左子树递归
2、找到节点值，如果是叶子结点的话，则直接将节点置为 null，如果节点的右子节点不为 null
思考一个问题，如果删除的节点同时拥有左子树和右子树，怎么选择子树呢？因为要保证二叉搜索树的性质，只要子树不为空，就可以找出该子树的最大节点值 / 最小节点值，替换到对应的节点上，所以第三步
3、判断子树是否为空，如果右子树不为空，那么取右子树的最小节点值用于替换，否则就取左子树，并获取左子树的最大值用于替换

[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/template/leetcode/editor/cn/DeleteNodeInABst.java)

#### 评论 · 2021.08.21

<a id="issue-2-comment-50-2021-08-21"></a>

[443. 压缩字符串](https://leetcode-cn.com/problems/string-compression/)
因为题目要求是需要常量级别的的空间算法，我用 StringBuilder 虽然可以压缩成功，就是嵌套循环，然后记录不一样的字符的下标，然后还需要处理不满足循环条件时的情况，显然这种处理方式并不算优而且 leetcode 上也不能通过用例

题解的思路很清晰，先用 read 指针遍历数组，一旦发现出现不一样的字符或者已经遍历完数组时就开始操作 write 指针，先将 write 指针所指向的下标上填写相同的字符，然后处理数字，数字的获取通过 % 10 再与 '0' 得到对应的字符值然后添加到数组中，因为这种取数字的方式时先拿到个位并以此类推到高位，因此需要对数字部分进行首尾交换的操作，最终将 write 的值返回即可
编码时还有个小技巧，就是 charArr[write++] = .. 这种写法，是会先读取 write 的值，然后在对应的字符数组下标处赋值后，write 再进行自加的操作

[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/template/leetcode/editor/cn/%5B443%5D%E5%8E%8B%E7%BC%A9%E5%AD%97%E7%AC%A6%E4%B8%B2.java)

#### 评论 · 2021.08.22

<a id="issue-2-comment-51-2021-08-22"></a>

老是点错关闭了 issue...

[剑指 Offer II 002. 二进制加法](https://leetcode-cn.com/problems/JFETK5/)
今天 leetcode 的每日一题，是我不太想做的类型，然后我选了二叉树，简单难度的一题，很奇怪，这道题不知道为什么会在，反正就先做做

思路比较清晰，就跟正常做加减法那样，末尾对齐然后相加，用 sum 表示按位相加的和，carry 表示按位相加的进位数，
需要注意的点
1、取到每一位上的字符后需要 - '0'，不然取到的值是对应的字符值
2、要先取 carry 的值，然后再取 sum 的值，顺序乱了结果就错了

[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/template/leetcode/editor/cn/JFETK5.java)

#### 评论 · 2021.08.23

<a id="issue-2-comment-52-2021-08-23"></a>

[1646. 获取生成数组中的最大值](https://leetcode-cn.com/problems/get-maximum-in-generated-array/)
一开始还想着去凑题目中给出的两个关系式，以完成数组元素的赋值，但下标的处理很繁琐（缺乏对题目理解并分析的经验）
其实题目中两个条件可以适当转换一下，可以得出奇偶关系，然后遍历一次进行赋值即可

[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/template/leetcode/editor/cn/GetMaximumInGeneratedArray.java)

#### 评论 · 2021.08.24

<a id="issue-2-comment-53-2021-08-24"></a>

[912. 排序数组](https://leetcode-cn.com/problems/sort-an-array/)
数组的排序，先了解的快排的实现，其实 Arrays.sort 这个方法里包含了冒泡、快排等实现，在工程使用上比较合理

快排的思路
1、随机选取一个下标用于分区的作用
2、交换随机下标与数组的最后一个元素
3、对选中的分块进行排序
4、递归处理基于随机选取下标的两个部分

[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/template/leetcode/editor/cn/SortAnArray.java)

#### 评论 · 2021.08.24

<a id="issue-2-comment-54-2021-08-24"></a>

[881. 救生艇](https://leetcode-cn.com/problems/boats-to-save-people/)

[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/template/leetcode/editor/cn/BoatsToSavePeople.java)

#### 评论 · 2021.08.29

<a id="issue-2-comment-55-2021-08-29"></a>

[1588. 所有奇数长度子数组的和](https://leetcode-cn.com/problems/sum-of-all-odd-length-subarrays/)

[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/template/leetcode/editor/cn/SumOfAllOddLengthSubarrays.java)

#### 评论 · 2021.08.30

<a id="issue-2-comment-56-2021-08-30"></a>

[528. 按权重随机选择](https://leetcode-cn.com/problems/random-pick-with-weight/)
随机选择题目，开始的时候把题目的意思理解错了，~~还以为是下标 i 出现的概率是 i / 整个数组的和，所以在思考上也出现了偏差，尝试着算出每个 item 出现的概率，存在数组中，然后在 pickIndex 的时候，根据生成的随机数查找最接近概率 item 的下标（自然是不对的....）~~
题意是每个 item 出现的概率，是该 item / sum(itemIndex)，也是需要将出现的概率形成数组，但结合查询，这里的转换是将每个 item 出现的概率转换成对应 item 出现在 [1, total] 数组内的权重，符合条件 pre[i] = pre[i - 1] + arr[i]，arr 为传入的数组，pre 为记录权重的数组，再计算 total 值（arr 数组的总和）用于生成随机数。
这里有个小知识点: `(Math.random() * total) // 生成 0 - total 的随机数`，`(Math.random() * total + 1) // 生成 1 - total 的随机数`
生成随机数后，就在 pre 数组中查找最接近这个随机数的下标（因为生成 pre 的过程已经决定了 pre 是个递增的序列，因此可以直接使用二分法进行查找），最终得出结果。


[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/template/leetcode/editor/cn/RandomPickWithWeight.java)

#### 评论 · 2021.08.31

<a id="issue-2-comment-57-2021-08-31"></a>

[1109. 航班预订统计](https://leetcode-cn.com/problems/corporate-flight-bookings/)
这道题目的暴力算法之前有做过，但是具体哪道题有点忘记了，暴力算法思路是遍历二元数组，然后根据每个二元数组的数据，给结果数组的 item 进行累加操作，在 leetcode 上面可以通过测试用例，但耗时 1500 ms 左右
题解中提及通过差分和前缀和处理，[题解](https://leetcode-cn.com/problems/corporate-flight-bookings/solution/hang-ban-yu-ding-tong-ji-by-leetcode-sol-5pv8/)，耗时 2ms，O(n ^ 2) 和 O(n) 的时间复杂度对比就很明显。
代码中，我记录了两种解法。

[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/template/leetcode/editor/cn/CorporateFlightBookings.java)

---

## [#3 2021.09](https://github.com/ZakAnun/discussing-algorithm/issues/3)

<a id="issue-3-overview"></a>

[在 GitHub 查看原 Issue →](https://github.com/ZakAnun/discussing-algorithm/issues/3)

#### 正文 · 2021.09.01

<a id="issue-3-2021-09-01"></a>

[165. 比较版本号](https://leetcode-cn.com/problems/compare-version-numbers/)
能够想出来的方法就是以 . 为分隔符对两个版本号字符串进行划分（注意在 Java 中调用 split 时，. 需要使用 \\. 进行转义）遍历拿到切割后的字符串数组，分别比较对应下标的数字的大小，直至结束。

题解中还提供了一种将空间复杂度将为常量的方式，就是巧妙的获取 . 之前的数进行比较，具体在代码中也有体现。

[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/template/leetcode/editor/cn/CompareVersionNumbers.java)

#### 评论 · 2021.09.03

<a id="issue-3-comment-1-2021-09-03"></a>

[面试题 17.14. 最小K个数](https://leetcode-cn.com/problems/smallest-k-lcci/)
本题只需先排序，然后再遍历 k 次即可找出 k 个数，关键在于排序的实现（可以看看快排和堆排），但我觉得这个题本身是考虑找出最小 k 个数的思路，所以可以直接用 Java API Arrays.sort 来帮助实现排序（冒泡 + 快排的实现），然后再补充找最小 k 个数的逻辑

[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/template/leetcode/editor/cn/LianBiaoZhongDaoShuDiKgeJieDianLcof.java)

#### 评论 · 2021.09.08

<a id="issue-3-comment-2-2021-09-08"></a>

[剑指 Offer II 052. 展平二叉搜索树](https://leetcode-cn.com/problems/NYBBNL/)
今天的题目难度是困难，就挑了一个简单的二叉树来练习一下，这个题是根据中序遍历的序列构建一个只有右子节点的树，比较简单（好像之前也做过）

[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/template/leetcode/editor/cn/NYBBNL.java)

#### 评论 · 2021.09.10

<a id="issue-3-comment-3-2021-09-10"></a>

[1894. 找到需要补充粉笔的学生编号](https://leetcode-cn.com/problems/find-the-student-that-will-replace-the-chalk/)
开始的思路有点乱，想着先遍历一边数组，k 减去数组的每个 item，但这样的话无法确定什么时候停止减法的操作，其实此时的 k 并不是最简化的可操作对象，经过一次遍历后可以得到每个学生消耗粉笔后的总数，只需要得到 k 与 total 的余数，就是最简的操作对象，再经过一次遍历即可确定哪位同学需要补充粉笔

[代码链接](https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/template/leetcode/editor/cn/FindTheStudentThatWillReplaceTheChalk.java)

---

## 相关链接

- [GitHub 仓库](https://github.com/ZakAnun/discussing-algorithm)
- [Issues 讨论区](https://github.com/ZakAnun/discussing-algorithm/issues)
- [LeetCode 中国站](https://leetcode-cn.com/)
- [labuladong 算法小抄](https://github.com/labuladong/fucking-algorithm)
