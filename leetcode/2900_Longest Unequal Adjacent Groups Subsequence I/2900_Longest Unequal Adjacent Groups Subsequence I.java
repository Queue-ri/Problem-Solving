class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> ansList = new ArrayList<>();
        ansList.add(words[0]);
        int prev = groups[0];
        for (int i = 1; i < words.length; ++i) {
            if (groups[i] != prev) {
                ansList.add(words[i]);
                prev = groups[i];
            }
        }
        return ansList;
    }
}