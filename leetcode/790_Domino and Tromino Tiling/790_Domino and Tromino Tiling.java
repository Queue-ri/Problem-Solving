class Solution {
    int n;
    final long mod = 1_000_000_007;
    int memo[][] = new int[2][1000];

    public int dp(int i, boolean gap) {
        if (i == n) return gap ? 0 : 1;
        if (i > n) return 0;
        if (memo[gap?1:0][i] != -1) return memo[gap?1:0][i];

        long res = 0L;
        if (gap) {
            res += dp(i+1, false); // ㄱ
            res += dp(i+1, true); // ㅡ
        }
        else {
            res += dp(i+1, false); // ㅣ
            res += dp(i+2, false); // =
            res += 2L * dp(i+2, true); // ㄴ
        }
        res %= mod;

        return memo[gap?1:0][i] = (int)res;
    }

    public int numTilings(int n) {
        this.n = n;
        Arrays.fill(memo[0], -1);
        Arrays.fill(memo[1], -1);

        return dp(0, false);
    }
}