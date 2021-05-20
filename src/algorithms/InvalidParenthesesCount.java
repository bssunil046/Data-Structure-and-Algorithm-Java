package algorithms;

import java.util.*;

public class InvalidParenthesesCount {

    public static void main(String[] args) {
        HashMap<String, Integer> testCases = new HashMap<>();
        testCases.put("(())", 0);
        testCases.put("(()(", 2);
        testCases.put("((()))", 0);
        testCases.put("()()()", 0);
        testCases.put("))((", 4);

        int testCaseCount = 1;
        int testCasePassed = 1;

        for(Map.Entry<String, Integer> entry : testCases.entrySet()) {
            boolean result = getInvalidParenthesesCount(entry.getKey()) == entry.getValue();
            if(result) {
                testCasePassed++;
            }

            System.out.println(result
                    ? testCaseCount++ + " Test case passed!" : testCaseCount++ + " Test case failed - input: (())");
        }
        System.out.println();
        System.out.println(testCasePassed + "/" + testCaseCount + " test cases passed.");

    }

    private static int getInvalidParenthesesCount(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }

        int count = 0;
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else {
                if (!stack.isEmpty() && stack.pop() == '(') continue;
                count++;
            }
        }
        return count + stack.size();
    }
}
