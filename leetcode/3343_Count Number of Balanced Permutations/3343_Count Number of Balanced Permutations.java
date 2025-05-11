class Solution {
    final int MOD = 1_000_000_007;
    int[] cnt = new int[10];
    long[] fact = new long[81];
    long[] inv = new long[81];
    long[] invFact = new long[81];
    int n, evenLen, oddLen, halfSum;
    int[][][] memo;

    private long dp(int i, int depth, int curSum) { // i: current digit | depth: length of selected
        if (curSum > halfSum || depth > evenLen) return 0;
        if (i > 9) return (depth == evenLen && curSum == halfSum) ? 1 : 0;
        if (memo[i][depth][curSum] != -1) return memo[i][depth][curSum];

        long res = 0;
        for (int use = 0; use <= cnt[i] && depth+use <= evenLen && curSum+i*use <= halfSum; ++use) {
            long evenPerm = fact[depth+use] * invFact[depth] % MOD * invFact[use] % MOD;
            long oddInv = invFact[cnt[i]-use]; // 안쓴만큼 홀수 인덱스로 감 -> 홀수 인덱스 배치 수식의 분모
            res = (res + (evenPerm * oddInv % MOD) * dp(i+1, depth+use, curSum+i*use)) % MOD;
        }

        memo[i][depth][curSum] = (int) res;
        return res;
    }

    public int countBalancedPermutations(String num) {
        n = num.length();
        int totalSum = 0;
        for (char ch : num.toCharArray()) {
            totalSum += ch - '0';
            ++cnt[ch-'0'];
        }
        if ((totalSum & 1) == 1) return 0; // can't satisfy condition

        halfSum = totalSum / 2;
        evenLen = (n+1) / 2;
        oddLen = n - evenLen;
        memo = new int[10][evenLen+1][halfSum+1];
        for (int i = 0; i < 10; ++i)
            for (int j = 0; j <= evenLen; ++j)
                Arrays.fill(memo[i][j], -1);
        
        precalc();
        long res = dp(0, 0, 0);
        // 홀수 인덱스 배치 수식의 분자 곱하기
        res = res * fact[oddLen] % MOD;
        return (int) res;
    }

    public void precalc() {
        fact[0] = inv[0] = invFact[0] = 1;
        for (int i = 1; i < 81; ++i) fact[i] = fact[i-1] * i % MOD;
        inv[1] = 1; // extended euclidean
        for (int i = 2; i < 81; ++i) inv[i] = MOD - (MOD/i) * inv[MOD%i] % MOD;
        for (int i = 1; i < 81; ++i) invFact[i] = invFact[i-1] * inv[i] % MOD;
    }
}