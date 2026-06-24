class Solution {
    private static final long MOD = 1_000_000_007L;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;
        int states = 2 * m;
        
        // Handle the base case where length is 1
        if (n == 1) {
            return m;
        }

        // T is the transition matrix of size (2m) x (2m)
        long[][] T = new long[states][states];

        // Define transitions
        // State 0 to m-1: Last move was strictly increasing (UP), so next must be strictly decreasing (DOWN)
        // State m to 2m-1: Last move was strictly decreasing (DOWN), so next must be strictly increasing (UP)
        for (int x = 0; x < m; x++) {
            int upState = x;
            int downState = x + m;

            // From an UP state ending at x, we must go DOWN to a smaller value y (y < x)
            for (int y = 0; y < x; y++) {
                T[y + m][upState] = 1;
            }

            // From a DOWN state ending at x, we must go UP to a larger value y (y > x)
            for (int y = x + 1; y < m; y++) {
                T[y][downState] = 1;
            }
        }

        // Compute T^(n-1) using binary exponentiation
        long[][] P = power(T, n - 1);

        // Initial state vector representing arrays of length 1.
        // For length 1, any value can transition either up or down next.
        long[] start = new long[states];
        for (int x = 0; x < m; x++) {
            start[x] = 1;     // ready to go DOWN
            start[x + m] = 1; // ready to go UP
        }

        // Multiply the resulting matrix with the starting vector
        long[] finalVec = multiply(P, start);

        // Accumulate all possibilities to find the total answer
        long ans = 0;
        for (long val : finalVec) {
            ans = (ans + val) % MOD;
        }

        return (int) ans;
    }

    // Performs Matrix Exponentiation: Base^exp % MOD
    private long[][] power(long[][] base, long exp) {
        int size = base.length;
        long[][] res = new long[size][size];
        for (int i = 0; i < size; i++) {
            res[i][i] = 1;
        }
        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = multiply(res, base);
            }
            base = multiply(base, base);
            exp >>= 1;
        }
        return res;
    }

    // Matrix multiplication: A * B
    private long[][] multiply(long[][] A, long[][] B) {
        int size = A.length;
        long[][] C = new long[size][size];
        for (int i = 0; i < size; i++) {
            for (int k = 0; k < size; k++) {
                if (A[i][k] == 0) continue;
                for (int j = 0; j < size; j++) {
                    C[i][j] = (C[i][j] + A[i][k] * B[k][j]) % MOD;
                }
            }
        }
        return C;
    }

    // Matrix-Vector multiplication: A * v
    private long[] multiply(long[][] A, long[] v) {
        int size = A.length;
        long[] res = new long[size];
        for (int i = 0; i < size; i++) {
            long cur = 0;
            for (int j = 0; j < size; j++) {
                if (A[i][j] == 0) continue;
                cur = (cur + A[i][j] * v[j]) % MOD;
            }
            res[i] = cur;
        }
        return res;
    }
}