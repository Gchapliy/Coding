package leetcode;

import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s) {
        Stack<String> stack = new Stack<>();
        Map<String, String> map = Map.of(
                ")", "(",
                "]", "[",
                "}", "{"
        );
        for (String p : s.split("")) {
            if(p.equals("(") || p.equals("[") || p.equals("{")) {
                stack.push(p);
            } else if(stack.isEmpty() || !map.get(p).equals(stack.pop())) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("()"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("("));
        System.out.println(isValid("]"));
    }
}
