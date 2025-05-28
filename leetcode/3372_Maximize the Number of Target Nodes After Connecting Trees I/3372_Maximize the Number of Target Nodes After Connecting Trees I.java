class Solution {
    List<Integer>[] adj1, adj2;
    boolean[] vis1, vis2;
    int n, m, k;

    public int dfs1(int i, int depth) { // tree 1
        if (depth > k) return 0;

        int res = 1;
        for (int nxt : adj1[i]) {
            vis1[i] = true;
            if (!vis1[nxt]) res += dfs1(nxt, depth+1);
            vis1[i] = false;
        }

        return res;
    }

    public int dfs2(int j, int depth) { // tree 2
        if (depth > k-1) return 0;

        int res = 1;
        for (int nxt : adj2[j]) {
            vis2[j] = true;
            if (!vis2[nxt]) res += dfs2(nxt, depth+1);
            vis2[j] = false;
        }

        return res;
    }

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        this.n = edges1.length + 1;
        this.m = edges2.length + 1;
        this.k = k;

        // init adj
        this.adj1 = new ArrayList[n];
        this.adj2 = new ArrayList[m];
        for (int i = 0; i < n; ++i) adj1[i] = new ArrayList<>();
        for (int j = 0; j < m; ++j) adj2[j] = new ArrayList<>();
        for (int[] e : edges1) {
            adj1[e[0]].add(e[1]);
            adj1[e[1]].add(e[0]);
        }
        for (int[] e : edges2) {
            adj2[e[0]].add(e[1]);
            adj2[e[1]].add(e[0]);
        }

        // init visited
        vis1 = new boolean[n];
        vis2 = new boolean[m];

        // dfs
        int[] ans = new int[n];
        int mx = 0; // get maximum tree 2 nodes of distance k
        for (int j = 0; j < m; ++j)
            mx = Math.max(mx, dfs2(j, 0));
        
        for (int i = 0; i < n; ++i) {
            // count tree 1 nodes of distance k
            ans[i] = dfs1(i, 0) + mx;
        }

        return ans;
    }
}