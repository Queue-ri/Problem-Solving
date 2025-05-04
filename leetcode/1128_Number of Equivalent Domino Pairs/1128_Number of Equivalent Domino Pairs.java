class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] hash = new int[100];
        for (int[] d : dominoes)
            ++hash[d[0] > d[1] ? d[1]*10+d[0] : d[0]*10+d[1]];
        int ans = 0;
        for (int i = 11; i < 100; ++i)
            if (hash[i] > 1) ans += hash[i]*(hash[i]-1)/2; // nC2
        return ans;
    }
}