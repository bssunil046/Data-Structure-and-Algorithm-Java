package algorithms;

import java.util.*;

public class InvalidParenthesesCount {

    public static void main(String [] args) {
        System.out.println(getInvalidParenthesesCount("(())"));
        System.out.println(getInvalidParenthesesCount("(()("));
        System.out.println(getInvalidParenthesesCount("((()))"));
        System.out.println(getInvalidParenthesesCount("()()()"));
        System.out.println(getInvalidParenthesesCount("))(("));
    }

    private static int getInvalidParenthesesCount(String str) {
        if(str == null || str.isEmpty()) {
            return 0;
        }

        int count = 0;
        Stack <Character> stack = new Stack<>();
        for(char ch : str.toCharArray()) {
            if(ch == '(') {
                stack.push(ch);
            } else {
                if(!stack.isEmpty() && stack.pop() == '(') continue;
                count++;
            }
        }
        return count + stack.size();
    }
}
