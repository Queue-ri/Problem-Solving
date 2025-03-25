import java.util.*;

class Solution {
    public int wordCount(String[] startWords, String[] targetWords) {
        String[] sorted = new String[targetWords.length];
        for (int i = 0; i < targetWords.length; ++i) {
            char[] tArr = targetWords[i].toCharArray();
            Arrays.sort(tArr);
            sorted[i] = String.valueOf(tArr);
        }

        // precalc convertables
        Set<String> candSet = new HashSet<>();
        for (int i = 0; i < startWords.length; ++i) {
            // candidate char sets
            Set<String> startSet = new HashSet<>(Arrays.asList(startWords[i].split("")));
            Set<String> alphabetSet = new HashSet<>();
            for (char ch = 'a'; ch <= 'z'; ++ch) alphabetSet.add(String.valueOf(ch));

            Set<String> remainderSet = new HashSet<>(alphabetSet);
            remainderSet.removeAll(startSet);

            // converted string list
            for (String ch : remainderSet) {
                char[] sArr = (startWords[i] + ch).toCharArray();
                Arrays.sort(sArr);
                candSet.add(String.valueOf(sArr));
            }
        }

        // check obtainability
        int ans = 0;
        for (String sortedTarget : sorted) {
            if (candSet.contains(sortedTarget)) ans += 1;
        }

        return ans;
    }
}