class Solution {
    int n;

    public int calc(long s, long e) { // [s, e)
        int cnt = 0;
        while (s <= n) { // should include n
            cnt += Math.min(n+1, e) - s; // ex. 100 ~ 105 is 106 - 100
            s *= 10; // child prefix
            e *= 10; // child prefix
        }

        return cnt;
    }

    public int findKthNumber(int n, int k) {
        this.n = n;

        int cur = 1;
        k -= 1;

        while (k > 0) {
            // count numbers between two prefixes (ex. 1 ~ 2)
            int cnt = calc(cur, cur+1);

            if (cnt > k) {
                k -= 1; // current
                cur *= 10; // move to child prefix
            }
            else {
                k -= cnt; // skip all children
                cur += 1; // move to sibling prefix
            }
        }

        return cur;
    }
}