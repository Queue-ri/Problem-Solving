class Solution {
    public int maxDifference(String s) {
        // a1 should be maximum
        // a2 should be minimum
        int[] cnt = new int[26];
        for (char ch : s.toCharArray()) {
            ++cnt[ch-'a'];
        }

        int a1 = 0;
        int a2 = 101;
        for (int v : cnt) {
            if ((v & 1) == 1 && a1 < v) a1 = v;
            else if ((v & 1) == 0 && v < a2 && 0 < v) a2 = v;
        }
        
        return a1 - a2;
    }
}