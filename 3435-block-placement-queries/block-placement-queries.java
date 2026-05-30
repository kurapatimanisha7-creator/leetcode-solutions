class FenwickTree {
    private int[] tree;

    public FenwickTree(int size) {
        this.tree = new int[size + 1];
    }

    // Update the Fenwick tree to maintain the maximum gap size
    public void updateMax(int i, int val) {
        while (i < tree.length) {
            tree[i] = Math.max(tree[i], val);
            i += i & -i;
        }
    }

    // Query the maximum gap value in the prefix range [1, i]
    public int getMax(int i) {
        int maxVal = 0;
        while (i > 0) {
            maxVal = Math.max(maxVal, tree[i]);
            i -= i & -i;
        }
        return maxVal;
    }
}

class Solution {
    public List<Boolean> getResults(int[][] queries) {
        int maxCoord = 0;
        for (int[] q : queries) {
            maxCoord = Math.max(maxCoord, q[1]);
        }
        
        // TreeSet to keep track of active obstacles
        TreeSet<Integer> obstacles = new TreeSet<>();
        obstacles.add(0); // Base sentinel
        
        // Step 1: Gather all obstacles that will ever exist
        for (int[] q : queries) {
            if (q[0] == 1) {
                obstacles.add(q[1]);
            }
        }

        // Step 2: Initialize Fenwick Tree with final obstacle gaps
        FenwickTree ft = new FenwickTree(maxCoord + 1);
        int prev = 0;
        for (int curr : obstacles) {
            if (curr != 0) {
                ft.updateMax(curr, curr - prev);
                prev = curr;
            }
        }

        List<Boolean> reversedResults = new ArrayList<>();

        // Step 3: Process queries in reverse chronological order
        for (int i = queries.length - 1; i >= 0; i--) {
            int type = queries[i][0];
            int x = queries[i][1];

            if (type == 1) {
                // "Remove" obstacle by finding neighbors and merging gaps
                Integer lower = obstacles.lower(x);
                Integer higher = obstacles.higher(x);
                
                obstacles.remove(x);
                
                if (higher != null && lower != null) {
                    ft.updateMax(higher, higher - lower);
                }
            } else {
                int sz = queries[i][2];
                int floorObstacle = obstacles.floor(x);
                
                // Block fits if a historical gap is large enough, 
                // OR the current trailing space up to x is large enough.
                boolean fits = ft.getMax(floorObstacle) >= sz || (x - floorObstacle) >= sz;
                reversedResults.add(fits);
            }
        }

        // Step 4: Flip results back to chronological order
        Collections.reverse(reversedResults);
        return reversedResults;
    }
}