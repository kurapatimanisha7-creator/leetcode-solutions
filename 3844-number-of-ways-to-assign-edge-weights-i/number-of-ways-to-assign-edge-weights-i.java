import java.util.*;

class Solution {
    private static final int MOD = 1_000_000_007;

    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;
        
        // Step 1: Build the adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        // Step 2: Use BFS to find the maximum depth (number of edges from root)
        int maxDepth = 0;
        boolean[] visited = new boolean[n + 1];
        Queue<int[]> queue = new LinkedList<>(); // stores {node, current_depth}
        
        queue.offer(new int[]{1, 0});
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int u = curr[0];
            int depth = curr[1];
            
            maxDepth = Math.max(maxDepth, depth);

            for (int v : adj.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    queue.offer(new int[]{v, depth + 1});
                }
            }
        }

        // Step 3: Compute 2^(maxDepth - 1) % MOD
        if (maxDepth == 0) return 0; // Guard rail (though trees with edges will have maxDepth >= 1)
        
        return (int) power(2, maxDepth - 1);
    }

    // Helper method for modular exponentiation: (base^exp) % MOD
    private long power(long base, long exp) {
        long res = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = (res * base) % MOD;
            }
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return res;
    }
}