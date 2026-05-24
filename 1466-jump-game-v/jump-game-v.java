class Solution {
    int[] memo;
    int n;

    public int maxJumps(int[] arr, int d) {
        n = arr.length;
        memo = new int[n];
        int maxVisited = 0;

        // Start a DFS from every building to find the overall maximum
        for (int i = 0; i < n; i++) {
            maxVisited = Math.max(maxVisited, dfs(arr, i, d));
        }

        return maxVisited;
    }

    private int dfs(int[] arr, int i, int d) {
        // Return cached result if we've already calculated this building
        if (memo[i] != 0) return memo[i];

        int res = 1;

        // Try jumping to the Right
        for (int j = i + 1; j <= Math.min(i + d, n - 1); j++) {
            // Rule: You can't jump over a building taller or equal to the start
            if (arr[j] >= arr[i]) break;
            res = Math.max(res, 1 + dfs(arr, j, d));
        }

        // Try jumping to the Left
        for (int j = i - 1; j >= Math.max(i - d, 0); j--) {
            if (arr[j] >= arr[i]) break;
            res = Math.max(res, 1 + dfs(arr, j, d));
        }

        // Cache and return
        return memo[i] = res;
    }
}