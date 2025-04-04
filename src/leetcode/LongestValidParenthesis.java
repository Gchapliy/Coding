package leetcode;

import java.util.Stack;

public class LongestValidParenthesis {
    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()") + " -> 2");
        System.out.println(longestValidParentheses(")()())") + " -> 4");
        System.out.println(longestValidParentheses("()(())") + " -> 6");
        System.out.println(longestValidParentheses("((()))())") + " -> 8");
        System.out.println(longestValidParentheses("()(()") + " -> 2");
        System.out.println(longestValidParentheses(")()())()()(") + " -> 4");
        System.out.println(longestValidParentheses(""));
    }

    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max_len = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max_len = Math.max(max_len, i - stack.peek());
                }
            }
        }

        return max_len;
    }
}
