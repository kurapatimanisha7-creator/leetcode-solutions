import java.util.*;

class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        // 1. Group connected indices using Union-Find
        for (int[] swap : allowedSwaps) {
            union(parent, swap[0], swap[1]);
        }

        // 2. Map each root to the multiset of values available in that component
        Map<Integer, Map<Integer, Integer>> components = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = find(parent, i);
            components.putIfAbsent(root, new HashMap<>());
            Map<Integer, Integer> counts = components.get(root);
            counts.put(source[i], counts.getOrDefault(source[i], 0) + 1);
        }

        // 3. For each index, check if target[i] exists in its component's pool
        int distance = 0;
        for (int i = 0; i < n; i++) {
            int root = find(parent, i);
            Map<Integer, Integer> counts = components.get(root);
            int targetVal = target[i];

            if (counts.getOrDefault(targetVal, 0) > 0) {
                counts.put(targetVal, counts.get(targetVal) - 1);
            } else {
                // No match found in the available pool for this component
                distance++;
            }
        }

        return distance;
    }

    private int find(int[] parent, int i) {
        if (parent[i] == i) return i;
        return parent[i] = find(parent, parent[i]); // Path compression
    }

    private void union(int[] parent, int i, int j) {
        int rootI = find(parent, i);
        int rootJ = find(parent, j);
        if (rootI != rootJ) parent[rootI] = rootJ;
    }
}