class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        // 1. pre-calc XOR diff values
        int[] diff = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) diff[i] = (nums[i] ^ k) - nums[i];

        // 2. get max sum
        long ans = 0;
        for (int n : nums) ans += n;

        // sort desc
        // diff = Arrays.stream(diff).boxed().sorted(Collections.reverseOrder()).mapToInt(i->i).toArray();
        // sort asc
        Arrays.sort(diff);
        for (int i = diff.length-1; 0 < i; i-=2) {
            int diffSum = diff[i] + diff[i-1];
            if (0 < diffSum) ans += diffSum;
            else break;
        }

        return ans;
    }
}