class Solution {
    public long solution(int price, int money, int count) {
        long total = (long)price * (count+1) * count / 2;
        long ans = total - money;
        if (ans < 0) ans = 0;
        
        return ans;
    }
}