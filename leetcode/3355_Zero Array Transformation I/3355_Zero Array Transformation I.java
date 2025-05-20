class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int[] diff = new int[nums.length+2];
        for (int[] q : queries) {
            ++diff[q[0]];
            --diff[q[1]+1];
        }

        if (diff[0] < nums[0]) return false;
        for (int i = 1; i < nums.length; ++i) {
            diff[i] = diff[i] + diff[i-1];
            if (diff[i] < nums[i]) return false;
        }

        return true;
    }
}