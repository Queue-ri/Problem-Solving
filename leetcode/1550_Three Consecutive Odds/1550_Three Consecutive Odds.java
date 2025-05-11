class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int i = 0;
        int cnt = 0;
        while (i < arr.length) {
            if ((arr[i++] & 1) == 1) ++cnt;
            else cnt = 0;
            if (cnt == 3) return true;
        }

        return false;
    }
}