class Solution {
    public int solution(int n, int w, int num) {
        int lv = (num - 1) / w; // 꺼내려는 상자가 놓인 층: 0 ~
        int lastLv = n / w - 1; // 모든 상자가 놓인 맨 위층
        int left = n % w; // 남은 상자 수
        
        // offset: 왼쪽 방향으로부터의 gap
        // 홀수층이면 역방향 고려해서 offset 계산
        int offset = (lv & 1) == 1 ? w - (num - (lv*w)) + 1 : num - (lv*w);
        
        int ans = lastLv - lv + 1;
        // 남은 상자 놓이는 층이 짝수층이면 정방향
        if ((lastLv & 1) == 1) {
            if (offset <= left) ans += 1;
        }
        // 홀수층이면 역방향
        else {
            if (offset + left > w) ans += 1;
        }
        
        return ans;
    }
}