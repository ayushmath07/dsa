import java.util.*;

class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Long, Integer> freq = new HashMap<>();

        for (int x : nums) {
            freq.put((long) x, freq.getOrDefault((long) x, 0) + 1);
        }

        int ans = 1;

        // Special case for 1
        if (freq.containsKey(1L)) {
            int f = freq.get(1L);
            ans = Math.max(ans, (f % 2 == 1) ? f : f - 1);
        }

        for (long x : freq.keySet()) {
            if (x == 1) continue;

            long cur = x;
            int len = 0;

            while (freq.getOrDefault(cur, 0) >= 2) {
                len += 2;

                if (cur > 31622 || !freq.containsKey(cur * cur)) {
                    len--;
                    break;
                }

                cur = cur * cur;
            }

            if (freq.getOrDefault(cur, 0) == 1) {
                len++;
            }

            ans = Math.max(ans, len);
        }

        return ans;
    }
}