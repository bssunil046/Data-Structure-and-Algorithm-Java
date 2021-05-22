package algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Give a word aaabbc, compress it as 3a2b1c.
 * Consective repeating characters should be merged as number of characters and the character.
 */
public class CompressWord {
    public static void main(String[] args) {
        HashMap<String, String> testCases = new HashMap<>();
        testCases.put("aaabbc", "3a2b1c");
        testCases.put("abc", "1a1b1c");
        testCases.put("aaabbbaaaccdefghhh", "3a3b3a2c1d1e1f3h");
        testCases.put("a", "1a");
        testCases.put("ab", "1a1b");
        testCases.put("", "");

        int testCaseCount = 1;
        int testCasePassed = 1;

        for(Map.Entry<String, String> entry : testCases.entrySet()) {
            boolean result = compressWord(entry.getKey()).equals(entry.getValue());
            if(result) {
                testCasePassed++;
            }

            System.out.println(result
                    ? testCaseCount++ + " Test case passed!" : testCaseCount++ + " Test case failed - input: " + entry.getKey());
        }
        System.out.println();
        System.out.println(testCasePassed + "/" + testCaseCount + " test cases passed.");
    }

    private static String compressWord(String str) {
        if(str == null || str.isEmpty())  return str;

        StringBuilder result = new StringBuilder();
        int charCount = 1;

        for(int i = 0;i < str.length();i++) {
            if(i == str.length() - 1) {
                result.append(charCount);
                result.append(str.charAt(i));
            } else if(str.charAt(i) == str.charAt(i+1)) {
                charCount++;
                continue;
            } else {
                result.append(charCount);
                result.append(str.charAt(i));
                charCount = 1;
            }
        }
        return result.toString();
    }
}
