class Solution {
    static final int MOD = 1_000_000_007;

    public int subsequencePairCount(int[] nums) {
        long[][] dp = new long[201][201];

        dp[0][0] = 1;

        for (int x : nums) {
            long[][] next = new long[201][201];

            for (int g1 = 0; g1 <= 200; g1++) {
                for (int g2 = 0; g2 <= 200; g2++) {

                    if (dp[g1][g2] == 0)
                        continue;

                    long ways = dp[g1][g2];

                    // 1. Skip x
                    next[g1][g2] =
                        (next[g1][g2] + ways) % MOD;

                    // 2. Put x in seq1
                    int newG1 = gcd(g1, x);

                    next[newG1][g2] =
                        (next[newG1][g2] + ways) % MOD;

                    // 3. Put x in seq2
                    int newG2 = gcd(g2, x);

                    next[g1][newG2] =
                        (next[g1][newG2] + ways) % MOD;
                }
            }

            dp = next;
        }

        long answer = 0;

        for (int g = 1; g <= 200; g++) {
            answer = (answer + dp[g][g]) % MOD;
        }

        return (int) answer;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int rem = a % b;
            a = b;
            b = rem;
        }

        return a;
    }
}