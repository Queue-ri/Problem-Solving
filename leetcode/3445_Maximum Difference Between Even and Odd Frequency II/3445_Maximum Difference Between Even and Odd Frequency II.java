class Solution {
    public int maxDifference(String s, int k) {
        final int n = s.length();
        int ans = Integer.MIN_VALUE;

        // 서로 다른 문자 쌍 (a, b)에 대해 모두 시도
        for (char a = '0'; a <= '4'; ++a) {
            for (char b = '0'; b <= '4'; ++b) {
                if (a == b) continue;

                // --- per single (a, b) pair ---

                // mn[status]: 해당 상태의 (prev_a - prev_b) 최솟값을 저장
                int[] mn = new int[4];
                Arrays.fill(mn, Integer.MAX_VALUE);

                // right 포인터까지의 a, b 문자 개수
                int cnt_a = 0, cnt_b = 0;
                // left 포인터까지의 a, b 문자 개수
                int prev_a = 0, prev_b = 0;
                int left = -1;

                // right 포인터로 문자열 순회
                for (int right = 0; right < n; ++right) {
                    // 현재 위치의 문자가 a 또는 b일 경우 구간합 업데이트
                    cnt_a += (s.charAt(right) == a) ? 1 : 0;
                    cnt_b += (s.charAt(right) == b) ? 1 : 0;

                    // 조건을 만족하는 동안 left 포인터를 이동시키며 mn 배열 업데이트
                    // 조건:
                    //  - 구간 길이가 최소 k 이상
                    //  - b 문자가 현재 구간 내에 최소 2개 이상 (0 또는 1은 안됨)
                    while (right-left >= k && cnt_b-prev_b >= 2) {
                        // 현재 left 포인터가 가리키는 구간의 상태를 가져옴
                        int left_status = getStatus(prev_a, prev_b);

                        // 해당 상태에서의 (prev_a - prev_b) 최솟값을 mn 배열에 저장
                        mn[left_status] = Math.min(mn[left_status], prev_a-prev_b);

                        // left 포인터를 한 칸 오른쪽으로 이동시키고 구간합 업데이트
                        ++left;
                        prev_a += (s.charAt(left) == a) ? 1 : 0;
                        prev_b += (s.charAt(left) == b) ? 1 : 0;
                    }

                    // -- 현재의 right 포인터 기준에서 가능한 최대 값을 계산 --

                    // 1. 현재 prefix의 상태 (짝/홀 여부)를 가져옴
                    int right_status = getStatus(cnt_a, cnt_b);

                    // 2. 정답이 될 substring의 상태는 (a: 홀수, b: 짝수) = 0b10 이므로,
                    // prefix 상태 간 XOR을 통해 필요한 이전 상태를 계산
                    int required_status = right_status ^ 0b10;

                    // 3. 해당 상태의 prefix가 이전에 존재했다면,
                    if (mn[required_status] != Integer.MAX_VALUE) {
                        // 현재(cnt_a - cnt_b)와 해당 상태의 최소(prev_a - prev_b)를 이용해 최대 차이를 계산
                        ans = Math.max(ans, cnt_a-cnt_b-mn[required_status]);
                    }
                } // end of s iteration

            }
        }
        return ans;
    }

    private int getStatus(int cnt_a, int cnt_b) {
        // cnt_a와 cnt_b의 홀짝 여부를 0bxx로 status화 하여 반환
        return ((cnt_a & 1) << 1) | (cnt_b & 1);
    }
}