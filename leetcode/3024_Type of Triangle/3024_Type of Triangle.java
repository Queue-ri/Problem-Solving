class Solution {
    public String triangleType(int[] nums) {
        int mx = Math.max(nums[0], Math.max(nums[1], nums[2]));
        int r = nums[0] + nums[1] + nums[2] - mx;
        if (r <= mx) return "none";
        else if (nums[0] == nums[1] && nums[1] == nums[2]) return "equilateral";
        else if (nums[0] == nums[1] || nums[0] == nums[2] || nums[1] == nums[2]) return "isosceles";
        return "scalene";
    }
}