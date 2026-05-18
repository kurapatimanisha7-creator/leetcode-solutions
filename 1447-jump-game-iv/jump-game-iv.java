class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if (n <= 1) return 0;

        // Step 1: Map each value to all its indices
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.computeIfAbsent(arr[i], v -> new ArrayList<>()).add(i);
        }

        // Step 2: BFS initialization
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        
        queue.offer(0);
        visited[0] = true;
        int steps = 0;

        // Step 3: Start BFS Layer by Layer
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();

                // Target reached
                if (curr == n - 1) return steps;

                // Option 1: Same value jumps
                if (graph.containsKey(arr[curr])) {
                    for (int next : graph.get(arr[curr])) {
                        if (!visited[next]) {
                            visited[next] = true;
                            queue.offer(next);
                        }
                    }
                    // VERY IMPORTANT: Clear the list to avoid redundant checks (Prevents TLE)
                    graph.remove(arr[curr]);
                }

                // Option 2: Jump to i + 1
                if (curr + 1 < n && !visited[curr + 1]) {
                    visited[curr + 1] = true;
                    queue.offer(curr + 1);
                }

                // Option 3: Jump to i - 1
                if (curr - 1 >= 0 && !visited[curr - 1]) {
                    visited[curr - 1] = true;
                    queue.offer(curr - 1);
                }
            }
            steps++;
        }
        
        return -1;
    }
}