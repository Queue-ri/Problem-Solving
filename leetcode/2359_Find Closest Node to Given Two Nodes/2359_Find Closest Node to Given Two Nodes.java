class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        final int n = edges.length;
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
        Arrays.fill(dist1, -1);
        Arrays.fill(dist2, -1);

        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{node1, 0});
        dist1[node1] = 0;
        while (!q.isEmpty()) {
            int[] e = q.poll();
            int s = e[0];
            int v = e[1];
            int t = edges[s];
            if (t == -1) break; // no outgoing node
            if (dist1[t] != -1) break; // already visited
            dist1[t] = v + 1;
            q.add(new int[]{t, v+1});
        }

        q = new ArrayDeque<>();
        q.add(new int[]{node2, 0});
        dist2[node2] = 0;
        while (!q.isEmpty()) {
            int[] e = q.poll();
            int s = e[0];
            int v = e[1];
            int t = edges[s];
            if (t == -1) break; // no outgoing node
            if (dist2[t] != -1) break; // already visited
            dist2[t] = v + 1;
            q.add(new int[]{t, v+1});
        }

        int ans = -1;
        int mn = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i) {
            if (dist1[i] == -1 || dist2[i] == -1) continue;

            int res = Math.max(dist1[i], dist2[i]);
            if (res < mn) {
                mn = res;
                ans = i;
            }
        }

        return ans;
    }
}