class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0; // insertion index
        int j = 0;
        while(j < nums.length) {
            if (nums[j] != val) nums[i++] = nums[j];
            ++j;
        }
        return i;
    }
}