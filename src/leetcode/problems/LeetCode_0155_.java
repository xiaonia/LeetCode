package leetcode.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/min-stack/
 *
 * 155. Min Stack
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 *
 *
 * Example:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 */

/**
 * @link https://leetcode.com/problems/min-stack/discuss/49014/Java-accepted-solution-using-one-stack
 */
public class LeetCode_0155_ {

    class MinStack {

        int mMin;
        int mSize;
        Stack<Integer> mStack;

        public MinStack() {
            mStack = new Stack<Integer>();
            mMin = 0;
            mSize = 0;
        }

        public void push(int x) {
            if (mSize == 0) {
                mMin = x;
            } else {
                if (x <= mMin) {
                    mStack.push(mMin);
                    mMin = x;
                }
            }

            mStack.push(x);
            mSize ++;
        }

        public void pop() {
            if (mSize <= 0) {
                return;
            }

            int x = mStack.pop();
            if (x == mMin) {
                if (mSize > 1) {
                    mMin = mStack.pop();
                }
            }
            mSize--;
        }

        public int top() {
            if (mSize <= 0) {
                return 0;
            }
            return mStack.peek();
        }

        public int getMin() {
            if (mSize == 0) {
                return 0;
            }
            return mMin;
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

}
