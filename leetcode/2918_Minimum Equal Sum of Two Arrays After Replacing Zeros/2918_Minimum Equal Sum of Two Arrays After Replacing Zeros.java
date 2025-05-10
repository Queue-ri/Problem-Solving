class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0;
        long sum2 = 0;
        long zCnt1 = 0;
        long zCnt2 = 0;

        for (long n : nums1) if (n == 0) ++zCnt1; else sum1 += n;
        for (long n : nums2) if (n == 0) ++zCnt2; else sum2 += n;

        long cand = Math.max(sum1+zCnt1, sum2+zCnt2);
        if (sum1 != cand && zCnt1 == 0) return -1;
        if (sum2 != cand && zCnt2 == 0) return -1;

        return cand;
    }
}