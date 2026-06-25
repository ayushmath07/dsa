class Solution {
    static final long MOD = 1_000_000_007L;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;

        if (n == 2) {
            return (int)((long)m * (m - 1) % MOD);
        }

        int S = 2 * m;

        long[][] T = new long[S][S];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < i; j++) {
                T[i][m + j] = 1;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                T[m + i][j] = 1;
            }
        }

        long[] init = new long[S];

        for (int i = 0; i < m; i++) {
            init[i] = i;           
            init[m + i] = m - 1 - i; 
        }

        long[][] P = matrixPower(T, n - 2);

        long[] res = multiply(P, init);

        long ans = 0;
        for (long x : res) {
            ans += x;
            ans %= MOD;
        }

        return (int) ans;
    }

    private long[] multiply(long[][] A, long[] v) {
        int n = A.length;
        long[] res = new long[n];

        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = 0; j < n; j++) {
                sum = (sum + A[i][j] * v[j]) % MOD;
            }
            res[i] = sum;
        }

        return res;
    }

    private long[][] matrixPower(long[][] A, long exp) {
        int n = A.length;

        long[][] res = new long[n][n];
        for (int i = 0; i < n; i++) res[i][i] = 1;

        while (exp > 0) {
            if ((exp & 1) == 1)
                res = multiply(res, A);
            A = multiply(A, A);
            exp >>= 1;
        }

        return res;
    }

    private long[][] multiply(long[][] A, long[][] B) {
        int n = A.length;
        long[][] C = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (A[i][k] == 0) continue;
                long val = A[i][k];
                for (int j = 0; j < n; j++) {
                    if (B[k][j] == 0) continue;
                    C[i][j] = (C[i][j] + val * B[k][j]) % MOD;
                }
            }
        }

        return C;
    }
}