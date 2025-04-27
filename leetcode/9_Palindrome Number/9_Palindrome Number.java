class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        long rx = Long.parseLong(new StringBuilder(x+"").reverse().toString());
        return rx == x;
    }
}