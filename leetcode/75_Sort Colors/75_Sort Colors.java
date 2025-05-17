class Solution {
    public void sortColors(int[] nums) {
        int[] cnt = new int[3];
        for (int n : nums) ++cnt[n];
        for (int i = 0; i < nums.length; ++i) {
            nums[i] = cnt[0]-- > 0 ? 0 : cnt[1]-- > 0 ? 1 : 2; 
        }
    }
}