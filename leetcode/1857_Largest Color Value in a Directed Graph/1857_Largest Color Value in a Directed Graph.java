class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        final int n = colors.length();
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; ++i) adj[i] = new ArrayList<>();
        int[] indegree = new int[n];

        // init adj, indegree
        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            ++indegree[e[1]];
        }

        // init topo sort queue
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; ++i)
            if (indegree[i] == 0) q.add(i);

        // topo sort w/ dp
        int ans = 0;
        int visited = 0; // if DAG, visited should end w/ n
        int dp[][] = new int[n][26]; // node index, color
        while (!q.isEmpty()) {
            int u = q.poll();
            visited += 1;
            int cdx = colors.charAt(u) - 'a';
            ++dp[u][cdx]; // 1. count color
            ans = Math.max(ans, dp[u][cdx]); // 2. update maximum sum

            // search next node
            for (int v : adj[u]) {
                for (int c = 0; c < 26; ++c)
                    dp[v][c] = Math.max(dp[u][c], dp[v][c]); // 3. copy color cnt cache
                if (--indegree[v] == 0) q.add(v); // 4. remove incoming edge
            }
        }

        return visited == n ? ans : -1;
    }
}