class Solution {
    int[] gNums;
    boolean[] memo; // true: visited
    boolean ans;

    public void dfs(int i) throws Exception {
        int mx = gNums[i];
        if (i+mx < gNums.length-1) {
            // rcs
            for (int p = 1; p < mx+1; ++p) {
                if (!memo[i+p]) dfs(i+p);
            }
        }
        else {
            ans = true;
            throw new Exception();
        }

        memo[i] = true; // visited
        return;
    }

    public boolean canJump(int[] nums) {
        gNums = nums;
        memo = new boolean[nums.length];
        Arrays.fill(memo, false);
        ans = false;
        try {
            dfs(0);
        } catch (Exception e) {
            //
        }

        return ans;
    }
}