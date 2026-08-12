class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        int l = 0;
        int res = 0;

        for (int r = 0; r < nums.length; r++) {

            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);

            while (map.get(nums[r]) > k) {

                int val = map.get(nums[l]);

                if (val == 1) {
                    map.remove(nums[l]);
                } else {
                    map.put(nums[l], val - 1);
                }

                l++;
            }

            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}