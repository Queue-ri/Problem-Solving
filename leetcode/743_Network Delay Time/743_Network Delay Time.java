import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] adj = new ArrayList[n+1]; // 1 ~ n
        for (int i = 1; i < n+1; ++i) adj[i] = new ArrayList<>();
        for (int[] data : times) adj[data[0]].add(new int[]{data[1], data[2]});

        int[] minTime = new int[n+1];
        Arrays.fill(minTime, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e[1]));
        minTime[0] = minTime[k] = 0;
        pq.add(new int[]{k, 0}); // node, time

        while (!pq.isEmpty()) {
            int[] e = pq.poll();
            int cur = e[0];
            int time = e[1];
            for (int[] data : adj[cur]) {
                int nxt = data[0];
                int w = data[1];
                if (minTime[nxt] <= time + w) continue;
                minTime[nxt] = time + w;
                pq.add(new int[]{nxt, time+w});
            }
        }

        int ans = 0;
        for (int v : minTime) {
            if (v == Integer.MAX_VALUE) return -1; // not reachable
            ans = ans < v ? v : ans;
        }

        return ans;
    }
}