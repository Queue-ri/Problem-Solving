import java.util.*;

class Solution {
    int n, m;
    int[][] minTime;
    int[] dy = {-1, 0, 0, 1};
    int[] dx = {0, -1, 1, 0};

    public int minTimeToReach(int[][] moveTime) {
        this.n = moveTime.length;
        this.m = moveTime[0].length;
        minTime = new int[n][m];
        for (int[] line : minTime) Arrays.fill(line, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.add(new int[]{0, 0, 0});
        minTime[0][0] = 0;

        while (!pq.isEmpty()) {
            int[] e = pq.poll();
            int y = e[0];
            int x = e[1];
            int t = e[2];
            for (int d = 0; d < 4; ++d) {
                int ny = y + dy[d];
                int nx = x + dx[d];
                if (ny < 0 || n <= ny || nx < 0 || m <= nx) continue; // out of bound
                int nt = Math.max(t+1, moveTime[ny][nx]+1);
                if (minTime[ny][nx] <= nt) continue; // better one exists -> drop this
                minTime[ny][nx] = nt;
                pq.add(new int[]{ny, nx, nt});
            }
        }

        return minTime[n-1][m-1];
    }
}