class Solution {
    int n;
    String[] words;
    int[] groups;
    Map<String, List<String>> memo = new HashMap<>();

    public List<String> dp(int pdx, int cdx) { // prev index, cur index
        if (cdx == n) return new ArrayList<>();
        String key = pdx + "," + cdx;
        if (memo.containsKey(key)) return memo.get(key);

        List<String> skip = dp(pdx, cdx+1); // skip current word
        // ** below is WA **
        // List<String> select = new ArrayList<>(List.of(words[cdx])); // select current word
        // if (pdx == -1 || isValid(pdx, cdx)) select.addAll(dp(cdx, cdx+1));
        List<String> select = new ArrayList<>(); // select current word
        if (pdx == -1 || isValid(pdx, cdx)) {
            select = dp(cdx, cdx+1);
            select = new ArrayList<>(select);
            select.add(0, words[cdx]);
        }

        List<String> res = skip.size() < select.size() ? select : skip;

        memo.put(key, res);
        return res;
    }

    public boolean isValid(int pdx, int cdx) {
        // check group
        if (groups[pdx] == groups[cdx]) return false;

        // check hamming dist
        String a = words[pdx];
        String b = words[cdx];
        if (a.length() != b.length()) return false;
        
        int dist = 0;
        for (int i = 0; i < a.length(); ++i)
            if (a.charAt(i) != b.charAt(i)) ++dist;

        return dist == 1;
    }

    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        this.n = words.length;
        this.words = words;
        this.groups = groups;

        return dp(-1, 0);
    }
}