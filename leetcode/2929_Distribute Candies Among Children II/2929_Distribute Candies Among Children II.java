class Solution {
    public long H3(long n) {
        return n < 0 ? 0 : (n+2)*(n+1)/2;
    }

    public long distributeCandies(int n, int limit) {
        return H3(n) - 3*H3(n-(limit+1)) + 3*H3(n-2*(limit+1)) - H3(n-3*(limit+1));
    }
}