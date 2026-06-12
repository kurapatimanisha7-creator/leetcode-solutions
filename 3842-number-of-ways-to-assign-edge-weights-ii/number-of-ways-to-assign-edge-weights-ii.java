class Solution {
    private static final int MOD = 1_000_000_007;
    private List<Integer>[] graph;
    private int[] depth;
    private int[][] up;
    private int LOG;
    private long[] pow2;

    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        int n = edges.length + 1;
        LOG = (int) (Math.log(n) / Math.log(2)) + 1;
        
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        depth = new int[n + 1];
        up = new int[n + 1][LOG];
        
        // 1. Run DFS to compute depths and immediate parents
        dfs(1, 1, 0);

        // 2. Precompute the binary lifting table
        for (int j = 1; j < LOG; j++) {
            for (int i = 1; i <= n; i++) {
                up[i][j] = up[up[i][j - 1]][j - 1];
            }
        }

        // 3. Precompute powers of 2
        pow2 = new long[n + 1];
        pow2[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow2[i] = (pow2[i - 1] * 2) % MOD;
        }

        // 4. Process queries
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            
            if (u == v) {
                ans[i] = 0;
            } else {
                int lca = getLCA(u, v);
                int k = depth[u] + depth[v] - 2 * depth[lca];
                ans[i] = (int) pow2[k - 1];
            }
        }

        return ans;
    }

    private void dfs(int node, int parent, int d) {
        depth[node] = d;
        up[node][0] = parent;
        for (int neighbor : graph[node]) {
            if (neighbor != parent) {
                dfs(neighbor, node, d + 1);
            }
        }
    }

    private int getLCA(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        // Lift u to the same depth as v
        for (int j = LOG - 1; j >= 0; j--) {
            if (depth[u] - (1 << j) >= depth[v]) {
                u = up[u][j];
            }
        }

        if (u == v) return u;

        // Lift both together until right under the LCA
        for (int j = LOG - 1; j >= 0; j--) {
            if (up[u][j] != up[v][j]) {
                u = up[u][j];
                v = up[v][j];
            }
        }

        return up[u][0];
    }
}