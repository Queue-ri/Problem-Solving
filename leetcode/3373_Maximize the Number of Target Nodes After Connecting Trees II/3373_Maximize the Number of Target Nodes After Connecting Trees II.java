class Solution {
    List<Integer>[] adj1, adj2;
    boolean[] vis;
    int n, m;
    int[] cache1; // tree1 node group per ndx

    public int dfs(int ndx, int depth, int mxDepth, int parity) {
        if (depth > mxDepth) return 0;

        int res = (depth & 1) == parity ? 1 : 0;
        if (parity == 0) cache1[ndx] = depth & 1; // mark tree1 node group
        List<Integer>[] adj = parity == 0 ? adj1 : adj2;
        for (int nxt : adj[ndx]) {
            vis[ndx] = true;
            if (!vis[nxt]) res += dfs(nxt, depth+1, mxDepth, parity);
            vis[ndx] = false;
        }

        return res;
    }

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        this.n = edges1.length + 1;
        this.m = edges2.length + 1;

        // init vis
        vis = new boolean[n < m ? m : n];

        // init adj
        adj1 = new ArrayList[n];
        adj2 = new ArrayList[m];
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

        // precalc: get max from tree2
        int cand = dfs(edges2[0][0], 0, m, 1); // parity: odd
        int mx = Math.max(cand, m-cand);
        
        // precalc: get max per group from tree1
        cache1 = new int[n];
        int groupVal0 = dfs(edges1[0][0], 0, n, 0); // parity: even
        int groupVal1 = n - groupVal0;

        int[] ans = new int[n];
        for (int i = 0; i < n; ++i)
            ans[i] = (cache1[i] == 0 ? groupVal0 : groupVal1) + mx;
        
        return ans;
    }
}