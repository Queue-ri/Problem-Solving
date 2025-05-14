import java.util.*;

class Solution {
    static final int MOD = 1_000_000_007;
    
    // matrix multiplication
    private long[][] matMul(long[][] a, long[][] b) {
        long[][] res = new long[26][26];
        for (int i = 0; i < 26; ++i) {
            for (int k = 0; k < 26; ++k) {
                if (a[i][k] == 0) continue;
                for (int j = 0; j < 26; ++j) {
                    res[i][j] = (res[i][j] + a[i][k] * b[k][j]) % MOD;
                }
            }
        }
        return res;
    }
    
    // matrix exponentiation
    private long[][] matPow(long[][] matrix, int power) {
        long[][] res = new long[26][26];
        for (int i = 0; i < 26; ++i) {
            res[i][i] = 1; // init w/ identity matrix
        }
        while (power > 0) {
            if ((power & 1) == 1) {
                res = matMul(res, matrix);
            }
            matrix = matMul(matrix, matrix);
            power >>= 1;
        }
        return res;
    }
    
    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        // 1. init transition matrix
        long[][] T = new long[26][26];
        for (int ch = 0; ch < 26; ++ch) {
            int num = nums.get(ch);
            for (int j = 1; j <= num; ++j) {
                int nxtCh = (ch + j) % 26;
                ++T[ch][nxtCh];
            }
        }

        // 2. init vector
        long[] S = new long[26];
        for (char ch : s.toCharArray()) ++S[ch-'a'];
        
        long[][] T_t = matPow(T, t); // calc T^t

        // calc S * T^t
        long[] S_t = new long[26];
        for (int i = 0; i < 26; ++i)
            for (int j = 0; j < 26; ++j)
                S_t[j] = (S_t[j] + S[i] * T_t[i][j]) % MOD;
        
        // sum all vector elements
        long ans = 0;
        for (long v : S_t) ans = (ans + v) % MOD;

        return (int)ans;
    }
}