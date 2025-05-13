class Solution {
    final int MOD = 1_000_000_007;

    public int lengthAfterTransformations(String s, int t) {
        int[] dp = new int[26];
        int[] nxt = new int[26];

        // init: if t == 0 then length = 1
        for (int ch = 0; ch < 26; ++ch) dp[ch] = 1;

        while (t-- > 0) {
            for (int ch = 0; ch < 26; ++ch) {
                if (ch == 25) { // cnt('z') <- cnt('a') + cnt('b')
                    nxt[ch] = (dp[0] + dp[1]) % MOD;
                } else {
                    nxt[ch] = dp[ch+1];
                }
            }

            int[] tmp = dp;
            dp = nxt;
            nxt = tmp;
        }

        long ans = 0;
        for (char ch : s.toCharArray()) {
            ans = (ans + dp[ch-'a']) % MOD;
        }

        return (int) ans;
    }
}