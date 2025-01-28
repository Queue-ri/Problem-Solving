class Solution {
    public boolean canJump(int[] nums) {
        int mxIdx = 0; // available max index
        int tdx = nums.length-1; // last index
        for (int i = 0; i < nums.length; ++i) {
            if (i > mxIdx) return false;
            mxIdx = Math.max(mxIdx, i+nums[i]);
            if (tdx <= mxIdx) return true;
        }
        return false;
    }
}