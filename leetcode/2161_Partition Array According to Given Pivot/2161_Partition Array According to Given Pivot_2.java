class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] ans = new int[nums.length];

        int i = 0;
        int j = nums.length-1;
        int ansL = 0;
        int ansR = nums.length-1;
        while (i < nums.length) {
            if (nums[i] < pivot) {
                ans[ansL++] = nums[i];
            }
            if (nums[j] > pivot) {
                ans[ansR--] = nums[j];
            }
            ++i; --j;
        }
        while (ansL <= ansR) {
            ans[ansL++] = pivot;
        }

        return ans;
    }
}