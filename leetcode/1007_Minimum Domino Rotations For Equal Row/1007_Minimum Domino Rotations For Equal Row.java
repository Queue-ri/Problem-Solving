class Solution {
    int[] topCnt;
    int[] bottomCnt;
    int[] equalCnt;
    int n;

    public int minDominoRotations(int[] tops, int[] bottoms) {
        n = tops.length;
        topCnt = new int[7]; // count 1 ~ 6
        bottomCnt = new int[7];
        equalCnt = new int[7];

        for (int i = 0; i < n; ++i) {
            ++topCnt[tops[i]];
            ++bottomCnt[bottoms[i]];
            if (tops[i] == bottoms[i]) ++equalCnt[tops[i]];
        }

        int ans = 20000;
        for (int k = 1; k < 7; ++k) {
            if (n <= topCnt[k] + bottomCnt[k] - equalCnt[k]) {
                int swapCnt = n - Math.max(topCnt[k], bottomCnt[k]);
                ans = swapCnt < ans ? swapCnt : ans;
            }
        }
        if (ans == 20000) return -1;
        return ans;
    }
}