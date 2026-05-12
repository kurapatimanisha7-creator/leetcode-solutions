class Solution {
    public int minimumEffort(int[][] tasks) {
        // 1. Sort tasks based on (minimum - actual) difference in descending order
        // Beginner tip: (b[1] - b[0]) - (a[1] - a[0]) helps in descending sort
        Arrays.sort(tasks, (a, b) -> (b[1] - b[0]) - (a[1] - a[0]));

        int totalEnergy = 0;   // Answer: Starting energy required
        int currentEnergy = 0; // Running energy we have at any moment

        for (int[] task : tasks) {
            int actual = task[0];
            int minimum = task[1];

            // 2. Check if we have enough energy to START the task
            if (currentEnergy < minimum) {
                // If not enough, add the deficit to our total investment
                int needed = minimum - currentEnergy;
                totalEnergy += needed;
                currentEnergy += needed;
            }

            // 3. Subtract the energy actually SPENT
            currentEnergy -= actual;
        }

        return totalEnergy;
    }
}