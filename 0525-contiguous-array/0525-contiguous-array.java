class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int one =0, zero = 0;
        int res = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1) one++;
            else zero++;
            int diff = one - zero;
            if(diff == 0) res = Math.max(res, i+1);
            if(map.containsKey(diff)) res = Math.max(res,i-map.get(diff));
            else map.put(diff,i);
        }
        return res;
    }
}