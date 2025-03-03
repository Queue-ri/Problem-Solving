class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 1;
        int j = 1;
        while (j < nums.length) {
            if (nums[j-1] != nums[j]) {
                nums[i] = nums[j];
                ++i;
            }
            ++j;
        }
        return i;
    }
}