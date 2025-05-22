class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
        // zero array를 만들 수 있는 최소 쿼리 수를 구하는 것으로 문제를 치환한다.
        int usedCnt = 0;
        int qdx = 0; // index of queries

        // 시작 지점 순으로 오름차순 정렬
        Arrays.sort(queries, (a, b) -> a[0] - b[0]);
        // 선택 가능한 녀석들의 종료 지점 (오래가는 순 정렬)
        PriorityQueue<Integer> availEnds = new PriorityQueue<>(Collections.reverseOrder());
        // 선택된 녀석들의 종료 지점 (빨리 끝나는 순 정렬)
        PriorityQueue<Integer> selectedEnds = new PriorityQueue<>();

        // 0이 아닌 칸 발견시 필요만큼 쿼리 선택
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0) continue;

            // 이전에 선택한 쿼리 중 i 이전까지의 쿼리 제거
            while (!selectedEnds.isEmpty() && selectedEnds.peek() < i)
                selectedEnds.poll();
            
            // 선택 가능 쿼리 업데이트
            while (qdx < queries.length && queries[qdx][0] <= i)
                availEnds.add(queries[qdx++][1]);

            // 필요한 만큼만 최소한의 쿼리 선택
            int required = nums[i]; // i 지점의 요구 쿼리 수
            while (selectedEnds.size() < required) {
                if (!availEnds.isEmpty() && i <= availEnds.peek())
                    selectedEnds.add(availEnds.poll());
                else return -1; // 쿼리가 부족하면 -1
                ++usedCnt;
            }
        }

        return queries.length - usedCnt;
    }
}