package com.zak.da.template.leetcode.editor.cn;

// 155. 最小栈
// LeetCode: https://leetcode-cn.com/problems/min-stack/
// Related Topics 面试刷题提纲 — 辅助栈设计

public class MinStack {

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.top());
        System.out.println(stack.getMin());
    }

//leetcode submit region begin(Prohibit modification and deletion)
    // TODO: 实现最小栈（数据栈 + 辅助最小栈）
    public MinStack() {
    }

    public void push(int val) {
    }

    public void pop() {
    }

    public int top() {
        return 0;
    }

    public int getMin() {
        return 0;
    }
//leetcode submit region end(Prohibit modification and deletion)

}
