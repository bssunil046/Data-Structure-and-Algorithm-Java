package algorithms;

import java.util.*;

/**
 * Give a list of ranges, merge overlapping ranges.
 *
 * I/P: {[2,7}, {3,6}, {5,8}, {9, 10}}
 * O/P:  {{2,8}, {9,10}}
 */
public class MergeRange {
    static class Range implements Comparable <Range> {
        int start;
        int end;

        Range(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Range range) {
            if(this.start < range.start) {
                return -1;
            } else if(this.start > range.start) {
                return 1;
            } else {
                return 0;
            }
        }
    }
    public static void main(String[] args) {
        HashMap<List<Range>, List<Range>> testCases = new HashMap<>();
        List<Range> input1 = new ArrayList<>();
        input1.add(0, new Range(2, 7));
        input1.add(1, new Range(3, 6));
        input1.add(2, new Range(5, 8));
        input1.add(3,new Range(9, 10));

        List<Range> output1 = new ArrayList<>();
        output1.add(new Range(2, 8));
        output1.add(new Range(9, 10));

        testCases.put(input1, output1);

        List<Range> input2 = new ArrayList<>();
        input2.add(0, new Range(2, 7));
        input2.add(1, new Range(3, 8));
        input2.add(2, new Range(9, 12));
        input2.add(3,new Range(8, 13));
        input2.add(3,new Range(14, 16));

        List<Range> output2 = new ArrayList<>();
        output2.add(new Range(2, 8));
        output2.add(new Range(9, 13));
        output2.add(new Range(14, 16));

        testCases.put(input2, output2);

        int testCaseCount = 1;
        int testCasePassed = 1;

        for(Map.Entry<List<Range>, List<Range>> entry : testCases.entrySet()) {
            List<Range> actualResult = mergeRanges(entry.getKey());
            List<Range> expectedResult = entry.getValue();
            boolean result = false;

            if(actualResult.size() == expectedResult.size()) {
                for(int i = 0;i<actualResult.size();i++) {
                    if(actualResult.get(i).start != expectedResult.get(i).start ||
                            actualResult.get(i).end != expectedResult.get(i).end) {
                        break;
                    }
                    result = true;
                }
            }

            if(result) {
                testCasePassed++;
            }

            System.out.println(result
                    ? testCaseCount++ + " Test case passed!" : testCaseCount++ + " Test case failed - input: " + entry.getKey());
        }
        System.out.println();
        System.out.println(testCasePassed + "/" + --testCaseCount + " test cases passed.");
    }

    private static List<Range> mergeRanges(List<Range> ranges) {
        if(ranges.size() < 2) return ranges;

        List<Range> result = new ArrayList<>();
        Collections.sort(ranges);

        result.add(ranges.get(0));

        for(int i = 1;i<ranges.size();i++) {
            if(ranges.get(i).start <= result.get(result.size() - 1).end) {
                result.get(result.size() - 1).end = Math.max(result.get(result.size() - 1).end, ranges.get(i).end);
            } else {
                result.add(ranges.get(i));
            }
        }

        return result;
    }
}
