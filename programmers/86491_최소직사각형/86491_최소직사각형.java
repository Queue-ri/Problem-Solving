class Solution {
    public int solution(int[][] sizes) {
        int mxw = 0;
        int mxh = 0;
        for (int[] s : sizes) {
            int nw = s[0];
            int nh = s[1];
            int res1 = Math.max(mxw, nw) * Math.max(mxh, nh);
            int res2 = Math.max(mxw, nh) * Math.max(mxh, nw);
            if (res1 < res2) {
                mxw = Math.max(mxw, nw);
                mxh = Math.max(mxh, nh);
            }
            else {
                mxw =  Math.max(mxw, nh);
                mxh = Math.max(mxh, nw);
            }
        }
        return mxw * mxh;
    }
}