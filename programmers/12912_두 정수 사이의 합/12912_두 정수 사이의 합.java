class Solution {
    public long solution(int a, int b) {
        long s;
        long t;
        s = a < b ? a : b;
        t = a < b ? b : a;
        long ans = 0;
        for (long k = s; k < t+1; ++k) {
            ans += k;
        }
        return ans;
    }
}