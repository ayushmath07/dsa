class Solution {
    public int missingInteger(int[] nums) {
        int pref = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                pref += nums[i];
            } else {
                break;
            }
        }

        boolean[] present = new boolean[1001];

        for (int num : nums) {
            if (num < present.length) {
                present[num] = true;
            }
        }

        while (pref < present.length && present[pref]) {
            pref++;
        }

        return pref;
    }
}