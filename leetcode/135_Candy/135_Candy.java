class Solution {
    public int candy(int[] ratings) {
        // check continuous asc/desc rating order
        int n = ratings.length;
        int ans = n;
        int asc[] = new int[n];
        int desc[] = new int[n];

        int v = 0;
        for (int i = 1; i < n; ++i) {
            asc[i-1] = v;
            if (ratings[i-1] < ratings[i]) ++v;
            else v = 0;
        }
        asc[n-1] = v;

        v = 0;
        for (int i = n-1; 0 < i; --i) {
            desc[i] = v;
            if (ratings[i-1] > ratings[i]) ++v;
            else v = 0;
        }
        desc[0] = v;

        for (int i = 0; i < n; ++i) {
            ans += Math.max(asc[i], desc[i]);
        }

        return ans;
    }
}