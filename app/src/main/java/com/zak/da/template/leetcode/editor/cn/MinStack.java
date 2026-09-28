package com.zak.da.template.leetcode.editor.cn;

// 155. 最小栈
// LeetCode: https://leetcode-cn.com/problems/min-stack/
// Related Topics 面试刷题提纲 — 辅助栈设计

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        System.out.println(stack.getMin()); // -3
        stack.pop();
        System.out.println(stack.top());    // 0
        System.out.println(stack.getMin()); // -2
    }

//leetcode submit region begin(Prohibit modification and deletion)
    /** 数据栈 + 同步最小栈：每次 push 时压入「当前全局最小值」 */
    private final Deque<Integer> stack = new ArrayDeque<>();
    private final Deque<Integer> minStack = new ArrayDeque<>();

    public MinStack() {
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty()) {
            minStack.push(val);
        } else {
            minStack.push(Math.min(minStack.peek(), val));
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
//leetcode submit region end(Prohibit modification and deletion)

}
