class Solution {
    public String answerString(String word, int numFriends) {
        if (numFriends == 1) return word; // corner case

        // lex order first, desc length order then
        final int n = word.length();
        final int mxLen = word.length() - (numFriends-1);

        Set<String> candSet = new TreeSet<>(Collections.reverseOrder());
        char mxChar = 'a';
        char[] wordArr = word.toCharArray();
        for (char ch : wordArr) mxChar = mxChar < ch ? ch : mxChar;

        for (int i = 0; i < n; ++i) {
            if (wordArr[i] != mxChar) continue;
            int j = Math.min(i+mxLen, n);
            candSet.add(word.substring(i, j));
        }
        
        return candSet.iterator().next();
    }
}