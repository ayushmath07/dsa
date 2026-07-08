class Solution {
    static final int MOD = 1_000_000_007;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int m = s.length();

        ArrayList<Integer> posList = new ArrayList<>();
        ArrayList<Integer> digList = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int d = s.charAt(i) - '0';
            if (d != 0) {
                posList.add(i);
                digList.add(d);
            }
        }

        int n = posList.size();

        int[] pos = new int[n];
        int[] digit = new int[n];

        for (int i = 0; i < n; i++) {
            pos[i] = posList.get(i);
            digit[i] = digList.get(i);
        }

        long[] pow10 = new long[n + 1];
        pow10[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }

        long[] prefVal = new long[n + 1];
        int[] prefSum = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefVal[i + 1] = (prefVal[i] * 10 + digit[i]) % MOD;
            prefSum[i + 1] = prefSum[i] + digit[i];
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            int left = lowerBound(pos, l);
            int right = upperBound(pos, r) - 1;

            if (left > right) {
                ans[i] = 0;
                continue;
            }

            int len = right - left + 1;

            long x = prefVal[right + 1]
                    - (prefVal[left] * pow10[len]) % MOD;

            if (x < 0) x += MOD;

            long sum = prefSum[right + 1] - prefSum[left];

            ans[i] = (int) ((x * sum) % MOD);
        }

        return ans;
    }

    private int lowerBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (arr[mid] >= target) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    private int upperBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (arr[mid] > target) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}